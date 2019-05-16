package com.oxy.vo.user;

import lombok.Data;

@Data
public class PageUserVO {
	private String name;
	private String role;
	private Integer pageNum;
	private Integer pageSize;
	
}
