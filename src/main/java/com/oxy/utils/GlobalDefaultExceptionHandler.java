/*package com.oxy.utils;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

*//**
 * 主动throw的异常
 *
 * @param e
 * @return
 *//*

@RestControllerAdvice
public class GlobalDefaultExceptionHandler {
	 @ExceptionHandler(ServiceException.class)
	 public JsonResult handleServiceException(ServiceException e){
		 return new JsonResult(e.getErrorCode(),e.getMessage());
	 }
}
*/