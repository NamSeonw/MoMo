package com.momo.web.entity;

public class Review {
	private int id;
	private String title;
	private String content;
	private String photo;
	private String regdate;
	private int postId;
	private int appealId;

	public Review() {
	}

	// select
	public Review(int id, String title, String content, String photo, String regdate, int postId, int appealId) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.photo = photo;
		this.regdate = regdate;
		this.postId = postId;
		this.appealId = appealId;
	}

	// insert
	public Review(String title, String content, String photo, int postId, int appealId) {
		this.title = title;
		this.content = content;
		this.photo = photo;
		this.postId = postId;
		this.appealId = appealId;
	}

	// update
	public Review(String title, String content, String photo) {
		this.title = title;
		this.content = content;
		this.photo = photo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getAppealId() {
		return appealId;
	}

	public void setAppealId(int appealId) {
		this.appealId = appealId;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", title=" + title + ", content=" + content + ", photo=" + photo + ", regdate="
				+ regdate + ", postId=" + postId + ", appealId=" + appealId + "]";
	}

}
