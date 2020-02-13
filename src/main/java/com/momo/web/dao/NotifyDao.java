package com.momo.web.dao;

import java.util.List;

import com.momo.web.entity.Notify;
import com.momo.web.entity.NotifyView;

public interface NotifyDao {
	List<NotifyView> getList();

	List<NotifyView> getList(int page);

	Notify get(int id);

	Notify get(String id);

	int insert(Notify notify);

	int update(Notify notify);
	
	int updateComplete(int id, boolean complete);

	int delete(int id);

	int delete(String id);

}
