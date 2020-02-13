package com.momo.web.service;

import java.util.List;

import com.momo.web.entity.Post;

public interface PostService {
	
	List<Post> getList();
	List<Post> getList(int page);
	List<Post> getList(int page, String field, String query);

	Post get(int id);
	List<Post> getByMemberId(int page, String field, String query, int matching, int memberId,int count);
	
	int insert(Post post);
	int update(Post post);
	int delete(int id);
	Integer getCount(int memberId);
	Integer getSuccessCount(int memberId);

	Integer getTotalCount(String field, String query);
	Post getByPostId(int memberId);
}
