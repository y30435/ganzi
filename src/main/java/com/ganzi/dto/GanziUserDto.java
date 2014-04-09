package com.ganzi.dto;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class GanziUserDto {
	@NotEmpty
	@Pattern(regexp="^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,3}$")
	private String userid;
	
	@NotEmpty
	@Pattern(regexp="^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{6,12}$")
	private String userpwd;
	private String userrole;
	
	@NotEmpty
	@Size(min=2, max=10)
	@Pattern(regexp="^[가-힣a-zA-Z]+$")
	private String username;
	
	public GanziUserDto(){}
	
	public GanziUserDto(String userid, String userpwd, String username){
		this.userid = userid;
		this.userpwd = userpwd;
		this.username = username;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public String getUserrole() {
		return userrole;
	}

	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
