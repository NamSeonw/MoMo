package com.momo.web.controller.l;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.momo.web.service.CompanyService;
import com.momo.web.service.MemberService;
import com.momo.web.service.PostService;

@Controller("LHomeController")
@RequestMapping("/")
public class HomeController {
	@Autowired
	private CompanyService companyService;
	@Autowired
	private PostService postService;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index() {
		return "root.index";
	}

	@PostMapping("index")
	public String index(Principal principal, Model model, @RequestParam("q") String query) {
		//// default는 promotion/list
		//// Member가 로그인하면 promotion/list
		//// Company가 로그인하면 post
		model.addAttribute("q", query);
		if (principal != null && companyService.getByLoginId(principal.getName()) != null)
			return "redirect:post";
		return "redirect:promotion/list";
	}

	@GetMapping("post")
	public String list(
			Model model, 
			@RequestParam("q") String query,
			@RequestParam(name="p",defaultValue = "1") Integer page) {
		model.addAttribute("count", postService.getTotalCount("category", query));
		model.addAttribute("query", query);
		model.addAttribute("postsUp", postService.getList((page-1)*4, "category", query));
		model.addAttribute("postsDown", postService.getList((page)*4, "category", query));
		return "root.post";
	}

	@PostMapping("post")
	public String lists(
			Model model, 
			@RequestParam("q") String query,
			@RequestParam(name="p",defaultValue = "1") Integer page
			) {
		model.addAttribute("count", postService.getTotalCount("category", query));
		model.addAttribute("query", query);
		model.addAttribute("postsUp", postService.getList((page-1)*4, "category", query));
		model.addAttribute("postsDown", postService.getList((page)*4, "category", query));
		return "root.post";
//		redirect:/company/write/{id}
	}
}
