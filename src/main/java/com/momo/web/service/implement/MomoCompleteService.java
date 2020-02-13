package com.momo.web.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.momo.web.dao.CompleteDao;
import com.momo.web.entity.Complete;
import com.momo.web.service.CompleteService;

@Service
public class MomoCompleteService implements CompleteService {

	@Autowired
	private CompleteDao completeDao;

	@Override
	public int insert(Complete complete) {

		return completeDao.insert(complete);
	}

	@Override
	public Complete getByPostId(int id) {
		// TODO Auto-generated method stub
		return completeDao.getByPostId(id);
	}

	

}
