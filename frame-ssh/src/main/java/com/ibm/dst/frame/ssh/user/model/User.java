package com.ibm.dst.frame.ssh.user.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class User {
	private String id = null;
	
	@NotBlank(message="{user.name.blank}")
	private String name = null;
	
	@NotNull(message="{user.age.null}")
	@Min(value=1, message="{user.age.min}")
	@Max(value=100, message="{user.age.max}")
	private Integer age = null;
	
	@NotBlank(message="{user.email.blank}")
	@Email(message="{user.email.format}")
	private String email = null;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
