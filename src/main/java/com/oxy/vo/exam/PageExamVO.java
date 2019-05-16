package com.oxy.vo.exam;

import com.oxy.vo.BasePageVO;

import lombok.Data;

/**
 * @author lil1
 * @date 2019年4月16日 下午4:38:58
 * @Description 
 */
@Data
public class PageExamVO extends BasePageVO{
	//考试名、试卷名、创建人、考试班级 状态
	private String examName;
	private String paperName;
	private String createName;
	private String status;
	
	/**
	 * 班级下拉框传班级id
	 */
	private String classId; 
	
}
