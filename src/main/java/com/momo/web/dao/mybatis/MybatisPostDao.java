package com.momo.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.momo.web.dao.PostDao;
import com.momo.web.entity.Post;

@Repository
public class MybatisPostDao implements PostDao{
	
	private SqlSession sqlSession;
	private PostDao mapperPostDao;

	@Autowired
	public MybatisPostDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		mapperPostDao = sqlSession.getMapper(PostDao.class);
	}

	@Override
	public List<Post> getList() {
		return getList(0,"location","");
	}
	
	@Override
	public List<Post> getList(int page) {
		return getList(page,"location","");
	}

	@Override
	public List<Post> getList(int page, String field, String query) {
		return mapperPostDao.getList(page,field,query);
	}
	

	@Override
	public Post get(int id) {
		return mapperPostDao.get(id);
	}

	@Override
	public int insert(Post notice) {
		return mapperPostDao.insert(notice);
	}

	@Override
	public int update(Post notice) {
		return mapperPostDao.update(notice);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return mapperPostDao.delete(id);
	}

	@Override
	public List<Post> getByMemberId(int page, String field, String query, int matching, int memberId,int count) { // count 는 불러오는 갯수
		
		int page1 = (page-1)*3;
		
		return mapperPostDao.getByMemberId(page1,field,query,matching,memberId,count);
	}

	@Override
	public Integer getCount(int memberId) {
		return mapperPostDao.getCount(memberId);
	}

	@Override
	public Integer getSuccessCount(int memberId) {
		return mapperPostDao.getSuccessCount(memberId);
	}

	@Override
	public Integer getTotalCount(String field, String query) {
		return mapperPostDao.getTotalCount(field, query);
	}

	@Override
	public Post getByPostId(int memberId) {
		
		return mapperPostDao.get(memberId);
	}


}
