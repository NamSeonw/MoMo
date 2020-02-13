package com.momo.web.dao;

import com.momo.web.entity.Complete;

public interface CompleteDao {
	int insert(Complete complete);

	Complete getByPostId(Integer id);
}
