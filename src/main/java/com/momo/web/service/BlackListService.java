package com.momo.web.service;

import java.util.List;

import com.momo.web.entity.BlackListView;

public interface BlackListService {
	List<BlackListView> listNotify();
	List<BlackListView> listNotify(int page);
	
	BlackListView getNotify(int id);
	
	int updateByTarget(String target, int targetid, int chk);
	
	Integer getListCount(int chk);
	
}
