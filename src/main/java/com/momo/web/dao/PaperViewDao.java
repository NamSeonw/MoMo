package com.momo.web.dao;

import java.util.List;
import com.momo.web.entity.PaperView;

public interface PaperViewDao {

	List<PaperView> getList(int page , int postId, int matching);
	
	Integer getListCount(int postId, int matching);
}
