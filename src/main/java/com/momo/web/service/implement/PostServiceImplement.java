package com.momo.web.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.momo.web.dao.PostDao;
import com.momo.web.entity.Post;
import com.momo.web.service.PostService;

@Service
public class PostServiceImplement implements PostService {

	@Autowired
	private PostDao postDao;

	@Override
	public List<Post> getList() {
		return getList(0, "location", "");
	}

	@Override
	public List<Post> getList(int page) {
		return getList(page, "location", "");
	}

	@Override
	public List<Post> getList(int page, String field, String query) {
		return postDao.getList(page, field, query);
	}

	@Override
	public Post get(int id) {
		return postDao.get(id);
	}

	@Override
	public int insert(Post post) {
		return postDao.insert(post);
	}

	@Override
	public int update(Post post) {
		// TODO Auto-generated method stub
		return postDao.update(post);
	}

	@Override
	public int delete(int id) {
		return postDao.delete(id);
	}

	@Override
	public List<Post> getByMemberId(int page, String field, String query, int matching, int memberId,int count) {
		return postDao.getByMemberId(page,field,query,matching,memberId,count);
	}

	@Override
	public Integer getCount(int memberId) {
		return postDao.getCount(memberId);
	}
	
	@Override
	public Integer getSuccessCount(int memberId) {
		return postDao.getSuccessCount(memberId);
	}

	@Override
	public Integer getTotalCount(String field, String query) {
		return postDao.getTotalCount(field, query);
	}

	@Override
	public Post getByPostId(int memberId) {
		
		return postDao.getByPostId(memberId);
	}
	

}
