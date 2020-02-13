package com.momo.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.momo.web.dao.AppealDao;
import com.momo.web.entity.Appeal;

@Repository
public class MybatisAppealDao implements AppealDao{
	
	private SqlSession sqlSession;
	private AppealDao mapperAppealDao;

	@Autowired
	public MybatisAppealDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		mapperAppealDao = sqlSession.getMapper(AppealDao.class);
	}

	@Override
	public List<Appeal> getList(int companyId) {
		return getList(0,companyId,0);
	}

	@Override
	public List<Appeal> getList(int page, int companyId,int matching) {
		return mapperAppealDao.getList(page, companyId,matching);
	}

	@Override
	public Appeal get(int id) {
		return mapperAppealDao.get(id);
	}

	@Override
	public int insert(Appeal appeal) {
		return mapperAppealDao.insert(appeal);
	}

	@Override
	public int update(Appeal appeal) {
		return mapperAppealDao.update(appeal);
	}

	@Override
	public int delete(int id) {
		return mapperAppealDao.delete(id);
	}


	@Override
	public Appeal getByPidCid(int postId, int companyId) {
		return mapperAppealDao.getByPidCid(postId, companyId);
	}

	@Override
	public Integer getCount(int companyId, int matching) {
		return mapperAppealDao.getCount(companyId, matching);
	}

}
