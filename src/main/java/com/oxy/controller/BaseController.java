package com.oxy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.oxy.utils.JsonResult2;
import com.oxy.utils.ServiceOperationException;


public abstract class BaseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

	
	/**
	 * 业务处理异常
	 */
	@ExceptionHandler({ ServiceOperationException.class })
	public JsonResult2 serviceException(ServiceOperationException e) {
		LOGGER.error("业务处理异常", e);
		return JsonResult2.fail(e.getMessage());
	}
	
	
	/**
	 * 未定义处理异常
	 */
	@ExceptionHandler({ Exception.class })
	public JsonResult2 undefinedException(Exception e) {
		LOGGER.error("未定义处理异常", e);
		return JsonResult2.fail("未定义处理异常");
	}
}