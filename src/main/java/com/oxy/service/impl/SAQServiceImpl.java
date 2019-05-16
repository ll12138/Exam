package com.oxy.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Objects;
import com.oxy.config.CurrentUser;
import com.oxy.constant.ExamConstant.QuestionLevel;
import com.oxy.constant.ExamConstant.QuestionType;
import com.oxy.dao.SAQMapper;
import com.oxy.dao.ext.ExtSAQMapper;
import com.oxy.dao.ext.ExtSingleselectMapper;
import com.oxy.dao.ext.ExtUserMapper;
import com.oxy.dto.itemBank.PageSaqDTO;
import com.oxy.model.SAQ;
import com.oxy.model.Singleselect;
import com.oxy.model.User;
import com.oxy.service.SAQService;
import com.oxy.utils.AssertApp;
import com.oxy.utils.ServiceOperationException;
import com.oxy.vo.itemBank.AddSaqVO;
import com.oxy.vo.itemBank.PageSaqVO;
import com.oxy.vo.itemBank.UpdateSaqVO;
import com.oxy.vo.saq.ImportExcelVO;

@Service
public class SAQServiceImpl implements SAQService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SAQServiceImpl.class);

	@Autowired
	private SAQMapper saqMapper;
	@Resource
	private ExtSAQMapper extSAQMapper;
	@Resource
	private ExtSingleselectMapper extSingleMapper;
	@Resource
	private ExtUserMapper extUserMapper;

	@Override
	public PageInfo<PageSaqDTO> page(PageSaqVO vo) {
		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
		PageSaqDTO dto = PageSaqDTO.builder().question(vo.getQuestion()).subject(vo.getSubject())
				.chapter(vo.getChapter()).createuser(vo.getCreateuser()).build();
		PageInfo<PageSaqDTO> pageInfo = new PageInfo<>(extSAQMapper.listPage(dto));
		LOGGER.info("page(),resp{}", dto);
		return pageInfo;
	}

	@Override
	@Transactional
	public void insert(AddSaqVO vo) {
		SAQ saq = vo.toSAQ();
		saqMapper.insert(saq);
	}

	@Override
	@Transactional
	public void update(UpdateSaqVO vo) {
		SAQ saq = saqMapper.selectByPrimaryKey(vo.getSaqid());
		if (saq == null) {
			throw new ServiceOperationException(-2, "当前无此简答题信息，请刷新页面");
		}
		saqMapper.updateByPrimaryKeySelective(vo.toSAQ());
	}

	@Override
	@Transactional
	public void delete(int saqid) {
		saqMapper.deleteByPrimaryKey(saqid);
	}

	/**
	 * @Description 导入题库
	 */
	@Override
	@Transactional
	public void importExcel(MultipartFile file, ImportExcelVO vo) {
		String docName = file.getOriginalFilename();
		// .xlsx .xls
		String suffix = docName.substring(docName.indexOf("."));
		InputStream in = null;
		Workbook workbook = null;
		Sheet sheet = null;
		Row row = null;
		int startRow = 1;
		try {
			in = file.getInputStream();
			if (".xlsx".equals(suffix)) {
				workbook = new XSSFWorkbook(in);
			} else if (".xls".equals(suffix)) {
				workbook = new HSSFWorkbook(in);
			} else {
				throw new ServiceOperationException(-2, "请上传.xlsx .xls文件");
			}
			sheet = workbook.getSheetAt(0);
			// Excel最后一行数与列数
			int lastRow = sheet.getLastRowNum();
			int coloumNum = sheet.getRow(startRow).getPhysicalNumberOfCells();

			if (Objects.equal(vo.getType(), QuestionType.SINGLE.index)) {
				if (coloumNum != 10) {
					throw new ServiceOperationException(-2, "数据格式有误！！！请重新编排数据");
				}
				List<Singleselect> singleList = new ArrayList<>();

				for (int i = startRow + 1; i <= lastRow; i++) {
					row = sheet.getRow(i);
					Singleselect single = new Singleselect();
					single.setQuestion(getCellString(row.getCell(1)));
					single.setChoiceone(getCellString(row.getCell(2)));
					single.setChoicetwo(getCellString(row.getCell(3)));
					single.setChoicethree(getCellString(row.getCell(4)));
					single.setChoicefour(getCellString(row.getCell(5)));
					single.setAnswer(getCellString(row.getCell(6)));
					single.setSubject(getCellString(row.getCell(7)));
					single.setChapter(getCellString(row.getCell(8)));
					String level = getCellString(row.getCell(9));
					single.setDifficulty(QuestionLevel.getIndex(level));
					singleList.add(single);
				}

				// 批量插入
				extSingleMapper.addSingleList(singleList, CurrentUser.getCurrentUserCode() + "");

			}
			if (Objects.equal(vo.getType(), QuestionType.SAQ.index)) {
				if (coloumNum != 6) {
					throw new ServiceOperationException(-2, "数据格式有误！！！请重新编排数据");
				}
				List<SAQ> saqList = new ArrayList<>();
				for (int i = startRow + 1; i <= lastRow; i++) {
					row = sheet.getRow(i);
					SAQ saq = new SAQ();
					saq.setQuestion(getCellString(row.getCell(1)));
					saq.setAnswer(getCellString(row.getCell(2)));
					saq.setSubject(getCellString(row.getCell(3)));
					saq.setChapter(getCellString(row.getCell(4)));
					String level = getCellString(row.getCell(5));
					saq.setDifficulty(QuestionLevel.getIndex(level));
					saqList.add(saq);
				}
				// 批量插入
				extSAQMapper.addSaqList(saqList, CurrentUser.getCurrentUserCode() + "");
			}
			if (Objects.equal(vo.getType(), QuestionType.STUDENT.index)) {
				AssertApp.notNull(vo.getClassId(), "班级不能为空");
				if (coloumNum != 3) {
					throw new ServiceOperationException(-2, "数据格式有误！！！请重新编排数据");
				}
				List<User> userList = new ArrayList<>();

				for (int i = startRow + 1; i <= lastRow; i++) {
					row = sheet.getRow(i);
					User user = new User();
					user.setUsercode(getCellString(row.getCell(0)));
					user.setName(getCellString(row.getCell(1)));
					user.setPassword(getCellString(row.getCell(2)));
					user.setRole("学生");
					user.setClassid(vo.getClassId());
					userList.add(user);
				}
				// 批量插入user表
				extUserMapper.addUserList(userList);
				// 批量插入班级-学生表
			}
		} catch (IOException e) {
			LOGGER.info("读取模板文件发生异常,{}", e);
			throw new ServiceOperationException(-2, "读取模板文件发生异常");
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (workbook != null) {
					workbook.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private String getCellString(Cell cell) {
		if (cell == null)
			return null;
		cell.setCellType(CellType.STRING);
		return cell.getStringCellValue();

	}

}
