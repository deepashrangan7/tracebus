package com.model;

import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

@Component
public class LoginBean {
//	@NotBlank(message = "email cant Be empty")
	private String email;
//	@NotBlank(message = "Password Cant Be Empty")
	private String password;

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

}
