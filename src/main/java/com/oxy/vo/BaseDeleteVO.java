package com.oxy.vo;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * @author lil1
 * @date 2019年4月15日 下午6:19:05
 * @Description 
 */
@Getter
@Setter
@ToString
public class BaseDeleteVO {
	@NotNull
	@Min(1)
	private List<Integer> ids;
}