package com.oxy.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.oxy.constant.ExamConstant.ExamStatus;
import com.oxy.service.ExamArrangeService;
import com.oxy.utils.JsonResult2;
import com.oxy.utils.PageResult;
import com.oxy.vo.BaseDeleteVO;
import com.oxy.vo.exam.AddExamVO;
import com.oxy.vo.exam.PageExamVO;
import com.oxy.vo.exam.UpdateExamVO;

/**
 * @author lil1
 * @date 2019年4月16日 上午10:26:16
 * @Description 考试安排
 */
@RestController
@RequestMapping("/arrange")
@CrossOrigin
public class ExamArrangeController extends BaseController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ExamArrangeController.class);

	@Autowired
	private ExamArrangeService examService;

	/**
	 * @Description 考试安排状态下拉表
	 * @return
	 */
	@GetMapping
	public JsonResult2 getStatusConstant() {
		return JsonResult2.success(ExamStatus.getContant());
	}

	@PostMapping
	public JsonResult2 addExam(@RequestBody AddExamVO vo) {
		LOGGER.info("addExam(),req{}", vo.toString());
		examService.addExam(vo);
		return JsonResult2.success();
	}

	@PutMapping
	public JsonResult2 updateExam(@RequestBody UpdateExamVO vo) {
		LOGGER.info("updateExam(),req{}", vo.toString());
		examService.updateExam(vo);
		return JsonResult2.success();
	}

	@DeleteMapping("/")
	public JsonResult2 deleteExam(@RequestBody BaseDeleteVO vo) {
		LOGGER.info("deleteExam(),req{}", JSON.toJSONString(vo));
		examService.deleteExam(vo);
		return JsonResult2.success();
	}

	@PostMapping("/page")
	public JsonResult2 getPage(@RequestBody PageExamVO vo) {
		LOGGER.info("getPage(),req{}", vo.toString());
		List<LinkedHashMap<String, Object>> list = examService.getPage(vo);
		return JsonResult2.success(new PageResult(new PageInfo<>(list)));
	}

}
