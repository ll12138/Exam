package com.oxy.vo.classes;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author lil1
 * @date 2019年4月15日 下午7:34:52
 * @Description 
 */
@Getter
@Setter
@ToString
public class UpdateClassVO extends AddClassVO{
	@NotBlank
	private Integer classid;
}
