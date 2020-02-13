package com.momo.web.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.momo.web.dao.NotifyDao;
import com.momo.web.entity.Notify;
import com.momo.web.entity.NotifyView;
import com.momo.web.service.NotifyService;

@Service
public class MomoNotifyService implements NotifyService {

	@Autowired
	private NotifyDao notifyDao;

	@Override
	public List<NotifyView> getNotifyList() {
		return notifyDao.getList();
	}

	@Override
	public List<NotifyView> getNotifyList(int page) {
		return notifyDao.getList(page);
	}

	@Override
	public Notify getNotify(int id) {
		return notifyDao.get(id);
	}

	@Override
	public Notify getNotify(String id) {
		return notifyDao.get(id);
	}

	@Override
	public int insert(Notify notify) {
		return notifyDao.insert(notify);
	}

	@Override
	public int update(Notify notify) {
		return notifyDao.update(notify);
	}

	@Override
	public int delete(int id) {
		return notifyDao.delete(id);
	}

	@Override
	public int delete(String id) {
		return notifyDao.delete(id);
	}

	@Override
	public int updateComplete(int id, boolean complete) {
		return notifyDao.updateComplete(id, complete);
	}

}
