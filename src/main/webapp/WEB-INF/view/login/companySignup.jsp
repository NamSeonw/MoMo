<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="/resources/css/login/companySignUp.css" type="text/css" rel="stylesheet">
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="/resources/js/companysignup.js"></script>
	<main id="main">
		<div id="middle-box">
			<h1 class="d-none">메인</h1>
			<section id="title-box">
				<h1 id="title">
					<span id="text-red">M</span><span>o</span><span id="text-green">M</span><span
						id="text-blue">o</span>
				</h1>
			</section>
			
			<div id="signupForm">
				<form action="companySignup" method="post">
					<div id="formContent">
						 <div>
		                     <label>아이디</label><br>
		                     <input type="text" id="loginId" name="loginId"/>
		                     <div id="idConfirm"></div><div id="idchk"></div>
		                  </div>
		                  <div>
		                     <label>비밀번호</label><br>
		                     <input type="password" id="pwd" name="pwd"/>
		                     <div id="pwdConfirm"></div>
		                  </div>
		               
		                  <div>
		                     <label>비밀번호 확인</label><br>
		                     <input type="password" id="checkPwd" name="checkPassword"/>
		                     <div id="pwdchk"></div>
		                  </div>
 
 
						 <div id="companyDiv">
							 <div>
								 <label>상호명</label><br>
								 <input type="text" name="name"/>
							 </div>
							 
							 <div>
								<label>사업자등록번호</label><br>
								<input type="text" name="businessNumber"/>
							 </div>
						 </div>

						<div id="address1">
							<label>사업자 주소</label><br>
							<input type="text" id="postcode" onclick="execDaumPostcode()" placeholder="우편번호">
							<input type="button" id="search" onclick="execDaumPostcode()" value="우편번호 찾기">
							<input type="text" name="address" id="address" placeholder="주소" readonly>
							<input type="text" name="datailAddress" id="detailAddress" placeholder="상세주소">
							<input type="text" name="extraAddress" id="extraAddress" placeholder="참고항목" readonly>
						</div><br>
						
						 <div>
							 <label>전화번호</label> <br> 
							 <input id="contact" type="text" name="contact"><br>
								 <span id="contact-confirm"></span>
						 </div>
						 
						 <div>
							 <label>이메일</label> <br> 
							 <label><input id="inputEmail" type="text" name="email">@ 
							 <select id="emailOption" name="emailaddress">
								 <option value="naver.com">naver.com
								 <option value="daum.net">daum.net
								 <option value="gmail.com">gmail.com
							 </select></label>
						 </div>
					 </div>
					 <div id="signUpButton">
						 <a href="signupConfirm"><input type="submit" name="signUp" value="가입하기"></a>
						 <a href="login"><input type="button" name="cancel" value="취소"></a>
					 </div>
				</form>
			 </div>
		</div>
	</main>
