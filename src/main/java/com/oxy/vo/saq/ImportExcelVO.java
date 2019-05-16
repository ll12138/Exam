package com.oxy.vo.saq;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import com.oxy.constant.ExamConstant.QuestionType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author lil1
 * @date 2019年1月9日 下午2:49:45
 * @Description
 */
@Getter
@Setter
@ToString
public class ImportExcelVO {

	/**
	 * 文件类型(判断\单选\学生)
	 */
	@NotBlank
	@Pattern(regexp=QuestionType.REG,message="文件类型错误")
	private String type;
	
	/**
	 * 班级
	 */
	private Integer classId;
	
}
