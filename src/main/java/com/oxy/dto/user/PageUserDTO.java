package com.oxy.dto.user;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class PageUserDTO {
	private Integer userid;
	private String usercode;
	private String name;
	private String role;
	
}
