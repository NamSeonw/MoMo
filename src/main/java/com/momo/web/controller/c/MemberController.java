package com.momo.web.controller.c;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.momo.web.entity.Company;
import com.momo.web.entity.Member;
import com.momo.web.entity.Notify;
import com.momo.web.service.CompanyService;
import com.momo.web.service.MemberService;
import com.momo.web.service.NotifyService;

@Controller("CMemberController")
@SessionAttributes("loginId")
@RequestMapping("/member/")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private NotifyService notifyService;
	
	@GetMapping("notifyCompany/{id}")
	public String notifyCompany(@PathVariable("id")Integer id,Model model) {
		Company company=companyService.getById(id);
		model.addAttribute("company",company);
		
		return "member.notifyCompany";
	}
	
	@PostMapping("notifyCompany/{id}")
	public String notifyCompany(@PathVariable("id")Integer id,Principal principal,Notify notify) {
		Member member=memberService.getByLoginId(principal.getName());
		
		notify.setTarget("고객");
		notify.setPostId(member.getId());
	
		notifyService.insert(notify);
		return "redirect:/index";
	}
}
