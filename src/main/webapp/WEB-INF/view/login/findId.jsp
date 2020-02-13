<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="/resources/css/login/findId.css" type="text/css" rel="stylesheet">
<script src="/resources/js/utils.js"></script>
<script src="/resources/js/findIdModal.js"></script>
	<main id="main">
		<div id="middle-box">
			<div id="normalize">
				<h1 class="d-none">메인</h1>
				<section id="title-box">
					<h1 id="title">
						<span id="text-red">M</span><span>o</span><span id="text-green">M</span><span
							id="text-blue">o</span>
					</h1>
					<h2>아이디 찾기</h2>
					<span>회원가입 시,입력하신 이름+이메일로 아이디를 확인할 수 있습니다.</span>
				</section>
				
				<hr id="visible-hr">
				
				<c:if test="${not empty param.error }">
							<div style="color: red;">이름과 이메일이 일치하지 않습니다.</div>
	
				</c:if>
				
				<div id="findId-form">
					<form id="find-form" action="findId" method="post">
						<div id="input-form">
							<div>
							<span id="name-text">NAME</span>
							<input id="name" type="text" name="name"/>
							</div>
	
							<div>
							<span>E-MAIL</span>
							<input id="email" type="email" name="email"/>
							</div>
							<input type="hidden" id="result" value="">
						</div>
						<div id="button-form">
							<input type="submit" id="findId" value="아이디찾기" />
							<a href="login"><input type="button"  value="취소"></a>
						</div>
					</form>
				</div>
			</div>
		</div>
	</main>
