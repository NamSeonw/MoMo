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
								<span>���� ��й�ȣ</span><input id="company-pwdDB" type="password"
									name="pwdDB">
								<c:if test="${not empty param.error}">
									<div id="comfirmCompany2">��й�ȣ�� �ùٸ��� �ʽ��ϴ�.</div>
								</c:if>
							</div>
							<div id="pwd">
								<span>���� ��й�ȣ</span><input id="company-pwdInput" type="password" name="pwdInput">
								<div id=pwdConfirm></div>
							</div>
							<div id="explan">
								<span id="confirm-text2">�� ���� ��й�ȣ�� ���� �� ��й�ȣ�� ��Ȯ�� �Է��Ͽ� �ּ���.</span>
							</div>
							<div id="withDrawal-btn">
								<input id="okBtn" type="submit" name="ok" value="Ȯ��"> <label
									id="cancelBtn"><span>���</span></label>
								<!-- <input id="cancelBtn" type="submit" name="cancel" value="���" > -->
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
										  $("#pwdConfirm").text("��й�ȣ�� �ҹ���,Ư������,���ڸ� �����ؾ� �մϴ�.");
									  }
									else
									  $("#pwdConfirm").text("");
								})
							})
							
							 $(window).ready(function(){
								   var url = location.search.substring(1,8);
								   
								   if(url == "error=2"){
									   alert("��й�ȣ�� �ǹٸ��� �ʽ��ϴ�.")
									   location.href = "/company/editpwd";
								   }
							   });
							</script>
						</form>
					</div>
				</div>
			</div>
		</main>
