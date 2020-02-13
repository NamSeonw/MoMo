package com.momo.web.dao;

import java.util.List;

import com.momo.web.entity.Appeal;

public interface AppealDao {
	
	List<Appeal> getList(int companyId);
	List<Appeal> getList(int page,int companyId, int matching);

	Appeal get(int id);
	Appeal getByPidCid(int postId, int companyId);
	
	int insert(Appeal appeal);
	int update(Appeal appeal);
	int delete(int id);
	
	Integer getCount(int companyId, int matching);

}
