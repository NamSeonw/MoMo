package com.momo.web.entity;

import java.util.Date;

public class Member {
	private int id;
	private String loginId;
	private String pwd;
	private String name;
	private Date birthday;
	private String gender;
	private String phone;
	private String email;
	private int blacklist;
	private String roleId;

	public Member() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int isBlacklist() {
		return blacklist;
	}

	public void setBlacklist(int blacklist) {
		this.blacklist = blacklist;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", loginId=" + loginId + ", pwd=" + pwd + ", name=" + name + ", birthday="
				+ birthday + ", gender=" + gender + ", phone=" + phone + ", email=" + email + ", blacklist=" + blacklist
				+ ", roleId=" + roleId + "]";
	}

	public Member(int id, String loginId, String pwd, String name, Date birthday, String gender, String phone,
			String email, int blacklist, String roleId) {
		super();
		this.id = id;
		this.loginId = loginId;
		this.pwd = pwd;
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.blacklist = blacklist;
		this.roleId = roleId;
	}

}
