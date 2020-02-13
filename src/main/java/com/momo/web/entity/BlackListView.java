package com.momo.web.entity;

public class BlackListView extends Notify {
	private int memberId;
	private String customerLoginId;
	private int peopleCount;
	private String reservationDate;

	private int companyId;
	private String companyName;
	private String companyAddress;
	private String companyContact;

	public BlackListView() {
		// TODO Auto-generated constructor stub
	}

	// selectList
	public BlackListView(int id, String title, String regdate, int postId, String customerLoginId) {
		super(id, title, regdate, postId);
		this.customerLoginId = customerLoginId;
	}

	// selectDetail
	public BlackListView(int id, String title, String content, String photo, String regdate, String target, int postId,
			int appealId, int memberId, String customerLoginId, int peopleCount, String reservationDate, int companyId,
			String companyName, String companyAddress, String companyContact) {
		super(id, title, content, photo, regdate, target, postId, appealId);
		this.memberId = memberId;
		this.customerLoginId = customerLoginId;
		this.peopleCount = peopleCount;
		this.reservationDate = reservationDate;
		this.companyId = companyId;
		this.companyName = companyName;
		this.companyAddress = companyAddress;
		this.companyContact = companyContact;
	}

	public String getCustomerLoginId() {
		return customerLoginId;
	}

	public void setCustomerLoginId(String customerLoginId) {
		this.customerLoginId = customerLoginId;
	}

	public int getpeopleCount() {
		return peopleCount;
	}

	public void setpeopleCount(int peopleCount) {
		this.peopleCount = peopleCount;
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

	public String getCompanyContact() {
		return companyContact;
	}

	public void setCompanyContact(String companyContact) {
		this.companyContact = companyContact;
	}

	public int getmemberId() {
		return memberId;
	}

	public void setmemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	@Override
	public String toString() {
		return "BlackListView [customerLoginId=" + customerLoginId + ", peopleCount=" + peopleCount + ", reservationDate="
				+ reservationDate + ", companyName=" + companyName + ", companyAddress=" + companyAddress
				+ ", companyContact=" + companyContact + ", toString()=" + super.toString() + "]";
	}

}
