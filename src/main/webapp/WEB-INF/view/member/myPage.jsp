<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="/resources/css/member/mypage.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="/resources/js/member-mypage.js"></script>
	<main id="main">
		<div id="middle-box">
			<div id="title-box">
				<h1 id="title">
					<span id="text-red">MY</span><span>P</span><span id="text-green">A</span><span>G</span><span id="text-blue">E</span>
				</h1>
			</div>
			<div id="content-box">
				<form id="form" action="mypage" method="post">
					<img id="member-icon" src="/resources/images/memberIcon.png">
					<div id="text-id"><span>아이디</span> <div class="text-box">${detail.loginId }</div></div> 
					<div id="text-pwd"><span>비밀번호변경</span> <input type="password" name="pwd" id="pwd" required></div>
					<span id="pwdconfirm" ></span>
					<div id="text-email"><span>이메일</span> <div class="text-box">${detail.email }</div></div>
					<div id="text-position"><span>위치정보</span><img id="position-icon" style="width: 25px; height: 25px;" src="/resources/images/onOffIcon.png"></div>
					<div id="text-phone"><span>휴대폰번호</span> <div id="text-box-phone" class="text-box">${detail.phone }</div></div>
					<div id="select">
					<input type="hidden" name = "id" value="${detail.id }">
					<input type="hidden" name = "email" value="${detail.email }">
					<input type="hidden" name = "phone" value="${detail.phone }">
					<input type="hidden" name = "gender" value="${detail.gender }">
					
						<a id="edit">수정</a>
						<a href="/member/memberconfirm" >탈퇴</a>
					</div>
				</form>
			</div>
		</div>
	</main>
