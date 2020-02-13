package com.momo.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.momo.web.dao.BlackListDao;
import com.momo.web.entity.BlackListView;

@Repository
public class MybatisBlackListDao implements BlackListDao{
	
	private SqlSession sqlSession;
	private BlackListDao mapperDao;
	
	@Autowired
	public MybatisBlackListDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		mapperDao = sqlSession.getMapper(BlackListDao.class);
	}

	@Override
	public List<BlackListView> list() {
		return list(0);
	}

	@Override
	public List<BlackListView> list(int page) {
		return mapperDao.list(page);
	}

	@Override
	public BlackListView get(int id) {
		return mapperDao.get(id);
	}

	@Override
	public int updateByTarget(String target, int targetId, int chk) {
		return mapperDao.updateByTarget(target, targetId, chk);
	}

	@Override
	public Integer getListCount(int chk) {
		return mapperDao.getListCount(chk);
	}

}
