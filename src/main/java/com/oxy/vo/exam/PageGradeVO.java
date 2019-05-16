package com.oxy.vo.exam;


import javax.validation.constraints.NotNull;

import com.oxy.vo.BasePageVO;

import lombok.Data;

/**
 * @author lil1
 * @date 2019年4月17日 下午3:01:16
 * @Description 
 */
@Data
public class PageGradeVO extends BasePageVO{
	private String examName;
	private String paperName;
	private String subject;
	/**
	 * 学生只能查看自己的成绩
	 */
	@NotNull
	private Boolean isStudent;
	
	/**
	 * 班级下拉框传班级id
	 */
	private Integer classId;
	
}
