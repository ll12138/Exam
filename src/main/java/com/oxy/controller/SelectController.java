package com.oxy.controller;

import javax.annotation.Resource;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oxy.service.SelectService;
import com.oxy.utils.JsonResult;
import com.oxy.vo.itemBank.AddSelectVO;
import com.oxy.vo.itemBank.DeleteSelectVO;
import com.oxy.vo.itemBank.PageSelectVO;
import com.oxy.vo.itemBank.UpdateSelectVO;

/**
 * @date 2019年3月20日上午10:19:35
 * @Description 单选题控制器
 */
@RestController
@RequestMapping("/select")
@CrossOrigin
public class SelectController extends BaseController {
	@Resource
	private SelectService selectService;

	@RequestMapping(value = "/", method = RequestMethod.POST, produces = { "application/json;charset=utf-8" })
	public JsonResult add(@Validated @RequestBody AddSelectVO vo) {
		selectService.insert(vo);
		return new JsonResult(0, "添加成功");
	}

	@RequestMapping(value = "/page", method = RequestMethod.POST, produces = { "application/json;charset=utf-8" })
	public JsonResult pageResult(@Validated @RequestBody PageSelectVO vo) {
		return new JsonResult(0, selectService.page(vo), "成功");
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT, produces = { "application/json;charset=utf-8" })
	public JsonResult update(@Validated @RequestBody UpdateSelectVO vo) {
		selectService.update(vo);
		return new JsonResult(0, "更新成功");
	}

	@RequestMapping(value = "/", method = RequestMethod.DELETE, produces = { "application/json;charset=utf-8" })
	public JsonResult delete(@RequestBody DeleteSelectVO vo) {
		selectService.delete(vo.getQuestionid());
		return new JsonResult(0, "删除成功");
	}
}
