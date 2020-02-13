package com.momo.web.dao;

import java.util.List;

import com.momo.web.entity.Review;
import com.momo.web.entity.ReviewView;

public interface ReviewDao {
	List<ReviewView> getList();

	List<ReviewView> getList(int page, String field, String query);

	ReviewView get(int id);
	
	ReviewView getMapping(int id);

	ReviewView getByLoginId(String id);

	int insert(Review review);

	int update(Review review);

	int delete(int id);
	
	int getCountByMemeber(int id);
	
	int getCount(String field, String query);
	
	List<ReviewView> getListByLoginId(int page ,int id);
}
