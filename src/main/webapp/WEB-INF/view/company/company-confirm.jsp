<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css"
	href="/resources/css/company-confirm.css">
		<main id="main">
			<div id="middle-box">
				<div id="title-box">
					<h1 id="title">
						<span id="text-red">C</span><span>ON</span><span id="text-green">FI</span><span>R</span><span
							id="text-blue">M</span>
					</h1>
				</div>
				<div id="content-box">
					<div id="article-box">
						<form id="form-box" action="" method="POST">
							<div id="id">
								<span>사업자 ID</span><label id="company-id">${loginId }</label>
							</div>
							<div id="pwd">
								<span>비밀번호</span><input type="password" name="pwd"
									id="company-pwd">
								<c:if test="${not empty param.error}">
									<div id="comfirmCompany3">비밀번호가 올바르지 않습니다.</div>
								</c:if>
							</div>
							<div id="explan">
								<span id="confirm-text1">※ 사용하고 계신 아이디(${loginId })는 탈퇴할
									경우 복구가 불가능하며,</span> <span id="confirm-text2"> 탈퇴 후 회원정보 및 서비스
									이용기록은 모두 삭제됩니다.</span>
							</div>
							<div id="withDrawal-btn">
								<input id="okBtn" type="submit" name="ok" value="확인"> <a
									id="cancelBtn" href=""><span>취소</span></a>
								<!-- <input id="cancelBtn" type="submit" name="cancel" value="취소" > -->
							</div>
						</form>
					</div>
				</div>
			</div>
		</main>
