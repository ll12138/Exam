package com.oxy.config;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.alibaba.fastjson.JSON;
import com.oxy.model.User;

public class CurrentUser {

	private static final String SESSION_CURRENT_USER = "SESSION_CURRENT_USER";

	public static User getCurrentUser() {
		Subject subject = SecurityUtils.getSubject();
		Object sessionObject = subject.getSession().getAttribute(SESSION_CURRENT_USER);
		if (sessionObject != null && !"".equals(sessionObject)) {
			return JSON.parseObject(sessionObject.toString(), User.class);
		}
		return null;
	}

	public static void setCurrentUser(User User) {
		Subject subject = SecurityUtils.getSubject();
		subject.getSession().removeAttribute(SESSION_CURRENT_USER);
		subject.getSession().setAttribute(SESSION_CURRENT_USER, JSON.toJSONString(User));

	}

	public static void removeCurrentUser() {
		Subject subject = SecurityUtils.getSubject();
		subject.getSession().removeAttribute(SESSION_CURRENT_USER);
	}
	
	public static Integer getCurrentUserCode() {
		Subject subject = SecurityUtils.getSubject();
		Object sessionObject = subject.getSession().getAttribute(SESSION_CURRENT_USER);
		if (sessionObject != null && !"".equals(sessionObject)) {
			return JSON.parseObject(sessionObject.toString(), User.class).getUserid();
		}
		return null;
	}
	
	public static String getCurrentUserName() {
		Subject subject = SecurityUtils.getSubject();
		Object sessionObject = subject.getSession().getAttribute(SESSION_CURRENT_USER);
		if (sessionObject != null && !"".equals(sessionObject)) {
			return JSON.parseObject(sessionObject.toString(), User.class).getName();
		}
		return null;
	}
}