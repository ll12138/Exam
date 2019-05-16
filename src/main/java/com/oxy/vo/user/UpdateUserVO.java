package com.oxy.vo.user;

import java.util.Objects;
import java.util.Optional;

import org.hibernate.validator.constraints.NotBlank;

import com.oxy.model.User;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class UpdateUserVO {
	@NotBlank
	private String usercode;
	private String name;
	private String password;
	private String role;
	
	public User toUser() {
	    User user = new User();
	    user.setUsercode(usercode);
	    user.setPassword(Optional.ofNullable(password)
	        .orElse(null));
	    if (Objects.equals(usercode, "admin")) {
	      return password == null || password.isEmpty() ? null : user;
	    }
	    user.setName(name);
	    user.setRole(role);
	    return user;
	  }
}
