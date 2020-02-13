package com.momo.web.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.momo.web.dao.ReviewDao;
import com.momo.web.entity.Review;
import com.momo.web.entity.ReviewView;
import com.momo.web.service.ReviewService;

@Service
public class MomoReviewService implements ReviewService {

	@Autowired
	private ReviewDao reviewDao;

	@Override
	public List<ReviewView> getReviewList() {
		return reviewDao.getList();
	}

	@Override
	public List<ReviewView> getReviewList(int page, String title, String query) {
		return reviewDao.getList(page, title, query);
	}

	@Override
	public ReviewView getReview(int id) {
		return reviewDao.get(id);
	}

	@Override
	public ReviewView getReviewByLoginId(String id) {
		return reviewDao.getByLoginId(id);
	}

	@Override
	public int insert(Review review) {
		return reviewDao.insert(review);
	}

	@Override
	public int update(Review review) {
		return reviewDao.update(review);
	}

	@Override
	public int delete(int id) {
		return reviewDao.delete(id);
	}

	@Override
	public int deleteByLoginId(String id) {
		ReviewView reivew = reviewDao.getByLoginId(id);
		return reviewDao.delete(reivew.getId());
	}

	@Override
	public Integer getReviewCount(String field, String query) {
		return reviewDao.getCount(field, query);
	}

	@Override
	public List<ReviewView> getListByLoginId(int page ,int id) {
		return reviewDao.getListByLoginId(page,id);
	}

	@Override
	public Integer getReviewCountByMemeber(int id) {
		return reviewDao.getCountByMemeber(id);
	}

	@Override
	public ReviewView getMapping(int id) {
		return reviewDao.getMapping(id);
	}
}
