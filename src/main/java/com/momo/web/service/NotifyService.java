package com.momo.web.service;

import java.util.List;

import com.momo.web.entity.Notify;
import com.momo.web.entity.NotifyView;

public interface NotifyService {
	List<NotifyView> getNotifyList();

	List<NotifyView> getNotifyList(int page);

	Notify getNotify(int id);

	Notify getNotify(String id);

	int insert(Notify notify);

	int update(Notify notify);
	
	int updateComplete(int id, boolean complete);

	int delete(int id);

	int delete(String id);
}
