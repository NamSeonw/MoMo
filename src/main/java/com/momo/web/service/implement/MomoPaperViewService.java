package com.momo.web.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.momo.web.dao.PaperViewDao;
import com.momo.web.entity.PaperView;
import com.momo.web.service.PaperViewService;

@Service
public class MomoPaperViewService implements PaperViewService {
	
	@Autowired
	private PaperViewDao paperViewDao;
	
	@Override
	public List<PaperView> getList(int page , int postId,int matching) {
		return paperViewDao.getList(page , postId, matching);
	}

	@Override
	public Integer getListCount(int postId , int matching) {
		
		return paperViewDao.getListCount(postId, matching);
	}
}
