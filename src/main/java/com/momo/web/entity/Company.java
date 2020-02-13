package com.momo.web.entity;

public class Company {
	private int id;
	private String loginId;
	private String pwd;
	private String name;
	private String address;
	private String contact;
	private String businessNumber;
	private String category;
	private String photo;
	private String email;
	private int blacklist;
	private String content;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Company() {
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getBusinessNumber() {
		return businessNumber;
	}

	public void setBusinessNumber(String businessNumber) {
		this.businessNumber = businessNumber;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getBlacklist() {
		return blacklist;
	}

	public void setBlacklist(int blacklist) {
		this.blacklist = blacklist;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Company(int id, String loginId, String pwd, String name, String address, String contact,
			String businessNumber, String category, String photo, int blacklist, String content, String email) {
		super();
		this.id = id;
		this.loginId = loginId;
		this.pwd = pwd;
		this.name = name;
		this.address = address;
		this.contact = contact;
		this.businessNumber = businessNumber;
		this.category = category;
		this.photo = photo;
		this.blacklist = blacklist;
		this.content = content;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", loginId=" + loginId + ", pwd=" + pwd + ", name=" + name + ", address=" + address
				+ ", contact=" + contact + ", businessNumber=" + businessNumber + ", category=" + category + ", photo="
				+ photo + ", email=" + email + ", blacklist=" + blacklist + ", content=" + content + "]";
	}
}
