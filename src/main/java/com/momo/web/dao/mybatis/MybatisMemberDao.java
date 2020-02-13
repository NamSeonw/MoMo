package com.momo.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.momo.web.dao.MemberDao;
import com.momo.web.entity.Member;

@Repository
public class MybatisMemberDao implements MemberDao{

	private SqlSession sqlSession;
	private MemberDao mapperDao;
	
	@Autowired
	public MybatisMemberDao(SqlSession sqlSession) {
		this.sqlSession=sqlSession;
		this.mapperDao=sqlSession.getMapper(MemberDao.class);
	}
	
	@Override
	public List<Member> getList() {
		
		return mapperDao.getList();
	}

	@Override
	public List<Member> getMemberList(String field, String query) {
		
		return mapperDao.getMemberList(field, query);
	}

	@Override
	public Member getById(int id) {
		
		return mapperDao.getById(id);
	}

	@Override
	public Member getByLoginId(String loginId) {
	
		return mapperDao.getByLoginId(loginId);
	}


	@Override
	public int insert(Member member) {
		
		return mapperDao.insert(member);
	}

	@Override
	public int update(Member member) {
		
		return mapperDao.update(member);
	}

	@Override
	public int delete(int id) {
		
		return mapperDao.delete(id);
	}

	@Override
	public Member findId(String name, String email) {
		
		return mapperDao.findId(name, email);
	}

	@Override
	public Member getByNameAndEmail(String name,String email) {
		
		return mapperDao.getByNameAndEmail(name,email);
	}

	@Override
	public Member getByLoginIdAndEmail(String loginId, String email) {
		return mapperDao.getByLoginIdAndEmail(loginId, email);
	}

}
