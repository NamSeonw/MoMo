package com.momo.web.entity;

import java.sql.Date;
import java.sql.Timestamp;

public class Appeal {
	private int postId; // post의 id
	private int companyId; // 식당의 id
	private int id; // id
	private String content; // 내용
	private Timestamp regdate; // 등록일
	private int matching; // 매칭여부 0,1

	public Appeal() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Appeal(int postId, int companyId, String content) {
		super();
		this.postId = postId;
		this.companyId = companyId;
		this.content = content;
	}

	public Appeal(int postId, int companyId, int id, String content, Timestamp regdate, int matching) {
		super();
		this.postId = postId;
		this.companyId = companyId;
		this.id = id;
		this.content = content;
		this.regdate = regdate;
		this.matching = matching;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	public int getMatching() {
		return matching;
	}

	public void setMatching(int matching) {
		this.matching = matching;
	}

	@Override
	public String toString() {
		return "Appeal [postId=" + postId + ", companyId=" + companyId + ", id=" + id + ", content=" + content
				+ ", regdate=" + regdate + ", matching=" + matching + "]";
	}

}
