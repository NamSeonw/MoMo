package com.momo.web.service;

import com.momo.web.entity.Complete;

public interface CompleteService {
	int insert(Complete complete);
	Complete getByPostId(int id);
}
