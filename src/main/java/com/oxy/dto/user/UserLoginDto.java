package com.oxy.dto.user;

public class UserLoginDto {
	private String usercode;
	private String name;
	private String role;
	
	public String getUsercode() {
		return usercode;
	}
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public UserLoginDto(String usercode, String name, String role) {
		super();
		this.usercode = usercode;
		this.name = name;
		this.role = role;
	}
}
