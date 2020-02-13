package com.momo.web.dao;

import java.util.List;

import com.momo.web.entity.Member;

public interface MemberDao {
	List<Member> getList();
	List<Member> getMemberList(String field, String query);
	
	Member getById(int id);
	Member getByLoginId(String loginId);
	Member findId(String name,String email); 

	int insert(Member member);
	int update(Member member);	
	int delete(int id);
	Member getByNameAndEmail(String name, String email);
	Member getByLoginIdAndEmail(String loginId, String email);

}
