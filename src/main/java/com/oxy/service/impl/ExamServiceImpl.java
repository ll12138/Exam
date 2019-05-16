package com.oxy.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Objects;
import com.oxy.config.CurrentUser;
import com.oxy.constant.ExamConstant.QuestionType;
import com.oxy.dao.ScoreMapper;
import com.oxy.dao.UserAnswerMapper;
import com.oxy.dao.ext.ExtAnswerMapper;
import com.oxy.model.Score;
import com.oxy.model.UserAnswer;
import com.oxy.service.ExamService;
import com.oxy.utils.ExcelUtils;
import com.oxy.utils.MapUtils;
import com.oxy.utils.ServiceOperationException;
import com.oxy.vo.exam.AnswerVO;
import com.oxy.vo.exam.PageGradeVO;
import com.oxy.vo.exam.SubmitExam;

/**
 * @author lil1
 * @date 2019年4月17日 上午10:28:00
 * @Description
 */
@Service
public class ExamServiceImpl implements ExamService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ExamServiceImpl.class);

	@Autowired
	private ScoreMapper scoreMapper;
	@Autowired
	private ExtAnswerMapper extAnswerMapper;
	@Autowired
	private UserAnswerMapper answerMapper;

	@Value(value = "${score.template.path}")
	private String scoreUrl;

	@Override
	@Transactional
	public void submitAnswer(SubmitExam vo) {
		Integer saqSum = 0;
		Integer singleSum = 0;
		Score score = new Score();
		List<UserAnswer> listAnswer = new ArrayList<>();

		score.setExamid(vo.getExamId());
		score.setPaperid(vo.getPaperId());
		score.setUserid(CurrentUser.getCurrentUserCode());

		for (AnswerVO ans : vo.getAnswerList()) {
			UserAnswer answer = new UserAnswer();
			answer.setExamid(vo.getExamId());
			answer.setPaperid(vo.getPaperId());
			answer.setQuestionid(ans.getQuestionId());
			answer.setType(ans.getType());
			answer.setUseranswer(ans.getUserAnswer());
			answer.setAnswer(ans.getAnswer());
			answer.setIscorrrent(Objects.equal(ans.getAnswer(), ans.getUserAnswer()) ? true : false);
			answer.setUserid(CurrentUser.getCurrentUserCode());
			if (Objects.equal(ans.getAnswer(), ans.getUserAnswer())) {
				if (QuestionType.SAQ.index.equals(ans.getType())) {
					saqSum += ans.getValue();
				}
				if (QuestionType.SINGLE.index.equals(ans.getType())) {
					singleSum += ans.getValue();
				}
			}
			listAnswer.add(answer);
		}
		// 删除原来的记录,保存最新答案
		for (UserAnswer ans : listAnswer) {
			answerMapper.deleteByPrimaryKey(ans);
		}
		extAnswerMapper.insertAnswer(listAnswer);
		// 最终提交
		if (vo.getIsSumbit()) {
			scoreMapper.deleteByPrimaryKey(score);
			score.setScore(singleSum + saqSum + "");
			scoreMapper.insert(score);
		}

	}

	@Override
	public void downLoadGrade(Integer classId, String subject, String paperName, String examName,
			HttpServletResponse response,boolean isStudent) {
		PageGradeVO vo = new PageGradeVO();
		vo.setClassId(classId);
		vo.setExamName(examName);
		vo.setIsStudent(isStudent);
		vo.setPaperName(paperName);
		vo.setSubject(subject);
		List<LinkedHashMap<String, Object>> list = getGradePage(vo,false);

		InputStream inputStream = null;
		XSSFWorkbook workbook = null;
		XSSFSheet sheet = null;
		XSSFCell cell = null;
		OutputStream out = null;
		String docName = "成绩表.xlsx";
		try {
			inputStream = this.getClass().getClassLoader().getResourceAsStream(scoreUrl);
			workbook = new XSSFWorkbook(inputStream);
			sheet = workbook.getSheetAt(0);

			int startRow = 2;
			short height = sheet.getRow(startRow).getHeight();
			int lastRowNo = sheet.getLastRowNum();

			XSSFCellStyle style = sheet.getRow(startRow).getCell(0).getCellStyle();
			// 定义excel列与字段名的关系的顺序
			Map<Object, Object> excelClo = MapUtils.build(7).put(0, "code").put(1, "name").put(2, "className")
					.put(3, "examName").put(4, "subject").put(5, "paperName").put(6, "score").map();
			for (LinkedHashMap<String, Object> dto : list) {
				// 插入1行
				sheet.shiftRows(startRow, lastRowNo, 1);
				XSSFRow row = sheet.createRow(startRow);
				row.setHeight(height);
				startRow++;
				lastRowNo++;
				for (Object clo : excelClo.keySet()) {
					int i = (Integer) clo;
					cell = row.createCell(i);
					cell.setCellStyle(style);
					String key = (String) excelClo.get(i);
					String msg = JSON.parseObject(JSON.toJSONString(dto.get(key)), String.class);
					cell.setCellValue(msg);

				}
			}
			// sheet.removeRow(sheet.getRow(lastRowNo-1));
			// 删除最后空白一行(上移)
			sheet.shiftRows(lastRowNo + 1, lastRowNo + 1, -1);

			ExcelUtils.excelToResponse(workbook, response, docName);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.info("读取模板文件发生异常,{}", e);
			throw new ServiceOperationException(-2, "读取模板文件发生异常");
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
				if (workbook != null) {
					workbook.close();
				}
				if (out != null) {
					out.flush();
					out.close();
				}
			} catch (IOException e) {
				LOGGER.info("读取模板文件发生异常,{}", e);
				throw new ServiceOperationException(-2, "读取模板文件发生异常");
			}
		}

	}

	@Override
	public List<LinkedHashMap<String, Object>> getGradePage(PageGradeVO vo, boolean isPage) {
		List<LinkedHashMap<String, Object>> list = extAnswerMapper.getScoreList(vo,CurrentUser.getCurrentUserCode());
		LOGGER.info("getGradePage(),resp{}", JSON.toJSONString(list));
		return list;
	}

	@Override
	public Map<String, Object> getPaperContent(Integer examId, Integer paperId, boolean isAnalyze) {
		Map<String, Object> map = new HashMap<>();
		//获取saq
		List<LinkedHashMap<String, Object>> saqList = extAnswerMapper.getSAQList(examId,paperId,isAnalyze,QuestionType.SAQ.index);
		map.put("saq", saqList);
		//获取single
		List<LinkedHashMap<String, Object>> singleList = extAnswerMapper.getSingleList(examId,paperId,isAnalyze,QuestionType.SINGLE.index);
		map.put("single", singleList);
		
		return map;
	}


}
