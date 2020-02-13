package com.momo.web.service;

import java.util.List;

import com.momo.web.entity.Company;

public interface CompanyService {
	
	boolean isValidCompany(String id, String pwd);

	boolean isDuplicatedId(String id); 

	String isFindId(String name, String email); 
	
	boolean isChk(String id , String pwd);

	List<Company> getCompanyList();
	
	List<Company> getCompanyList(int page);

	List<Company> getCompanyList(int page , String field, String query); 

	int insert(Company company); 

	int update(Company company); 
	
	int updatePwd(Company company); 

	int deletes(int[] ids); 

	int delete(int id); 

	Company getById(int id); 
	
	Company getByLoginId(String id);

	Company findId(String name);
	
	Integer getCompanyCount(String field, String query);

	boolean isPwdChk(String pwd);
	
	boolean isIdChk(String loginId);
	
	Company getByNameAndEmail(String name, String email);
	
	Company getByLoginIdAndEmail(String loginId, String email);

	boolean isContactChk(String contact);
}
