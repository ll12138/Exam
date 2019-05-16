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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.oxy.config.CurrentUser;
import com.oxy.service.ClassService;
import com.oxy.utils.JsonResult2;
import com.oxy.utils.PageResult;
import com.oxy.vo.BaseDeleteVO;
import com.oxy.vo.classes.AddClassVO;
import com.oxy.vo.classes.UpdateClassVO;

/**
 * @date 2019年4月15日 下午6:15:23
 * @Description 班级管理
 */
@RestController
@RequestMapping("/class")
@CrossOrigin
public class ClassController extends BaseController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ClassController.class);

	@Autowired
	private ClassService classService;

	/**
	 * @Description 班级列表
	 * @param name 班级名
	 * @param pageNum
	 * @param pageSize
	 */
	@GetMapping("/")
	public JsonResult2 getClassList(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "pageNum", required = true) int pageNum,
			@RequestParam(value = "pageSize", required = true) int pageSize) {
		LOGGER.info("getClassList(),req{}", name);
		Integer userid = CurrentUser.getCurrentUserCode();
		List<LinkedHashMap<String, Object>> list = classService.getClassList(name, pageNum, pageSize);
		return JsonResult2.success(new PageResult(new PageInfo<>(list)));
	}

	@PostMapping("/")
	public JsonResult2 addClass(@RequestBody AddClassVO vo) {
		LOGGER.info("addClass(),req{}", JSON.toJSONString(vo));
		classService.addClass(vo);
		return JsonResult2.success();
	}

	@PutMapping("/")
	public JsonResult2 UpdateClass(@RequestBody UpdateClassVO vo) {
		LOGGER.info("UpdateClass(),req{}", JSON.toJSONString(vo));
		classService.UpdateClass(vo);
		return JsonResult2.success();
	}

	@DeleteMapping("/")
	public JsonResult2 deleteClass(@RequestBody BaseDeleteVO vo) {
		LOGGER.info("deleteClass(),req{}", JSON.toJSONString(vo));
		classService.deleteClass(vo);
		return JsonResult2.success();
	}

}
