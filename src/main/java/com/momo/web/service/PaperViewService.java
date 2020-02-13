package com.momo.web.service;

import java.util.List;

import com.momo.web.entity.PaperView;

public interface PaperViewService {
	
	List<PaperView> getList(int page , int postId , int matching);
	
	Integer getListCount(int postId , int matching);
}
