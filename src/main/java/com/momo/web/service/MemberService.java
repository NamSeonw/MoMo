package com.momo.web.service;

import java.util.List;

import com.momo.web.entity.Member;

public interface MemberService {
	
	boolean isValidMember(String loginId, String pwd); // 회원인지확인

	boolean isDuplicatedId(String loginId); // 아이디중복확인
	
	boolean isDuplicatedPwd(Member member, String pwd);

	List<Member> getMemberList(); // 전체회원관리에서 모든회원리스트

	List<Member> getMemberList(String field, String query); // 전체회원관리 검색

	int insert(Member member); // 회원가입

	int update(Member member); // 비번변경,닉네임변경

	int deletes(int[] ids); // 전체회원관리 일괄삭제

	int delete(int id); // 회원탈퇴

	Member getById(int id); // 로그인
	
	Member getByLoginId(String loginId);
	
	Member getByNameAndEmail(String name, String email);
	
	Member getByLoginIdAndEmail(String loginId, String email);
	
	String findId(String name,String email);
	
	boolean isPwdChk(String pwd);
	
	boolean isIdChk(String loginId);
	
	boolean isPhoneChk(String phone);
}
