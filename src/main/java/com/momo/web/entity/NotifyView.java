package com.momo.web.entity;

public class NotifyView extends Notify {
	//// 예약일시, 인원, 식당이름, 식당위치
	// private String customerName
	private int peopleNum;
	private String reservationDate;
	private String companyName;
	private String companyAddress;

	public NotifyView() {
	}

	public NotifyView(int id, String title, String content, String photo, String regdate, String target, int postId,
			int appealId, int peopleNum, String reservationDate, String companyName, String companyAddress) {
		super(id, title, content, photo, regdate, target, postId, appealId);
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

	@Override
	public String toString() {
		return "NotifyView [peopleNum=" + peopleNum + ", reservationDate=" + reservationDate + ", companyName="
				+ companyName + ", companyAddress=" + companyAddress + ", toString()=" + super.toString() + "]";
	}

}
