package com.momo.web.controller.j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.request.attribute.Addable;
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
import com.momo.web.entity.Member;
import com.momo.web.entity.Notify;
import com.momo.web.entity.Post;
import com.momo.web.service.AppealService;
import com.momo.web.service.CompanyService;
import com.momo.web.service.MemberService;
import com.momo.web.service.NotifyService;
import com.momo.web.service.PostService;

@Controller
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	@Autowired
	private AppealService appealService;
	@Autowired
	private PostService postService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private NotifyService notifyService;

	// 식당 마이페이지
	@GetMapping("mypage")
	public String mypage(Principal principal, Model model,@RequestParam(name = "state" , defaultValue="0") String state) {
		
		model.addAttribute("state",state);

		String loginId = principal.getName();
		// String loginId = "dhyej";
		Company company = companyService.getByLoginId(loginId);
		// System.out.println(company.toString());
		model.addAttribute("company", company);

		return "company.company_mypape";
	}

	// 식당 마이페이지
	@PostMapping("mypage")
	public String mypage(HttpServletResponse response, Principal principal, MultipartFile file, HttpServletRequest request, String name,
			String category, String address, String contact, String content, String pwdInput, String pwdDB,
			String photo, Model model) throws IOException {

		String loginId = principal.getName();
		Company company = companyService.getByLoginId(loginId);

		// 파일
		ServletContext application = request.getServletContext();
		String urlPath = "/resources/upload";
		String realPath = application.getRealPath(urlPath);
		File dir = new File(realPath);
		if (!dir.exists())
			dir.mkdir();
		else
			System.out.println("경로가 존재합니다.");

		// System.out.println(file);
		String fileName = file.getOriginalFilename();

		if (fileName.equals(""))
			fileName = photo;

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
		}

		company.setPhoto(fileName);

		// 비밀번호 체크
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		boolean isChk = encoder.matches(pwdInput, pwdDB);
		model.addAttribute("isChk", isChk);

		if (isChk) {
			// 수정
			company.setName(name);
			company.setCategory(category);
			company.setAddress(address);
			company.setContact(contact);
			company.setContent(content);
			companyService.update(company);
			model.addAttribute("company", company);
			
			model.addAttribute("state","1");

			return "redirect:./mypage";
		} else
			return "redirect:?error=1";
	}

	// 비밀번호변경
	@GetMapping("editpwd")
	public String editpwd() {
		return "company.company-editpwd";
	}

	// 비밀번호변경
	@PostMapping("editpwd")
	public String editpwd(Principal principal, String pwdInput, String pwdDB, Model model) {
		Company company = companyService.getByLoginId(principal.getName());

		PasswordEncoder encoder = new BCryptPasswordEncoder();
		boolean isChk = encoder.matches(pwdDB, company.getPwd());
		
		if (!companyService.isPwdChk(company.getPwd())) // 부합 하지 않으면 false
			return "redirect:?error=2";

		if (isChk) {
			// 비밀번호 수정
			company.setPwd(pwdInput);
			companyService.updatePwd(company);
			// model.addAttribute("company", company);
			return "redirect:./mypage";
		} else
			return "redirect:?error=1";
	}

	// 회원탈퇴 컨펌
	@GetMapping("confirm")
	public String confirm(Principal principal, Model model) {
		model.addAttribute("loginId", principal.getName());
		return "company.company-confirm";
	}

	@PostMapping("confirm")
	public String confirm(Principal principal, String pwd) {
		// 컴퍼니 비밀번호 일치 확인.
		Company company = companyService.getByLoginId(principal.getName());
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		boolean isChk = encoder.matches(pwd, company.getPwd());

		if (isChk) {
			// 비밀번호 수정
			return "redirect:./withdrawal";
		} else
			return "redirect:?error=1";
	}

	// 회원탈퇴
	@GetMapping("withdrawal")
	public String withdrawal(Principal principal, Model model) {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		Date nowdate = new Date();
		model.addAttribute("loginId", principal.getName());
		model.addAttribute("nowdate", format1.format(nowdate));
		return "company.company_withDrawal";
	}

	@PostMapping("withdrawal")
	public void withdrawal(HttpServletResponse response,
			Principal principal)throws IOException {
		
		response.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");
	    
		Company company = companyService.getByLoginId(principal.getName());
		
		PrintWriter out = response.getWriter();
		
		
		String json ="회원을 탈퇴하였습니다.";
		
		out.write(json);
		
		companyService.delete(company.getId());
	}

	// 글쓰기
	@GetMapping("write/{postId}")
	public String write(@PathVariable("postId") Integer postId, Principal principal, Model model) {
		Post post = postService.get(postId);
		Member member = memberService.getById(post.getMemberId());
		model.addAttribute("member",member);
		model.addAttribute("post", post);
		return "company.company_writePaper";
	}

	// 글쓰기
	@PostMapping("write/{postId}")
	public String write(Integer postId, Principal principal, Model model, String content) {
		Company company = companyService.getByLoginId(principal.getName());
		int companyId = company.getId();
		Appeal appeal = new Appeal();
		appeal.setPostId(postId);
		appeal.setCompanyId(companyId);
		appeal.setContent(content);
		appealService.insert(appeal);
		return "redirect:/post?q=";
	}

	@GetMapping("mypaper")
	public String mypaper(Principal principal, Model model,
			@RequestParam(name = "p", defaultValue = "1") Integer page) {
		Company company = companyService.getByLoginId(principal.getName());
		List<Appeal> appeals = appealService.getList((page - 1) * 2, company.getId(), 0);
		List<Map<String, Object>> list = new ArrayList<>();
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		for (Appeal appeal : appeals) {
			Map<String, Object> map = new HashMap<String, Object>();
			String time = format1.format(appeal.getRegdate());
			map.put("appeal", appeal);
			map.put("regdate", time);
			map.put("post", postService.get(appeal.getPostId()));
			list.add(map);
		}
		if(list!=null)
		model.addAttribute("list", list);
		model.addAttribute("count", appealService.getCount(company.getId(), 0));
		return "company.company_mypaper";
	}

	@PostMapping("mypaper")
	public String mypaper(Integer appealId) {
		appealService.delete(appealId);
		return "redirect:./mypaper";
	}

	@GetMapping("mypaperSuccess")
	public String mypaperSuccess(Principal principal, Model model,
			@RequestParam(name = "p", defaultValue = "1") Integer page) {
		Company company = companyService.getByLoginId(principal.getName());
		List<Appeal> appeals = appealService.getList((page - 1) * 2, company.getId(), 1);
		List<Map<String, Object>> list = new ArrayList<>();
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		for (Appeal appeal : appeals) {
			Map<String, Object> map = new HashMap<String, Object>();
			
			String time = format1.format(appeal.getRegdate());
			map.put("appeal", appeal);
			map.put("regdate", time);
			map.put("post", postService.get(appeal.getPostId()));
			list.add(map);
		}

		if(list!=null)
			model.addAttribute("list", list);
		model.addAttribute("count", appealService.getCount(company.getId(), 1));
		return "company.company_mypaper_success";
	}

	// 신고
	@GetMapping("notify")
	public String notify(@RequestParam("postId") Integer postId, @RequestParam("appealId") Integer appealId,
			Principal principal, Model model) {

		Post post = postService.get(postId);
		// Member member = memberService.getByLoginId(post.getLoginId());
		model.addAttribute("memberId", post.getLoginId());
		return "company.company-notifyMember";
	}

	// 신고
	@PostMapping("notify")
	public String notify(MultipartFile file, HttpServletRequest request, Principal principal,
			@RequestParam("postId") int postId, @RequestParam("appealId") int appealId, String title, String content,
			String photo) {
		// 파일
		ServletContext application = request.getServletContext();
		String urlPath = "/resources/upload";
		String realPath = application.getRealPath(urlPath);
		System.out.println(realPath);
		File dir = new File(realPath);
		if (!dir.exists())
			dir.mkdir();
		else
			System.out.println("경로가 존재합니다.");

		// System.out.println(file);
		String fileName = file.getOriginalFilename();

		if (fileName.equals(""))
			fileName = photo;
		System.out.println(fileName);

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
		}

		Member member = memberService.getByLoginId(principal.getName());
		Company company = companyService.getByLoginId(principal.getName());
		String target = "";
		if (member == null && company == null) {
			return "redirect:/login/login";
		} else if (member != null && company == null) {
			target = "고객";
		} else if (member == null && company != null) {
			target = "업체";
		}
		Notify notify = new Notify(title, content, fileName, target, postId, appealId, 0);
		notifyService.insert(notify);
		return "redirect:./mypaperSuccess";
	}

	@GetMapping("{id}/edit")
	public String edit(Model model, @PathVariable("id") Integer id) {
		Appeal appeal = appealService.get(id);
		model.addAttribute("appeal", appeal);
		Post post = postService.get(appeal.getPostId());
		model.addAttribute("post", post);
		Member member = memberService.getById(post.getMemberId());
		model.addAttribute("member", member);
		return "company.company_editPaper";
	}

	@PostMapping("{id}/edit")
	public String edit(@PathVariable("id") Integer id, String content) {
		Appeal appeal = appealService.get(id);
		appeal.setContent(content);
		appealService.update(appeal);
		return "redirect:../mypaper";
	}

	@GetMapping("appeal")
	@ResponseBody
	public String appeal() {

		Gson gson = new Gson();

		String json = gson.toJson(notifyService.getNotifyList());

		return json;
	}
}
