package com.momo.web.controller.l;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.momo.web.entity.BlackListView;
import com.momo.web.entity.Notify;
import com.momo.web.entity.Post;
import com.momo.web.service.BlackListService;
import com.momo.web.service.NotifyService;
import com.momo.web.service.PostService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private BlackListService blacklistService;
	@Autowired
	private PostService postService;
	@Autowired
	private NotifyService notifyService;

	@GetMapping("notify/list")
	public String notifyList(@RequestParam(name = "p", defaultValue = "1") Integer page, Model model) {
		List<BlackListView> list = blacklistService.listNotify((page - 1) * 14);
		model.addAttribute("list", list);
		model.addAttribute("count", blacklistService.getListCount(0));
		return "admin/notify/list";
	}

	@GetMapping("notify/{id}")
	public String notifyDetail(@PathVariable("id") Integer id, Model model) {
		BlackListView view = blacklistService.getNotify(id);
		Post post = postService.get(view.getPostId());
		model.addAttribute("post", model.addAttribute("view", view));
		return "admin/notify/detail";
	}

	@PostMapping("notify/{id}")
	public String notifyDetail(@PathVariable("id") Integer id, @RequestParam("memberId") Integer memberId,
			@RequestParam("companyId") Integer companyId, @RequestParam("target") String target) {
		Notify notify = notifyService.getNotify(id);
		notify.setBlacklist(1);
		notifyService.update(notify);
		switch (target) {
		case "고객":
			blacklistService.updateByTarget("Member", memberId, 1);
			break;
		case "업체":
			blacklistService.updateByTarget("Company", companyId, 1);
			break;
		default:
			break;
		}
		return "redirect: ./list";
	}
}
