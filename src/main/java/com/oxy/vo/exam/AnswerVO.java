package com.oxy.vo.exam;

import lombok.Data;

/**
 * @author lil1
 * @date 2019年4月17日 上午11:24:55
 * @Description 
 */
@Data
public class AnswerVO{
	private Integer questionId;
	/**
	 * 试卷类型1-判断题 2-选择题
	 */
	private String type;
	/**
	 * 考生答案
	 */
	private String userAnswer;
	/**
	 * 正确答案
	 */
	private String answer;
	/**
	 * 分值
	 */
	private Integer value;
	
	
	
}
