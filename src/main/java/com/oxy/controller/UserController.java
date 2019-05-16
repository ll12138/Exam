package com.oxy.controller;

import javax.annotation.Resource;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oxy.service.UserService;
import com.oxy.utils.JsonResult;
import com.oxy.vo.user.AddUserVO;
import com.oxy.vo.user.DeleteUserVO;
import com.oxy.vo.user.PageUserVO;
import com.oxy.vo.user.UpdateUserVO;

/**
 * @date 2019年3月20日上午10:19:35
 * @Description 用户管理控制器
 */
@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController extends BaseController {
	@Resource
	private UserService userService;

	@RequestMapping(value = "/page", method = RequestMethod.POST, produces = { "application/json;charset=utf-8" })
	public JsonResult pageResult(@Validated @RequestBody PageUserVO vo) {
		return new JsonResult(0, userService.page(vo), "成功");
	}

	@RequestMapping(value = "/", method = RequestMethod.POST, produces = { "application/json;charset=utf-8" })
	public JsonResult add(@Validated @RequestBody AddUserVO vo) {
		userService.insert(vo);
		return new JsonResult(0, "添加成功");
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT, produces = { "application/json;charset=utf-8" })
	public JsonResult update(@Validated @RequestBody UpdateUserVO vo) {
		userService.update(vo);
		return new JsonResult(0, "更新成功");
	}

	@RequestMapping(value = "/", method = RequestMethod.DELETE, produces = { "application/json;charset=utf-8" })
	public JsonResult delete(@RequestBody DeleteUserVO vo) {
		userService.delete(vo.getUsercode());
		return new JsonResult(0, "删除成功");
	}
}
