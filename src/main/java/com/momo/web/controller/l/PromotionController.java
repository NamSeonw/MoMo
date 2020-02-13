package com.momo.web.controller.l;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.momo.web.entity.Company;
import com.momo.web.service.CompanyService;

@Controller
@RequestMapping("/promotion")
public class PromotionController {

	@Autowired
	private CompanyService companyService;

	@GetMapping("list")
	public String getList(@RequestParam(name="q",defaultValue = "") String query, Model model, Principal principal,
			@RequestParam(name="p",defaultValue = "1") Integer page) {
		int getPage = (page-1)*4;
		model.addAttribute("count", companyService.getCompanyCount("name",query));
		model.addAttribute("querys", query);
		model.addAttribute("list", companyService.getCompanyList(getPage, "name", query));
		return "root.promotion";
	}

	@PostMapping("list")
	public String postList(@RequestParam(name="q",defaultValue = "") String query, Model model, Principal principal,
			@RequestParam(name="p",defaultValue = "1") Integer page) {
		int getPage = (page-1)*4;
		model.addAttribute("count", companyService.getCompanyCount("name",query));
		model.addAttribute("querys", query);
		model.addAttribute("list", companyService.getCompanyList(getPage, "name", query));
		return "root.promotion";
	}

	@GetMapping("{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		Company company = companyService.getById(id);
		if (company == null)
			return "error";
		model.addAttribute("company", company);
		return "root.promotion-detail";
	}
}
