<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/resources/css/default.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/admin-notify.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
<div id="bg-box" class="side-transition">
	<jsp:include page="../../inc/header.jsp" />
	<main id="main">
		<div id="middle-box">
			<h1 class="d-none">메인</h1>
			<div id="title-box">
				<h1 id="title">
					<span id="text-red">BL</span><span>A</span><span id="text-green">CK</span><span>CHE</span><span
						id="text-blue">CK</span>
				</h1>
			</div>
			<div id="content-box">
				<div id="article-box">
					<div id="post-info">
						<div class="info-title">
							<div id="post-title" class="title">
								<div id="memberId"><span>고객ID</span></div>
							</div>
							<div>
								<div id="peopleCount" class="info-title"><span>인원수</span></div>
								<div id="category" class="info-title"><span>목적</span></div>
							</div>
							<div>
								<div id="location" class="info-title"><span>위치</span></div>
								<div id="reservationDate" class="info-title"><span>예약일</span></div>
							</div>
						</div>
						<div class="info-content">
							<div class="title">
								<div><span>${view.customerLoginId }</span></div>
							</div>
							<div>
								<div><span>${view.peopleCount }</span></div>
								<div><span>${post.category }</span></div>
							</div>
							<div>
								<div><span>${view.companyAddress }</span></div>
								<div><span>${view.reservationDate }</span></div>
							</div>
						</div>
					</div>
					<div id="appeal-info">
						<div>
							<div>
								<div class="info-title title"><span>업체이름</span></div>
							</div>
							<div>
								<div class="info-title"><span>등록일</span></div>
								<div class="info-title"><span>연락처</span></div>
							</div>
						</div>
						<div  class="info-content">
							<div>
								<div class="title"><span>${view.companyName }</span></div>
							</div>
							<div>
								<div><span>${view.regdate }</span></div>
								<div><span>${view.companyContact }</span></div>
							</div>
						</div>
					</div>
				</div>
				<div  id="notify-info">
					<div>
						<div id="notify-title"><span class="bold">제목</span><span class="bolder">${view.title }</span></div>
						<div id="notify-content-title"><span class="bold">내용</span></div>
						<div id="notify-content"><span class="bolder">${view.content }</span></div>
						<%-- <div id="notify-img-box"><img src="/resources/upload/${view.customerLoginId }/${view.photo}" alt=""></div> --%>
					</div>
				</div>
				<div id="btn-box">
						<a id="goList" href="" >목록</a>
						<a id="chk" href="" >처리</a>
						<form id="frm" method="post">
							<input type="hidden" name="memberId" value="${view.memberId}"/>
							<input type="hidden" name="companyId" value="${view.companyId}"/>
							<input type="hidden" name="target" value="${view.target}"/>
						</form>
						<script type="text/javascript">
							$(function(){
								$("#goList").click(function(e){
									e.preventDefault();
									window.history.back();
								});
								
								$("#chk").click(function(e){
									e.preventDefault();
									$("#frm").submit();
								});
								
							});
						</script>
					</div>
			</div>
		</div>
	</main>
	
	<jsp:include page="../../inc/sidebar.jsp" />
	<jsp:include page="../../inc/footer.jsp" />
</div>
</body>
</html>
