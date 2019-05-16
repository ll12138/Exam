package com.oxy.vo.exam;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

/**
 * @author lil1
 * @date 2019年4月17日 上午11:05:49
 * @Description 
 */
@Data
public class SubmitExam {
	@NotNull
	private Integer examId;
	@NotNull
	private Integer paperId;
	
	/**
	 * 是否最终提交 (否-前端定时保存 )
	 */
	@NotNull
	private Boolean isSumbit;
	
	@NotEmpty
	private List<AnswerVO> answerList;
	
}
