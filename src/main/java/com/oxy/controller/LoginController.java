package com.oxy.controller;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.google.common.base.Strings;
import com.oxy.config.CurrentUser;
import com.oxy.model.User;
import com.oxy.service.UserService;
import com.oxy.utils.JsonResult2;
import com.oxy.utils.ServiceOperationException;
import com.oxy.vo.user.UserLoginVO;

/**
 * @date 2019年3月20日上午10:19:35
 * @Description 登录控制器
 */
@RestController
@CrossOrigin
public class LoginController extends BaseController {
	@Resource
	private UserService userService;

	@PostMapping(value = "/login")
	public JsonResult2 login(@RequestBody UserLoginVO userLoginReq) {
		if (Strings.isNullOrEmpty(userLoginReq.getUserId())) {
			return JsonResult2.fail("用户名不能为空");
		}
		if (Strings.isNullOrEmpty(userLoginReq.getPassword())) {
			return JsonResult2.fail("密码不能为空");
		}
		/*
		 * if (Strings.isNullOrEmpty(userLoginReq.getRole())) { return
		 * JsonResult2.fail("用户类型不能为空"); }
		 */
		// 登录校验
		try {
			UsernamePasswordToken token = new UsernamePasswordToken(userLoginReq.getUserId(),
					userLoginReq.getPassword());
			Subject subject = SecurityUtils.getSubject();
			subject.login(token);
		} catch (ServiceOperationException e) {
			return JsonResult2.fail(e.getMessage());
		} catch (AuthenticationException e) {
			return JsonResult2.fail(e.getMessage());
		}

		User sysUser = userService.login(userLoginReq.getUserId(), userLoginReq.getPassword(), null);

		CurrentUser.setCurrentUser(sysUser);
		return JsonResult2.success(sysUser, "登录成功");

		/*
		 * if(userService.login(userLoginReq.getUsercode(),userLoginReq.
		 * getPassword(),userLoginReq.getRole()) != null) { String name =
		 * userService.getUser(userLoginReq.getUsercode()).getName();
		 * UserLoginDto userLoginResp = new
		 * UserLoginDto(userLoginReq.getUsercode(),name,
		 * userLoginReq.getRole()); return new
		 * JsonResult(0,userLoginResp,"登录成功"); } else { return new
		 * JsonResult(-2,"用户名、密码或用户类型有误，请重新输入"); }
		 */

	}

	@RequestMapping(value = "/showUser", method = RequestMethod.POST, produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public User getUser(@RequestBody UserLoginVO userLoginReq) {

		return userService.getUser(userLoginReq.getUserId());
	}
}
