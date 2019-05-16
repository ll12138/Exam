package com.oxy.config;

import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.authc.UserFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.oxy.utils.JsonResult2;

public class ShiroUserFilter extends UserFilter {

	private final Logger LOGGER = LoggerFactory.getLogger(ShiroUserFilter.class);

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

		if (isLoginRequest(request, response)) {
			return true;
		}
		LOGGER.info("非法调用");
		PrintWriter writer = response.getWriter();
		writer.print(JSON.toJSONString(JsonResult2.illegal("非法调用")));
		writer.close();
		response.flushBuffer();
		return false;
//		return true;
	}
}
