package com.oxy.vo.user;


import org.hibernate.validator.constraints.NotBlank;

import com.oxy.model.User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AddUserVO {
	@NotBlank
	private String usercode;
	@NotBlank
	private String name;
	@NotBlank
	private String password;
	@NotBlank
	private String role;
	
	public User toUser() {
	    User user = new User();
	    user.setUsercode(usercode);
	    user.setName(name);
	    user.setPassword(password);
	    user.setRole(role);
	    return user;
	}
}
