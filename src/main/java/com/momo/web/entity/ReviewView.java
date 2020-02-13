package com.momo.web.entity;

public class ReviewView extends Review {
	private int peopleNum;
	private String reservationDate;
	private String companyName;
	private String companyAddress;
	private String name;
	private String photo;
	private String content;
	
	public ReviewView() {
		super();
	}
	
	// select
	public ReviewView(int id, String title, String content, String photo, String regdate, int postId, int appealId,
			int peopleNum, String reservationDate, String companyName, String companyAddress) {
		super(id, title, content, photo, regdate, postId, appealId);
		this.peopleNum = peopleNum;
		this.reservationDate = reservationDate;
		this.companyName = companyName;
		this.companyAddress = companyAddress;
	}
	
	public int getPeopleNum() {
		return peopleNum;
	}

	public void setPeopleNum(int peopleNum) {
		this.peopleNum = peopleNum;
	}

	public String getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "ReviewView [peopleNum=" + peopleNum + ", reservationDate=" + reservationDate + ", companyName="
				+ companyName + ", companyAddress=" + companyAddress + ", name=" + name + ", photo=" + photo
				+ ", content=" + content + "]";
	}
}
