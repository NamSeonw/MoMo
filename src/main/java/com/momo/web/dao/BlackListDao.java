package com.momo.web.dao;

import java.util.List;

import com.momo.web.entity.BlackListView;

public interface BlackListDao {
	List<BlackListView> list();
	List<BlackListView> list(int page);
	
	BlackListView get(int id);
	
	int updateByTarget(String target, int targetId, int chk);
	
	Integer getListCount(int chk);
	
}
