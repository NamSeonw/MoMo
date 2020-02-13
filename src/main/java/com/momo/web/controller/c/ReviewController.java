package com.momo.web.controller.c;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.momo.web.entity.Appeal;
import com.momo.web.entity.Company;
import com.momo.web.entity.Member;
import com.momo.web.entity.Post;
import com.momo.web.entity.Review;
import com.momo.web.entity.ReviewView;
import com.momo.web.service.AppealService;
import com.momo.web.service.CompanyService;
import com.momo.web.service.MemberService;
import com.momo.web.service.PostService;
import com.momo.web.service.ReviewService;

@Controller("CReviewController")
@RequestMapping("/review/")
public class ReviewController {
	
	@Autowired
	private PostService postService;
	@Autowired
	private	MemberService memberService;
	
	@Autowired
	private ReviewService reviewService;

	@Autowired
	private CompanyService companyService;
	@Autowired
	private AppealService appealService;

	@GetMapping("list")
	public String list(
			@RequestParam(name = "p", defaultValue = "1") Integer page,
			@RequestParam(name = "q", defaultValue = "") String query,
			Model model) {

		List<ReviewView> list = reviewService.getReviewList((page - 1) * 10, "name", query);
		int reviewCount = reviewService.getReviewCount("name", query);
		List<Post> postList = new ArrayList<Post>();
		List<Member> memberList = new ArrayList<Member>();
		String regdate = "";

		for (ReviewView r : list) {
			postList.add(postService.get(r.getPostId()));
			regdate = r.getRegdate().substring(0,10);
			r.setRegdate(regdate);
		}
		
		for(Post p:postList) {
			memberList.add(memberService.getById(p.getMemberId()));
		}
		model.addAttribute("list", list);
		model.addAttribute("member", memberList);
		model.addAttribute("count", reviewCount);

		return "review.list";
	}
	
	@PostMapping("list")
	public String list(
			@RequestParam(name = "q", defaultValue = "") String query,
			@RequestParam(name = "p", defaultValue = "1") Integer page,
			Model model) {
		
		List<ReviewView> list = reviewService.getReviewList(page-1, "name", query);
		int reviewCount = reviewService.getReviewCount("name", query);
		List<Post> postList = new ArrayList<Post>();
		List<Member> memberList = new ArrayList<Member>();
		String regdate = "";

		for (ReviewView r : list) {
			postList.add(postService.get(r.getPostId()));
			regdate = r.getRegdate().substring(0,10);
			r.setRegdate(regdate);
		}
		
		for(Post p:postList) {
			memberList.add(memberService.getById(p.getMemberId()));
		}
		model.addAttribute("list", list);
		model.addAttribute("member", memberList);
		model.addAttribute("count", reviewCount);
		
		return "review.list";
	}

	@GetMapping("{id}")
	public String detail(@PathVariable("id") Integer id, Model model, Principal principal) {
		ReviewView review = reviewService.getReview(id);
		Post post = postService.get(review.getPostId());
		Member member = memberService.getById(post.getMemberId());
		if (principal != null) {
			String loginId = principal.getName();
			if (memberService.getByLoginId(loginId) != null)
				model.addAttribute("id", memberService.getByLoginId(loginId).getId());
			else
				model.addAttribute("id", companyService.getByLoginId(loginId).getId());
		} else
			model.addAttribute("id", "");
		model.addAttribute("review", review);
		model.addAttribute("member",member);
		return "review.detail";
	}

	@GetMapping("reg/{id}")
	public String reg(@PathVariable("id") Integer id, Model model) {

		Appeal appeal = appealService.get(id);
		Company company = companyService.getById(appeal.getCompanyId());

		model.addAttribute("company", company);

		return "review.reg";
	}
	
	
	@PostMapping("reg/{id}")
	public String reg(@PathVariable("id")Integer id,MultipartFile file,HttpServletRequest request,Principal principal,Review review) {

		
		Appeal appeal = appealService.get(id);

		review.setPostId(appeal.getPostId());
		review.setAppealId(id);	
		
		ServletContext application = request.getServletContext();
		String urlPath = "/resources/upload/"+principal.getName();
		String realPath = application.getRealPath(urlPath);
		String changeName = "";
		System.out.println(realPath);
		
		long time = System.currentTimeMillis(); 

		SimpleDateFormat dayTime = new SimpleDateFormat("yymmddhhmmss");

		String str = dayTime.format(new Date(time));

		File dir = new File(realPath);
		if (!dir.exists())
			dir.mkdir();
		else
			System.out.println("경로가 존재합니다.");
		
		String fileName =str + file.getOriginalFilename();
		
		if(fileName.length() > 30) {
			changeName = fileName.substring(12, fileName.length()-1);
			changeName = str+changeName;
		}
		
		if (fileName.equals(""))
			fileName = review.getPhoto();
		
		InputStream fis;
		try {
			fis = file.getInputStream();

			OutputStream fos = new FileOutputStream(realPath + File.separator + fileName);
			
			byte[] buf = new byte[1024];
			int size = 0;

			while ((size = fis.read(buf)) != -1)
				fos.write(buf, 0, size);
				fos.close();
		} catch (IOException e) {
			return "redirect:/error?ecode=500";
		}
		
		review.setPhoto(str+file.getOriginalFilename());
		
		int result = reviewService.insert(review);
		
		if(result==1)
			return "redirect:/review/list";
		
		return "review.reg/{id}";
	}
}
