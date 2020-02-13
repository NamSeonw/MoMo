package com.momo.web.entity;

import java.sql.Date;

public class PaperView {
	private int postId; //post의 id
	private int companyId; //식당의 id
	private int id; //appealId           
	private String content; //내용
	private Date regdate; //등록일
	private int matching; //매칭여부 0,1
	private String name;
	
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
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getMatching() {
		return matching;
	}
	public void setMatching(int matching) {
		this.matching = matching;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "PaperView [postId=" + postId + ", companyId=" + companyId + ", id=" + id + ", content=" + content
				+ ", regdate=" + regdate + ", matching=" + matching + ", name=" + name + "]";
	}
	public PaperView(int postId, int companyId, int id, String content, Date regdate, int matching, String name) {
		super();
		this.postId = postId;
		this.companyId = companyId;
		this.id = id;
		this.content = content;
		this.regdate = regdate;
		this.matching = matching;
		this.name = name;
	}
	
}
