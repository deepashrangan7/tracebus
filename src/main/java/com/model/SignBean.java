package com.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.stereotype.Component;

@Component
public class SignBean {
	@Pattern(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$", message = "Type Valid emailId")
	private String email;
	@NotBlank(message = "Password must not be empty must be 4 characters length...")
	@Min(value = 4,message = "length must be 4 characters")
	private String password1;
	@NotBlank(message = "Please type your password again ...")
	private String password2;

	@NotBlank(message = "Please enter your name...")
	private String name;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	@Override
	public String toString() {
		return "SignBean [email=" + email + ", password1=" + password1 + ", password2=" + password2 + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
