package com.oxy.vo.exam;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.oxy.config.CurrentUser;
import com.oxy.constant.ExamConstant.ExamStatus;
import com.oxy.model.Examination;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * @author lil1
 * @date 2019年4月16日 下午12:27:42
 * @Description 
 */
@Data
public class AddExamVO {
	/**
	 * 科目
	 */
	@NotBlank
	private String  subject;
	
	/**
	 * 考试名
	 */
	@NotBlank
	private String  examName;
	
	/**
	 * 试卷id
	 */
	@NotBlank
	private Integer  paperId;
	
	/**
	 * 考试时间
	 */
	@NotBlank
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",locale="zh",timezone = "GMT+8")
	private Date  beginTime;
	
	/**
	 * 考试时长
	 */
	@NotBlank
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",locale="zh",timezone = "GMT+8")
	private Date  endTime;
	
	/**
	 * 创建人
	 */
	@NotBlank
	private String createUser;
	
	
	/**
	 * 考试班级{id:name}
	 */
	@NotEmpty
	private List<String> classIds;


	public void toExam(AddExamVO vo, Examination exam) {
		exam.setSubject(vo.getSubject());
		exam.setExamname(vo.getExamName());
		exam.setBegintime(vo.getBeginTime());
		exam.setCreateuser(CurrentUser.getCurrentUserCode()+"");
		exam.setEndtime(vo.getEndTime());
		exam.setPaperid(vo.getPaperId());
		exam.setStatus(ExamStatus.NOT_BEGIN.index);
		exam.setClassids(JSON.toJSONString(vo.getClassIds()));
	}
	
	
	
}
