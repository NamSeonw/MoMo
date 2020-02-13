package com.momo.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.momo.web.dao.ReviewDao;
import com.momo.web.entity.Review;
import com.momo.web.entity.ReviewView;

@Repository
public class MybatisReviewDao implements ReviewDao {
	
	private SqlSession sqlSession;
	private ReviewDao mapperDao;
	
	@Autowired
	public MybatisReviewDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		mapperDao = sqlSession.getMapper(ReviewDao.class);
	}
	
	@Override
	public List<ReviewView> getList() {
		return getList(1,"title","");
	}

	@Override
	public List<ReviewView> getList(int page, String field, String query) {
		
		return mapperDao.getList(page, field, query);
	}

	@Override
	public ReviewView get(int id) {
		return mapperDao.get(id);
	}

	@Override
	public ReviewView getByLoginId(String id) {
		return mapperDao.getByLoginId(id);
	}

	@Override
	public int insert(Review review) {
		return mapperDao.insert(review);
	}

	@Override
	public int update(Review review) {
		return mapperDao.update(review);
	}

	@Override
	public int delete(int id) {
		return mapperDao.delete(id);
	}

	@Override
	public int getCount(String field, String query) {
		return mapperDao.getCount(field, query);
	}

	@Override
	public List<ReviewView> getListByLoginId(int page ,int id) {
		return mapperDao.getListByLoginId(page,id);
	}

	@Override
	public int getCountByMemeber(int id) {
		return mapperDao.getCountByMemeber(id);
	}

	@Override
	public ReviewView getMapping(int id) {
		return mapperDao.getMapping(id);
	}

}
