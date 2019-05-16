package com.oxy.utils;
import org.apache.ibatis.annotations.ResultType;

import com.google.common.base.Strings;

/**
 * 用于封装RESTful调用返回结果
 */
public class JsonResult2 {

  /**
   * 调用是否成功标识，0：成功，-2:失败, -1:非法调用
   */
  private int code;

  /**
   * 调用结果
   */
  private Object data;

  /**
   * 结果消息，如果调用成功，消息通常为空
   */
  private String msg;

  /**
   * for JSON.parseObject(jsonString, JsonResult2.class)
   */
  public JsonResult2() {
  }

  /**
   * @param code 代码
   * @param data 结果
   * @param msg 消息
   */
  public JsonResult2(int code, Object data, String msg) {
    this.code = code;
    this.data = data;
    this.msg = msg;
  }

  /**
   * @param code 代码
   * @param msg 消息
   */
  public JsonResult2(int code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  /**
   * 请求成功消息
   */
  public static JsonResult2 success() {
    return new JsonResult2(0, "访问成功");
  }
  /**
   * 请求成功消息
   */
  public static JsonResult2 success(ResultType type) {
	  return new JsonResult2(0, type.toString()+"成功");
  }

  /**
   * 请求成功消息
   */
  public static JsonResult2 success(Object data) {
    return new JsonResult2(0, data, "访问成功");
  }

  /**
   * 请求成功方法 ，data返回值，msg提示信息
   */
  public static JsonResult2 success(Object data, String msg) {
    return new JsonResult2(0, data, msg);
  }
  
  /**
   * 请求成功方法 ，data返回值，msg提示信息
   */
  public static JsonResult2 success(Object data, ResultType type) {
	  return new JsonResult2(0, data, type.toString()+"成功");
  }

  /**
   * 请求失败消息
   */
  public static JsonResult2 fail(String msg) {
    return new JsonResult2(-2, null, Strings.isNullOrEmpty(msg) ? "" : msg);
  }

 /**
   * 请求失败消息
   */
  public static JsonResult2 fail() {
    return new JsonResult2(-2, null, "请求失败");
  }

  /**
   * 请求失败消息，根据异常类型，获取不同的提供消息
   *
   * @param throwable 异常
   */
  public static JsonResult2 fail(Throwable throwable) {
    return fail(throwable.getMessage());
  }

  /**
   * 非法请求消息
   */
  public static JsonResult2 illegal(String msg) {
    return new JsonResult2(-1, null, msg);
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }
}
