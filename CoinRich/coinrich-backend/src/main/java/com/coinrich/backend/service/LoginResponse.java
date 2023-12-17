package com.coinrich.backend.service;

public class LoginResponse {

	String message;;

	Boolean response;

	String name;
	String email;

	public LoginResponse(String message, Boolean response) {
		this.message = message;
		this.response = response;
	}

	public LoginResponse(String message, Boolean response, String name, String email) {
		this.name = name;
		this.email = email;
		this.message = message;
		this.response = response;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getResponse() {
		return response;
	}

	public void setResponse(Boolean response) {
		this.response = response;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
