package com.momo.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.momo.web.dao.NotifyDao;
import com.momo.web.entity.Notify;
import com.momo.web.entity.NotifyView;

@Repository
public class MybatisNotifyDao implements NotifyDao{
	
	private SqlSession sqlSession;
	private NotifyDao mapperDao;
	
	@Autowired
	public MybatisNotifyDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		mapperDao = sqlSession.getMapper(NotifyDao.class);
	}
	
	@Override
	public List<NotifyView> getList() {
		return getList(1);
	}

	@Override
	public List<NotifyView> getList(int page) {
		return mapperDao.getList(page);
	}

	@Override
	public Notify get(int id) {
		return mapperDao.get(id);
	}

	@Override
	public Notify get(String id) {
		return mapperDao.get(id);
	}

	@Override
	public int insert(Notify notify) {
		return mapperDao.insert(notify);
	}

	@Override
	public int update(Notify notify) {
		return mapperDao.update(notify);
	}

	@Override
	public int delete(int id) {
		return mapperDao.delete(id);
	}

	@Override
	public int delete(String id) {
		return mapperDao.delete(id);
	}

	@Override
	public int updateComplete(int id, boolean complete) {
		return mapperDao.updateComplete(id, complete);
	}

}
