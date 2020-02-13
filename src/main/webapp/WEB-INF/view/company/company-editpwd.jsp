<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css" href="/resources/css/company-editpwd.css">
		<main id="main">
			<div id="middle-box">
				<div id="title-box">
					<h1 id="title">
						<span id="text-red">E</span><span>DI</span><span id="text-green">TP</span><span>W</span><span
							id="text-blue">D</span>
					</h1>
				</div>
				<div id="content-box">
					<div id="article-box">
						<form id="form-box" action="" method="POST">
							<div id="id">
								<span>현재 비밀번호</span><input id="company-pwdDB" type="password"
									name="pwdDB">
								<c:if test="${not empty param.error}">
									<div id="comfirmCompany2">비밀번호가 올바르지 않습니다.</div>
								</c:if>
							</div>
							<div id="pwd">
								<span>변경 비밀번호</span><input id="company-pwdInput" type="password" name="pwdInput">
								<div id=pwdConfirm></div>
							</div>
							<div id="explan">
								<span id="confirm-text2">※ 현재 비밀번호와 변경 할 비밀번호를 정확히 입력하여 주세요.</span>
							</div>
							<div id="withDrawal-btn">
								<input id="okBtn" type="submit" name="ok" value="확인"> <label
									id="cancelBtn"><span>취소</span></label>
								<!-- <input id="cancelBtn" type="submit" name="cancel" value="취소" > -->
							</div>
							<script>
							$(document).ready(function(){
								
								$('#cancelBtn').on("click",function(e){
									e.preventDefault();
									e.stopPropagation();
									location.href="./mypage";
								})
								
								$('#company-pwdInput').on("change",function(){
									var pwd = $('#company-pwdInput').val();
									var regPwd = /^(?=.*\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-z]).{9,15}$/;
									if(!regPwd.test(pwd)){
										  $("#pwdConfirm").text("비밀번호는 소문자,특수문자,숫자를 포함해야 합니다.");
									  }
									else
									  $("#pwdConfirm").text("");
								})
							})
							
							 $(window).ready(function(){
								   var url = location.search.substring(1,8);
								   
								   if(url == "error=2"){
									   alert("비밀번호가 옳바르지 않습니다.")
									   location.href = "/company/editpwd";
								   }
							   });
							</script>
						</form>
					</div>
				</div>
			</div>
		</main>
