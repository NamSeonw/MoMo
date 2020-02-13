package com.momo.web.controller.l;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.momo.web.entity.Appeal;
import com.momo.web.entity.Company;
import com.momo.web.service.AppealService;
import com.momo.web.service.CompanyService;

@RestController("IPostControoler")
@RequestMapping("/")
public class RestPostController {
	@Autowired
	private AppealService appealService;
	@Autowired
	private CompanyService companyService;

	@GetMapping("post-json")
	public String postJson(Integer postId, String username) {
		Company company = companyService.getByLoginId(username);
		Appeal appeal = appealService.getByPidCid(postId, company.getId());
		if (appeal != null) {
			String json = new Gson().toJson(appeal);
			return json;
		}
		return "";
	}

	@GetMapping("get-principal")
	public String getPrincipal(Principal principal) {
		String json = new Gson().toJson(principal.getName());
		System.out.println(json);
		return principal.getName();
	}

	@GetMapping("appeal-json")
	public String appealJson(Integer postId, String username) {
		Appeal appeal = appealService.getByPidCid(postId, companyService.getByLoginId(username).getId());
		return "" + appeal.getId();
	}
}
