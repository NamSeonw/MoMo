<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="/resources/css/login/login.css" type="text/css"
	rel="stylesheet">
		<main id="main">
		<div id="middle-box">
			<h1 class="d-none">메인</h1>
			<section id="title-box">
				<h1 id="title">
					<a href="/index"><span id="text-red">M</span><span>O</span><span id="text-green">M</span><span
						id="text-blue">O</span></a>
				</h1>
			</section>
			<div id="loginBox">
				<div>
					<h2>Log In</h2>
					<br>
					<c:if test="${not empty param.error }">
						<div style="color: red;">아이디 또는 비밀번호가 올바르지 않습니다.</div>

					</c:if>
				</div>
				<form id="loginForm" action="login" method="post">
					<div id="inputArea">
						<div>
							<label>아이디</label> <input type="text" name="username" /><br>
						</div>
						<div>

							<label>비밀번호</label> <input type="password" name="password" />
						</div>
					</div>
					<div id=loginButton>
						<!--#2E75B6
							<img src="resources/images/loginButton.png"/>-->
						<input type="submit" name="login" value="로그인"> <input
							type="hidden" name="returnUrl" value="${returnUrl}" />
					</div>
				</form>
			</div>
			<div id="loginMenu">
				<ul>
					<li><a href="/login/findId">아이디 찾기</a></li>
					<li><a href="/login/findPwd">비밀번호 찾기</a></li>
					<li><a href="/login/signupAgree">회원가입</a></li>
				</ul>
			</div>
		</div>
		</main>
