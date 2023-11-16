package com.coinrich.backend.dto;

public class UserDto {

	
	private int userId;
	private String name;
	private String email;
	private String password;
	
	public UserDto(int userId, String name, String email, String password) {

		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	public UserDto() {
		
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password
				+ "]";
	}
	
	
	
	
	
}
