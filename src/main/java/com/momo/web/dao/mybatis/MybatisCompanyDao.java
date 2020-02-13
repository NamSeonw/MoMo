package com.momo.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.momo.web.dao.CompanyDao;
import com.momo.web.entity.Company;

@Repository
public class MybatisCompanyDao implements CompanyDao {

	private SqlSession sqlSession;
	private CompanyDao mapperDao;

	@Autowired
	public MybatisCompanyDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		mapperDao = sqlSession.getMapper(CompanyDao.class);
	}

	@Override
	public Company getById(int id) {

		return mapperDao.getById(id);
	}

	@Override
	public int insert(Company company) {
		return mapperDao.insert(company);
	}

	@Override
	public int update(Company company) {
		return mapperDao.update(company);
	}
	
	@Override
	public int updatePwd(Company company) {
		return mapperDao.updatePwd(company);
	}

	@Override
	public int delete(int id) {
		return mapperDao.delete(id);
	}

	@Override
	public List<Company> getCompanyList() {
		return mapperDao.getCompanyList(0,"name","");
	}

	@Override
	public List<Company> getCompanyList(int page) {
		return mapperDao.getCompanyList(page);
	}

	@Override
	public List<Company> getCompanyList(int page, String field, String query) {
		if(field == "title" ) {
			field = "name";
		}
		return mapperDao.getCompanyList(page, field, query);
	}

	@Override
	public int deletes(int[] ids) {
		return mapperDao.deletes(ids);
	}

	@Override
	public Company findId(String name,String email) {
		return mapperDao.findId(name, email);
	}

	@Override
	public Company getByLoginId(String id) {

		return mapperDao.getByLoginId(id);
	}

	@Override
	public Integer getCompanyCount(String field, String query) {
		if(field == "title" ) {
			field = "name";
		}
		return mapperDao.getCompanyCount(field, query);
	}

	@Override
	public Company getByNameAndEmail(String name, String email) {
		return mapperDao.getByNameAndEmail(name, email);
	}

	@Override
	public Company getByLoginIdAndEmail(String loginId, String email) {
		return mapperDao.getByLoginIdAndEmail(loginId, email);
	}
}
