<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="/resources/css/member/memberConfirm.css" type="text/css" rel="stylesheet">
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
			         <c:if test="${not empty param.error}">
			       		<div id="comfirm" >
			       			비밀번호가 올바르지 않습니다.
			       		</div>
			   		</c:if>
                  <div id="id">
                     <span>회원 ID</span><div id="company-id">${member.loginId}</div>
                  </div>
                  <div id="pwd">
                     <span>비밀번호</span><input type="password" name="pwd" id="company-pwd" >
                  </div>
                  <span id="confirm-text">정말로 탈퇴 하시겠습니까?</span>
                  <div id="withDrawal-btn">
                     <input type="submit" value="확인">
                  </div>
               </form>
            </div>
         </div>
      </div>
      </main>
