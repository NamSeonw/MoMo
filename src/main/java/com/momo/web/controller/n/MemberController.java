package com.momo.web.controller.n;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.sql.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.javassist.compiler.NoFieldException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.momo.web.entity.Appeal;
import com.momo.web.entity.Company;
import com.momo.web.entity.Complete;
import com.momo.web.entity.Member;
import com.momo.web.entity.PaperView;
import com.momo.web.entity.Post;
import com.momo.web.entity.Review;
import com.momo.web.entity.ReviewView;
import com.momo.web.service.AppealService;
import com.momo.web.service.CompanyService;
import com.momo.web.service.CompleteService;
import com.momo.web.service.MemberService;
import com.momo.web.service.NotifyService;
import com.momo.web.service.PaperViewService;
import com.momo.web.service.PostService;
import com.momo.web.service.ReviewService;

@Controller
@RequestMapping("/member/")
public class MemberController {
	
	@Autowired
	private MemberService memberservice;
	@Autowired
	private PostService postService;
	@Autowired
	private ReviewService reviewService;
	@Autowired
	private PaperViewService paperViewServiece;
	@Autowired
	private AppealService appealService;
	@Autowired
	private CompanyService companyService;
	@Autowired
	private CompleteService completeService;
	@Autowired
	private NotifyService notifyService;
	
	@GetMapping("mypage")
	public String myPage(Principal principal,Model model) {
		Member member = memberservice.getByLoginId(principal.getName());
		
		model.addAttribute("detail",memberservice.getByLoginId(principal.getName()));
	
		return "member.myPage";
	}
	
	@PostMapping("mypage")
	public String myPage(Member member) {
		
		memberservice.update(member);
		
		return "redirect:/index";
	}

	@GetMapping("/matchingcomplete/{id}")
	public String matchingComplete(@PathVariable("id") Integer id,Model model) {
		Post post = postService.get(id);
		Member member = memberservice.getById(post.getMemberId());
		PaperView paper = paperViewServiece.getList(1, id, 1).get(0);
		Company company = companyService.getById(paper.getCompanyId());
		
		model.addAttribute("post",post);
		model.addAttribute("member",member);
		model.addAttribute("paper",paper);
		model.addAttribute("company", company);
		return "member.matching-complete";
	}
	
	@PostMapping("/matchingcomplete/{id}")
	public String matchingComplete(Integer postId, Integer appealId) {
		Post post = postService.get(postId);
		Appeal appeal = appealService.get(appealId);
		
		post.setMatching(0);
		appeal.setMatching(0);
		
		postService.update(post);
		appealService.update(appeal);
		
		return "redirect:../matchingpaper/"+postId+"?p=1&m=0";
	}
	
	@GetMapping("memberconfirm")
	public String memberConfirm(Principal principal,Model model) { 
		
		Member member = memberservice.getByLoginId(principal.getName());
		
		model.addAttribute("member", member);
		
		return "member.memberConfirm";
	}
	
	@PostMapping("memberconfirm")
	public String memberConfirm(Principal principal,String pwd) { 
		
		Member member = memberservice.getByLoginId(principal.getName());
		
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		
		boolean isChk = encoder.matches(pwd, member.getPwd());
		
		if(isChk)
			return "redirect:withdrawal";
		
		return "redirect:?error=1";
	}
	
	@GetMapping("mypaper")
	public String myPaper(Principal principal,Model model,
							@RequestParam(name="p",defaultValue = "1") Integer page,
							@RequestParam(name="f",defaultValue = "location") String field,
							@RequestParam(name="q",defaultValue = "") String query,
							@RequestParam(name="m",defaultValue = "0") Integer matching,
							@RequestParam(name="memberId",defaultValue = "") Integer memberId,
							@RequestParam(name="c",defaultValue = "3") Integer count) { //햇음

		Member member = memberservice.getByLoginId(principal.getName());
		
		memberId = member.getId();
		
		// 멤버별 자기가 쓴글 모든 리스트
		model.addAttribute("detail",postService.getByMemberId(page, field, query, matching, memberId,count));
		
		// 멤버별 자기가 쓴 글 갯수 매칭중인거
		model.addAttribute("countmatching",postService.getCount(memberId));
		
		// 멤버별 자기가 쓴 글 갯수 매칭중인거
		model.addAttribute("countcomplete",postService.getSuccessCount(memberId));
		
		return "member.myPaper";
	}
	
	@GetMapping("/matchingpaper/{id}")
	public String myPaperDetail(@PathVariable("id") Integer id,Model model,@RequestParam("p") Integer page,@RequestParam("m") Integer matching) {
		
		matching = 0;
		
		model.addAttribute("post", postService.get(id));
		
		model.addAttribute("paper", paperViewServiece.getList(page,id,matching));
		
		model.addAttribute("countpaper" ,paperViewServiece.getListCount(id, matching));
		
		return "member.matchingPaper";
	}

	@GetMapping("/matchingSuccess/{id}")
	public String matchingSuccess(@PathVariable("id") Integer postId,
			@RequestParam("appealId") Integer appealId) {
		Post post=postService.get(postId);
		
		post.setMatching(1);
		postService.update(post);
		
		Appeal appeal=appealService.get(appealId);
		appeal.setMatching(1);
		appealService.update(appeal);
		
		Complete complete=new Complete(postId,appealId);
		completeService.insert(complete);
		
		return "redirect: ../matchingcomplete/"+ postId;
	}
	
	@GetMapping("mypaper/edit")
	public String myPaperEdit(Model model , Integer memberId, Integer id) { //햇음
		
		model.addAttribute("detail", postService.get(id));
		
		return "member.editPaper";
	}
	
	@PostMapping("mypaper/edit")
	public String myPaperEdit(Post post) { //햇음
		
		postService.update(post);
		
		return "redirect:/member/mypaper?m=0";
	}
	
	@GetMapping("writepaper")
	public String writePaper() { //햇음
		
		return "member.writePaper";
	}
	
	@PostMapping("writepaper")
	public String writePaper(Principal principal,Post post) { //햇음
		Member member=memberservice.getByLoginId(principal.getName());
		post.setMemberId(member.getId());
		int p = 1;
		int matching = 0;
		
		if(post.getContent().length()<=30) {
			postService.insert(post);
			return "redirect:mypaper?p="+p+"&m="+matching;
		}
		else
			return "redirect:?error=1";
	}
	
	@GetMapping("mypaper/del")
	public String myPaperDel(Integer id,@RequestParam("p") Integer page ,@RequestParam("m") Integer matching) { //햇음
		
		postService.delete(id);
		
		int p = 1;
		
		return "redirect:/member/mypaper?p="+p+"&m="+matching;
	}
	
	@GetMapping("withdrawal")
	public String withDrawal(Principal principal,Model model) { //햇음
		
		Member member = memberservice.getByLoginId(principal.getName());
		
		int id = member.getId();
		
		model.addAttribute("detail", member);
		
		return "member.withDrawal";
	}
	
	@PostMapping("withdrawal")
	public void withDrawal(HttpServletResponse response,
			Principal principal) throws IOException { //햇음
		
		response.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");
		
		Member member = memberservice.getByLoginId(principal.getName());
		
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		
		int id = member.getId();
			
		String json ="회원을 탈퇴하였습니다.";
		
		out.write(json);
		memberservice.delete(id);
	}
	
	@GetMapping("checkpwd")
	@ResponseBody
	public Boolean checkPwd(String pwd) {
		
		boolean result = memberservice.isPwdChk(pwd);
		
		return result;
	}
	
	@GetMapping("review")
	public String myReview(Model model,Principal principal,@RequestParam(name="p",defaultValue = "1") Integer page) {
		
		int page1 = (page-1)*3;
		
		Member member = memberservice.getByLoginId(principal.getName());
		
		model.addAttribute("review", reviewService.getListByLoginId(page1, member.getId()));
		
		model.addAttribute("listCount" , reviewService.getReviewCountByMemeber(member.getId()));
		
		return "member.myreview";
	}
	
	@GetMapping("review/del")
	public String reviewDel(Integer id,@RequestParam(name="p",defaultValue = "1") Integer page) { //햇음
		
		reviewService.delete(id);
		
		return "redirect:/review/list?p="+page;
	}
	
	@GetMapping("review/edit")
	public String reviewEdit(Model model ,Integer id,Principal principal) { //햇음
		
		Member member = memberservice.getByLoginId(principal.getName());
		
		model.addAttribute("listCount" , reviewService.getReviewCountByMemeber(member.getId()));
		
		model.addAttribute("detail", reviewService.getMapping(id));
		
		return "member.editReview";
	}
	
	@PostMapping("review/edit")
	public String reviewEdit(Review review, HttpServletRequest request,MultipartFile file,Principal principal) { //햇음
		
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

			OutputStream fos = new FileOutputStream(realPath + File.separator + file.getOriginalFilename());
			byte[] buf = new byte[1024];
			int size = 0;

			while ((size = fis.read(buf)) != -1)
				fos.write(buf, 0, size);
			fos.close();
		} catch (IOException e) {
			return "redirect:/error?ecode=500";
		}
		
		reviewService.update(review);
		
		return "redirect:/member/review";
	}
	
	@GetMapping("appeal")
	@ResponseBody
	public String appealNotify() {
		
		Gson gson = new Gson();
		
		String json = gson.toJson(notifyService.getNotifyList());
		
		return json;
	}
}
