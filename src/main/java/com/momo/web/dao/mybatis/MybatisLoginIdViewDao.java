package com.momo.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.momo.web.dao.LoginIdViewDao;
import com.momo.web.dao.NotifyDao;
import com.momo.web.entity.LoginIdView;

@Repository
public class MybatisLoginIdViewDao implements LoginIdViewDao {

	private SqlSession sqlSession;
	private LoginIdViewDao mapperDao;
	
	@Autowired
	public MybatisLoginIdViewDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		mapperDao = sqlSession.getMapper(LoginIdViewDao.class);
	}

	@Override
	public List<LoginIdView> getList() {
		return mapperDao.getList();
	}
}
