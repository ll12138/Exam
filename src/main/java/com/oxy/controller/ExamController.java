package com.oxy.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.oxy.service.ExamService;
import com.oxy.utils.JsonResult2;
import com.oxy.utils.PageResult;
import com.oxy.vo.exam.PageGradeVO;
import com.oxy.vo.exam.SubmitExam;

/**
 * @author lil1
 * @date 2019年4月17日 上午10:25:50
 * @Description 考试\成绩\分析
 */
@RestController
@RequestMapping("/exam")
@CrossOrigin
public class ExamController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ExamController.class);

	@Autowired
	private ExamService examService;

	
	/**
	 * @Description 获取试卷题目(开始考试) 或者试卷分析
	 * @param examId
	 * @param paperId
	 * @param isAnalyze true-试卷分析 false-获取试题
	 */
	@GetMapping("/paper")
	public JsonResult2 getPaperContent(@RequestParam(value = "examId", required = true) Integer examId,
			@RequestParam(value = "paperId", required = true) Integer paperId,
			@RequestParam(value = "isAnalyze", required = true) boolean isAnalyze) {
		Map<String, Object> map = examService.getPaperContent(examId,paperId, isAnalyze);
		return JsonResult2.success(map);
	}

	/**
	 * @Description 随时保存\最终提交 答卷
	 * @param vo
	 */
	@PostMapping("/submit")
	public JsonResult2 submitAnswer(@RequestBody SubmitExam vo) {
		LOGGER.info("submitAnswer(),req{}", JSON.toJSONString(vo));
		examService.submitAnswer(vo);
		return JsonResult2.success();
	}

	/**
	 * @Description 查询成绩列表
	 * @param vo 
	 */
	@PostMapping("/grade")
	public JsonResult2 getGradePage(@RequestBody PageGradeVO vo) {
		LOGGER.info("getGradePage(),req{}", JSON.toJSONString(vo));
		List<LinkedHashMap<String, Object>> list = examService.getGradePage(vo, true);
		return JsonResult2.success(new PageResult(new PageInfo<>(list)));
	}

	/**
	 * @Description 成绩导出
	 * @param classId
	 * @param subject
	 * @param paperName
	 * @param examName
	 * @return JsonResult2
	 */
	@GetMapping("/download")
	public JsonResult2 downLoadGrade(@RequestParam(value = "classId", required = false) Integer classId,
			@RequestParam(value = "subject", required = false) String subject,
			@RequestParam(value = "paperName", required = false) String paperName,
			@RequestParam(value = "examName", required = false) String examName,
			@RequestParam(value = "isStudent", required = true) boolean isStudent,HttpServletResponse response) {
		examService.downLoadGrade(classId, subject, paperName, examName, response,isStudent);
		return JsonResult2.success();
	}

}
