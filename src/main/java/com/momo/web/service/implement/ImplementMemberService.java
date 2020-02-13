package com.momo.web.service.implement;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.momo.web.dao.MemberDao;
import com.momo.web.entity.Member;
import com.momo.web.service.MemberService;

@Service
public class ImplementMemberService implements MemberService{
	
	@Autowired
	private MemberDao memberDao;

	@Override
	public boolean isValidMember(String loginId, String pwd) {
		Member member=memberDao.getByLoginId(loginId);
		
		//회원인 loginId면서 pwd가 일치하면 true반환
		if(member!=null && member.getPwd().equals(pwd)) 
			return true;
		else
			return false;
	}

	@Override
	public boolean isDuplicatedId(String loginId) {
		Member member=memberDao.getByLoginId(loginId);
		
		if(member!=null)
			return true;
		
		return false;
	}

	@Override
	public String findId(String name, String email) {
		Member member=memberDao.findId(name, email);
		
		if(member!=null) {
			return member.getLoginId();
		}
		
		return "가입하지 않은 회원입니다.";
	}

	@Override
	public List<Member> getMemberList() {
		
		return memberDao.getList();
	}

	@Override
	public List<Member> getMemberList(String field, String query) {
		
		return memberDao.getMemberList(field, query);
	}

	@Override
	public int insert(Member member) {
		String pwd = member.getPwd();
		
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		String hashedPwd = encoder.encode(pwd);
		
		member.setPwd(hashedPwd);
		
		return memberDao.insert(member);
	}

	@Override
	public int update(Member member) {
		
		String pwd = member.getPwd();
		
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		String hashedPwd = encoder.encode(pwd);
		
		member.setPwd(hashedPwd);
		
		return memberDao.update(member);
	}

	@Override
	public int deletes(int[] ids) {
		int i=0;
		for(;i<ids.length;i++) {
			memberDao.delete(ids[i]);
		}
		return i;
	}

	@Override
	public int delete(int id) {
		
		return memberDao.delete(id);
	}

	@Override
	public Member getById(int id) {
		
		return memberDao.getById(id);
	}

	@Override
	public Member getByLoginId(String loginId) {
		
		return memberDao.getByLoginId(loginId);
	}

	@Override
	public boolean isDuplicatedPwd(Member member,String pwd) {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
	      
	    boolean isChk = encoder.matches(pwd, member.getPwd());
	
		return isChk;
	}


	@Override
	public Member getByNameAndEmail(String name, String email) {
		
		return memberDao.getByNameAndEmail(name,email);
		
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
	public Member getByLoginIdAndEmail(String loginId, String email) {
		return memberDao.getByLoginIdAndEmail(loginId,email);
	}

	@Override
	public boolean isPhoneChk(String phone) {
		
		String phonePattern = "^\\d{3}-\\d{3,4}-\\d{4}$";
		
		boolean result = phone.matches(phonePattern);
		
		return result;
	}
}
