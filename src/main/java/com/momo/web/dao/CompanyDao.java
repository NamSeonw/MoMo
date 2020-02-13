package com.momo.web.dao;

import java.util.List;

import com.momo.web.entity.Company;

public interface CompanyDao {
	Company getById(int id); // 회사 정보 가져오기

	Company getByLoginId(String id); // 회사 정보 가져오기

	int insert(Company company); // 회사 회원 가입

	int update(Company company); // 회사 정보 수정

	int updatePwd(Company company); // 비밀번호 수정

	int delete(int id); // 회사 회원 탈퇴

	List<Company> getCompanyList(); // 회사 검색

	List<Company> getCompanyList(int page); // 회사 검색

	List<Company> getCompanyList(int page, String field, String query); // 회사 검색 필터

	Integer getCompanyCount(String field, String query);

	int deletes(int[] ids); // 회사 회원 탈퇴 관리

	Company findId(String name , String email); // 회사 아이디 찾기
	
	Company getByNameAndEmail(String name, String email);

	Company getByLoginIdAndEmail(String loginId, String email);
}
