<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="/resources/css/login/findPwd.css" type="text/css" rel="stylesheet">
<script src="/resources/js/utils.js"></script>
<script src="/resources/js/findPwdModal.js"></script>
	<main id="main">
		<div id="middle-box">
			
			<h1 class="d-none">메인</h1>
			<div class="toptop">
				<section id="title-box">
					<h1 id="title">
						<span id="text-red">M</span><span>o</span><span id="text-green">M</span><span
							id="text-blue">o</span>
					</h1>
				</section>
				
				<div class="main-top">
					<h2>임시 비밀번호 발급</h2>
					<span>가입하신 이메일로 임시 비밀번호를 보내드립니다.<br> 로그인 후 반드시 비밀번호를 변경하시기 바랍니다.</span>
				</div>
			</div>
			<hr id="visible-hr">
			
			<div id="findPwd-form">
				<form id="find-form" action="findPwd" method="post">
					<div id="input-form">
						<div>
						<span id="id-text">ID</span>
						<input id="id" type="text" name="id"/>
						</div>

						<div>
						<span>E-MAIL</span>
						<input id="email" type="email" name="email"/>
						</div>
						<input type="hidden" id="result" value="">
					</div>
					<div id="button-form">
						<input id="findPwd" type="submit" value="임시 비밀번호 발급" />
						<a href="login"><input type="button"  value="취소"></a>
					</div>
				</form>
			</div>
		</div>
	</main>
