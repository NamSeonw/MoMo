package com.momo.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.momo.web.dao.PaperViewDao;
import com.momo.web.entity.PaperView;

@Repository
public class MybatisPaperViewDao implements PaperViewDao{
	
	private SqlSession sqlSession;
	private PaperViewDao mapperDao;
	
	@Autowired
	public MybatisPaperViewDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		mapperDao = sqlSession.getMapper(PaperViewDao.class);
	}

	@Override
	public List<PaperView> getList(int page , int postId,int matching) {
		int page1 = (page-1)*3;
		
		return mapperDao.getList(page1 , postId , matching);
	}

	@Override
	public Integer getListCount(int postId , int matching) {
		return mapperDao.getListCount(postId,matching);
	}
}
