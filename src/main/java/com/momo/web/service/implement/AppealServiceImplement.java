package com.momo.web.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.momo.web.dao.AppealDao;
import com.momo.web.dao.PostDao;
import com.momo.web.entity.Appeal;
import com.momo.web.entity.Post;
import com.momo.web.service.AppealService;

@Service
public class AppealServiceImplement implements AppealService {

	@Autowired
	private AppealDao appealDao;

	@Override
	public List<Appeal> getList(int companyId) {
		return getList(0,companyId,0);
	}

	@Override
	public List<Appeal> getList(int page, int companyId,int matching) {
		return appealDao.getList(page, companyId,matching);
	}

//	@Override
//	public List<Appeal> getList(int page, String field, String query) {
//		return getList(page, field, query);
//	}

	@Override
	public Appeal get(int id) {
		// TODO Auto-generated method stub
		return appealDao.get(id);
	}

	@Override
	public int insert(Appeal appeal) {
		return appealDao.insert(appeal);
	}

	@Override
	public int update(Appeal appeal) {
		return appealDao.update(appeal);
	}

	@Override
	public int delete(int id) {
		return appealDao.delete(id);
	}

	@Override
	public Appeal getByPidCid(int postId, int companyId) {
		return appealDao.getByPidCid(postId, companyId);
	}

	@Override
	public Integer getCount(int companyId, int matching) {
		return appealDao.getCount(companyId, matching);
	}

}
