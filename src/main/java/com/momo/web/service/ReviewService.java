package com.momo.web.service;

import java.util.List;

import com.momo.web.entity.Review;
import com.momo.web.entity.ReviewView;

public interface ReviewService {
	List<ReviewView> getReviewList();

	List<ReviewView> getReviewList(int page, String title, String query);

	ReviewView getReview(int id);

	ReviewView getReviewByLoginId(String id);
	
	ReviewView getMapping(int id);

	int insert(Review review);

	int update(Review review);

	int delete(int id);

	int deleteByLoginId(String id);
	
	Integer getReviewCountByMemeber(int id);
	
	Integer getReviewCount(String title, String query);
	
	List<ReviewView> getListByLoginId(int page , int id);
}
