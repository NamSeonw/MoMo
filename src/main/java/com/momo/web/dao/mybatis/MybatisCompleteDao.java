package com.momo.web.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.momo.web.dao.CompleteDao;
import com.momo.web.entity.Complete;

@Repository
public class MybatisCompleteDao implements CompleteDao{
	
	private SqlSession sqlSession;
	private CompleteDao mapperDao;
	
	@Autowired
	public MybatisCompleteDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		mapperDao = sqlSession.getMapper(CompleteDao.class);
	}
	
	@Override
	public int insert(Complete complete) {
		
		return mapperDao.insert(complete);
	}

	@Override
	public Complete getByPostId(Integer id) {
		
		return mapperDao.getByPostId(id);
	}


}
