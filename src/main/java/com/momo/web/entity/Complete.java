package com.momo.web.entity;

public class Complete {
	private int postId; // post의 id
	private int appealId; // 식당의 id
	public Complete(int postId, int appealId) {
	
		this.postId = postId;
		this.appealId = appealId;
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
		return "Complete [postId=" + postId + ", appealId=" + appealId + "]";
	}
	
	
}
