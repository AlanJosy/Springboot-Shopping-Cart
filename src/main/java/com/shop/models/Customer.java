package com.shop.models;

import javax.validation.constraints.NotBlank;

public class Customer {
	
	Integer id;
	@NotBlank(message="User Name cannot be empty")
	String name;
	@NotBlank(message="Password cannot be empty")

	String password;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

}
