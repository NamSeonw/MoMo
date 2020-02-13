package com.momo.web.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.momo.web.dao.CompanyDao;
import com.momo.web.entity.Company;
import com.momo.web.entity.Member;
import com.momo.web.service.CompanyService;

@Service
public class MomoCompanyService implements CompanyService {

	@Autowired
	private CompanyDao companyDao;

	@Override
	public boolean isValidCompany(String loginId, String pwd) {
		Company company = companyDao.getByLoginId(loginId);

		// 회원인 loginId면서 pwd가 일치하면 true반환
		if (company != null && company.getPwd().equals(pwd))
			return true;
		else
			return false;
	}

	@Override
	public boolean isDuplicatedId(String loginId) {
		Company company = companyDao.getByLoginId(loginId);

		if (company != null)
			return true;

		return false;
	}

	@Override
	public String isFindId(String name, String email) {
		Company company=companyDao.findId(name,email);
		
		if(company!=null) {
			return company.getLoginId();
		}
		
		return "가입하지 않은 회원입니다.";
	}

	@Override
	public List<Company> getCompanyList() {
		return companyDao.getCompanyList(0, "title", "");
	}

	@Override
	public List<Company> getCompanyList(int page) {
		return companyDao.getCompanyList(page, "title", "");
	}
	

	@Override
	public List<Company> getCompanyList(int page, String field, String query) {
		return companyDao.getCompanyList(page, field, query);
	}

	@Override
	public int insert(Company company) {
		String pwd = company.getPwd();

		PasswordEncoder encoder = new BCryptPasswordEncoder();
		String hashedPwd = encoder.encode(pwd);

		company.setPwd(hashedPwd);

		return companyDao.insert(company);
	}

	@Override
	public int update(Company company) {

		String pwd = company.getPwd();

		PasswordEncoder encoder = new BCryptPasswordEncoder();
		String hashedPwd = encoder.encode(pwd);

		company.setPwd(hashedPwd);

		return companyDao.update(company);
	}

	@Override
	public int updatePwd(Company company) {

		String pwd = company.getPwd();

		PasswordEncoder encoder = new BCryptPasswordEncoder();
		String hashedPwd = encoder.encode(pwd);

		company.setPwd(hashedPwd);
		return companyDao.updatePwd(company);
	}

	@Override
	public int deletes(int[] ids) {
		int i=0;
			for(;i<ids.length;i++) {
				companyDao.delete(ids[i]);
			}
		return i;
	}

	@Override
	public int delete(int id) {
		
		return companyDao.delete(id);
	}

	@Override
	public Company getById(int id) {
		
		return companyDao.getById(id);
	}

	@Override
	public Company findId(String name) {
		return null;
	}

	@Override
	public Company getByLoginId(String id) {
		
		return companyDao.getByLoginId(id);
	}

	@Override
	public boolean isChk(String loginId, String pwd) {
		
		Company company = getByLoginId(loginId);
		
		PasswordEncoder encoder = new BCryptPasswordEncoder();
	      
	    boolean isChk = encoder.matches(pwd, company.getPwd());
		
		return isChk;
	}

	@Override
	public Integer getCompanyCount(String field, String query) {
		return companyDao.getCompanyCount(field, query);
	}
	@Override
	public boolean isPwdChk(String pwd) {
		
		String pwdPattern = "^(?=.*\\d)(?=.*[~`!@#$%\\\\^&*()-])(?=.*[a-z]).{9,15}$"; // 9~15 글자 소문자 숫자 특수문자 하나씩은 포함
		
		boolean result = pwd.matches(pwdPattern);
		
		return result;
	}

	@Override
	public boolean isIdChk(String loginId) {
		
		String idPattern = "^[a-z]+[a-z0-9].{5,19}$";
		
		boolean result = loginId.matches(idPattern);
		
		return result;
	}

	@Override
	public Company getByNameAndEmail(String name, String email) {
		return companyDao.getByNameAndEmail(name, email);
	}

	@Override
	public Company getByLoginIdAndEmail(String loginId, String email) {
		return companyDao.getByLoginIdAndEmail(loginId, email);
	}

	@Override
	public boolean isContactChk(String contact) {
		String phonePattern = "^\\d{3}-\\d{3,4}-\\d{4}$";
		
		boolean result = contact.matches(phonePattern);
		
		return result;
	}
}
