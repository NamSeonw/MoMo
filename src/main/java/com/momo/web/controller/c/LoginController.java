package com.momo.web.controller.c;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.Gson;
import com.momo.web.entity.Company;
import com.momo.web.entity.Member;
import com.momo.web.service.CompanyService;
import com.momo.web.service.LoginIdViewService;
import com.momo.web.service.MemberService;

@Controller("CLoginController")
@SessionAttributes("loginId")
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private JavaMailSenderImpl mailSender;

	@Autowired
	private MemberService memberService;

	@Autowired
	private CompanyService companyService;

	@Autowired
	private LoginIdViewService loginIdViewService;

	@GetMapping("login")
	public String login() {

		return "login.login";
	}

	@PostMapping("login")
	public String login(HttpServletRequest request, String loginId, String pwd) throws Exception {

		Member member = memberService.getByLoginId(loginId);
		Company company = companyService.getByLoginId(loginId);

		System.out.println(member);
		if (member != null && member.getPwd().equals(pwd)) {

			HttpSession session = request.getSession(true);
			session.setAttribute("loginId", loginId);

			return "redirect:index";
		} else if (company != null && company.getPwd().equals(pwd)) {

			HttpSession session = request.getSession(true);
			session.setAttribute("loginId", loginId);

			return "redirect:index";
		} else
			return "redirect:login?error=" + 1;
	}

	@GetMapping("selectSignUp")
	public String selectSignUp() {

		return "login.selectSignUp";
	}

	@GetMapping("signupAgree")
	public String signupAgree() {

		return "login.signupAgree";
	}

	@GetMapping("signup")
	public String signup() {

		return "login.signup";
	}

	@PostMapping("signup")
	public String signup(Member member, String year, String month, String day, String emailaddress,
			String checkPassword) throws ParseException {

		member.setEmail(member.getEmail() + "@" + emailaddress);

		// jsp 날짜 if문 처리
		DateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		String s = year + "-" + month + "-" + day;
		Date date = sd.parse(s);
		member.setBirthday(date);

		if (memberService.isDuplicatedId(member.getLoginId()))
			return "redirect:?error=1";
		if (!memberService.isPwdChk(member.getPwd())) // 부합 하지 않으면 false
			return "redirect:?error=2";
		if (!member.getPwd().equals(checkPassword))
			return "redirect:?error=2";
		if (!memberService.isIdChk(member.getLoginId()))
			return "redirect:?error=1";
		if (!memberService.isPhoneChk(member.getPhone()))
			return "redirect:?error=3";
		if(member.getBirthday().equals("") || member.getName().equals(""))
			return "redirect:?error=4";
		
		int result = memberService.insert(member);
		System.out.println("memberInsert:" + result);
		if (result == 1)
			return "login.signupConfirm";

		return "login.signup";
	}

	@GetMapping("companySignup")
	public String companySignup() {
		return "login.companySignup";
	}

	@PostMapping("companySignup")
	public String companySignup(Company company, String checkPassword, 
		String emailaddress, String address, String datailAddress, String extraAddress) throws ParseException {
		
		String fullAddress = "";
		
		fullAddress = address + datailAddress + extraAddress;
		
		if (companyService.isDuplicatedId(company.getLoginId()))
			return "redirect:?error=1";
		if (!companyService.isPwdChk(company.getPwd())) // 부합 하지 않으면 false
			return "redirect:?error=2";
		if (!company.getPwd().equals(checkPassword))
			return "redirect:?error=2";
		if (!companyService.isIdChk(company.getLoginId()))
			return "redirect:?error=1";
		if (!companyService.isContactChk(company.getContact()))
			return "redirect:?error=3";
		if (company.getName().equals("") || company.getContact().equals("")
				|| company.getBusinessNumber().equals("") || fullAddress.equals(""))
			return "redirect:?error=4";
		
		company.setAddress(fullAddress);
		company.setEmail(company.getEmail() + "@" + emailaddress);

		int result = companyService.insert(company);
		System.out.println(result);
		if (result == 1)
			return "login.signupConfirm";

		return "login.companySignup";
	}

	@GetMapping("signupConfirm")
	public String signupConfirm() {
		return "login.signupConfirm";
	}

	@GetMapping("findId")
	public String findId() {
		return "login.findId";
	}

	@PostMapping("findId")
	public void findId(HttpServletResponse response, @RequestParam(name = "n", defaultValue = "") String name,
			@RequestParam(name = "e", defaultValue = "") String email) throws IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		if (name.equals("") || email.equals("")) {
			out.write("정확한 정보를 입력해주세요.");
			return;
		}

		String loginId = "";
		Member member = memberService.getByNameAndEmail(name, email);
		Company company = companyService.getByNameAndEmail(name, email);

		// =========================여기할차례===========================
		if (member == null && company == null) {
			out.write("입력된 정보의 아이디가 존재하지 않습니다.");
			return;
		} else {
			if (member != null) {
				if (member.getEmail().equals(email)) {
					loginId = member.getLoginId();
				}
			}
			if (company != null) {
				if (company.getEmail().equals(email)) {
					loginId = company.getLoginId();
				}
			}

			int size = loginId.length();

			loginId = loginId.substring(0, size - 3);
			loginId += "***";

			out.write(name + "님의 아이디는 " + loginId + " 입니다.");
		}
	}

	@GetMapping("findPwd")
	public String findPwd() {
		return "login.findPwd";
	}

	@PostMapping("findPwd")
	public void findPwd(HttpServletResponse response, @RequestParam(name = "id", defaultValue = "") String id,
			@RequestParam(name = "e", defaultValue = "") String email) throws MessagingException, IOException {
		
		Member member = memberService.getByLoginIdAndEmail(id, email);
		Company company = companyService.getByLoginIdAndEmail(id, email);

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		if (id.equals("") || email.equals("")) {
			out.write("정확한 정보를 입력해주세요.");
			return;
		}
		String pwd = "111";
		if (member == null && company == null) {
			out.write("입력된 정보의 아이디가 존재하지 않습니다.");
			return;
		} else {
			if (member != null)
				if (member.getEmail().equals(email)) {
					member.setPwd(pwd);
					memberService.update(member);
				}
			if (company != null)
				if (company.getEmail().equals(email)) {
					company.setPwd(pwd);
					companyService.updatePwd(company);
				}
			String json = id + "님의 비밀번호를  " + email + "로 발송하였습니다.";
			out.write(json);

			StringBuilder html = new StringBuilder();
			html.append("<html>");
			html.append("<body>");
			html.append("<img src=\"http://localhost:8080/resources/images/logo.PNG\"><br>");
			html.append("<span style='font-size:20px;'>비밀번호 재설정:</span>");
			html.append("<span style='font-size:20px; font-weight: bold; color:#5b9bd5'>" + pwd + "</span>");
			html.append("<span style='font-size:20px;'>으로 변경되었습니다.</span>");
			html.append("</body>");
			html.append("</html>");

			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
			helper.setFrom("csw75888@gmail.com");
			helper.setTo(email);
			helper.setText(html.toString(), true);
			helper.setSubject("[Momo]비밀번호 재설정 메일");

			mailSender.send(message);
		}
	}

	@GetMapping("idConfirm")
	@ResponseBody
	public String idConfirm() {

		Gson gson = new Gson();
		String json = gson.toJson(loginIdViewService.getList());

		return json;
	}
}
