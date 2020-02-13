package com.momo.web.entity;

public class Notify {
	private int id;
	private String title;
	private String content;
	private String photo;
	private String regdate;
	private String target;
	private int postId;
	private int appealId;
	private int blacklist;

	public Notify() {
	}

	// selectList
	public Notify(int id, String title, String regdate, int postId) {
		this.id = id;
		this.title = title;
		this.regdate = regdate;
		this.postId = postId;
	}

	// selectDetail
	public Notify(int id, String title, String content, String photo, String regdate, String target, int postId,
			int appealId) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.photo = photo;
		this.regdate = regdate;
		this.target = target;
		this.postId = postId;
		this.appealId = appealId;
	}

	// insert, update
	public Notify(String title, String content, String photo, String target, int postId, int appealId,int blacklist) {
		this.title = title;
		this.content = content;
		this.photo = photo;
		this.target = target;
		this.postId = postId;
		this.appealId = appealId;
		this.blacklist = blacklist;
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

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
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

	public int getBlacklist() {
		return blacklist;
	}

	public void setBlacklist(int blacklist) {
		this.blacklist = blacklist;
	}

	@Override
	public String toString() {
		return "Notify [id=" + id + ", title=" + title + ", content=" + content + ", photo=" + photo + ", regdate="
				+ regdate + ", target=" + target + ", postId=" + postId + ", appealId=" + appealId + "]";
	}

}
