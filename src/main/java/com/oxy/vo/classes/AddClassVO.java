package com.oxy.vo.classes;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author lil1
 * @date 2019年4月15日 下午6:53:50
 * @Description 
 */
@Getter
@Setter
@ToString
public class AddClassVO {
	
	/**
	 * 班级名
	 */
	@NotBlank
	private String name;
	
	/**
	 * 学生ids
	 */
	private List<Integer> userIds;
}
