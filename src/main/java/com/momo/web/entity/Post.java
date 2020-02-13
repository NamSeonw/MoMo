package com.momo.web.entity;

import java.sql.Date;

public class Post {
	private int id;
	private int peopleCount; //인원수
	private Date reservationDate; //예약날짜                 
	private String category; //목적
	private String content; //내용
	private int memberId; //회원아이디
	private String location; //위치
	private int matching; //매칭여부 0,1
	private String loginId; //멤버의 로그인아이디
	
	
	public Post() {
		
	}

	public Post(int id,int peopleCount, Date reservationDate, String category, String content, int memberId,
			String location, int matching, String loginId) {
		this.peopleCount = peopleCount;
		this.reservationDate = reservationDate;
		this.category = category;
		this.content = content;
		this.memberId = memberId;
		this.location = location;
		this.matching = matching;
		this.loginId = loginId;
	}



	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public int getMatching() {
		return matching;
	}


	public void setMatching(int matching) {
		this.matching = matching;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getPeopleCount() {
		return peopleCount;
	}

	public void setPeopleCount(int peopleCount) {
		this.peopleCount = peopleCount;
	}

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", peopleCount=" + peopleCount + ", reservationDate=" + reservationDate
				+ ", category=" + category + ", content=" + content + ", memberId=" + memberId + ", location="
				+ location + ", matching=" + matching + ", loginId=" + loginId + "]";
	}

	
	

}
