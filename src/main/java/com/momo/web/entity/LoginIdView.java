package com.momo.web.entity;

public class LoginIdView {
	
	private String loginId;
	
	public LoginIdView() {
		// TODO Auto-generated constructor stub
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	@Override
	public String toString() {
		return "LoginIdView [loginId=" + loginId + "]";
	}

	public LoginIdView(String loginId) {
		super();
		this.loginId = loginId;
	}
}
