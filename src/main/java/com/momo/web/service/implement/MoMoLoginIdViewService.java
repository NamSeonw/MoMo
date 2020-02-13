package com.momo.web.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.momo.web.dao.LoginIdViewDao;
import com.momo.web.entity.LoginIdView;
import com.momo.web.service.LoginIdViewService;

@Service
public class MoMoLoginIdViewService implements LoginIdViewService{
	
	@Autowired
	private LoginIdViewDao loginIdViewDao;

	@Override
	public List<LoginIdView> getList() {
		return loginIdViewDao.getList();
	}
}
