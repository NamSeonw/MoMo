package com.momo.web.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.momo.web.dao.BlackListDao;
import com.momo.web.entity.BlackListView;
import com.momo.web.service.BlackListService;

@Service
public class MomoBlackListService implements BlackListService{
	
	@Autowired
	private BlackListDao blacklistDao;

	@Override
	public List<BlackListView> listNotify() {
		return listNotify(0);
	}

	@Override
	public List<BlackListView> listNotify(int page) {
		return blacklistDao.list(page);
	}

	@Override
	public BlackListView getNotify(int id) {
		return blacklistDao.get(id);
	}

	@Override
	public int updateByTarget(String target, int targetid, int chk) {
		return blacklistDao.updateByTarget(target, targetid, chk);
	}

	@Override
	public Integer getListCount(int chk) {
		return blacklistDao.getListCount(chk);
	}

}
