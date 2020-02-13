<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="page" value="${(empty param.p) ? 1 : param.p}" />
<c:set var="startNum" value="${page - (page-1)%5}" />
<c:set var="lastNum" value="${fn:substringBefore(Math.ceil(count / 2) , '.')}" />
<link rel="stylesheet" type="text/css" href="/resources/css/company_mypaper.css">
<link rel="stylesheet" type="text/css" href="/resources/css/pager.css">
<script type="text/javascript" src="/resources/js/company-matching.js"></script>
		<main id="main">
		<div id="middle-box">
			<h1 class="d-none">메인</h1>
			<div id="title-box">
				<h1 id="title">
					<span id="text-red">MY</span><span>P</span><span id="text-green">A</span><span>PE</span><span
						id="text-blue">R</span>
				</h1>
			</div>
			<div id="content-box">
				<!-- MYPAPER -->
				<div id="matching">
					<span id="matching-ing" class="matching-text">매칭중</span> / <span id="matching-complete">매칭완료</span>
				</div>
				<c:forEach items="${list }" var="list">
					<div id="article-box">
					<form action="" method="post">
						<div id="article-inbox">
							<div id="customer-article">
								<div class="article-inbox-title">
									<span>고객ID: <label>${list.post.loginId }</label></span>
									<input type="hidden" name="appealId" value="${list.appeal.id }"/>
								</div>
								<div class="customer-article-input">
									<span>인원수: <label>${list.post.peopleCount }명</label></span> <span>일시: 
									<label>${list.post.reservationDate }</label></span> <span>위치: <label>${list.post.location }</label></span> <span>목적: <label>${list.post.category }</label></span>
								</div>
							</div>
							<div id="company-article">
								<div class="article-inbox-title">
									<span>${list.regdate }</span>
								</div>
								<div class="company-article-input">${list.appeal.content }</div>
							</div>
						</div>
						<div id="removeBtn-box">
							<a id="removeBtn" href="">삭제</a>
						</div>
						<script type="text/javascript">
						window.addEventListener("load",function(){
							var form = document.querySelector("form");
							var removeBtn = document.querySelector("#removeBtn");
							removeBtn.onclick=function(e){
								e.stopPropagation();
								e.preventDefault();
								form.submit();
							};
						});
						</script>
					</form>
				</div>
				</c:forEach>
				<div class="com-papper post-pager pager">
						<div id="pre">
							<c:if test="${startNum-5 < 1 }">
							</c:if>
							<c:if test="${startNum-5 >= 1 }">
								<a class="btn btn-prev"
									href="./mypaper?p=${startNum-5}">이전</a>
							</c:if>
						</div>
						<ul id="pages">
							<c:forEach var="i" begin="0" end="4">
								<c:if test="${startNum+i <= lastNum }">
									<li class="margin-left btn">
									<c:if test="${ startNum+i == page }">
										<c:set var="currentStyle" value="orange bold" />
									</c:if> 
									<c:if test="${ startNum+i != page}">
										<c:set var="currentStyle" value="" />
									</c:if> 
										<a class="${currentStyle}" href="./mypaper?p=${startNum+i}">${startNum+i }</a>
									</li>
								</c:if>
							</c:forEach>
						</ul>
						<div id="next">
							<c:if test="${startNum+5 > lastNum }">
							</c:if>
							<c:if test="${startNum+5 <= lastNum }">
								<a class="btn btn-next margin-left"
									href="./mypaper?p=${startNum-5}">다음</a>
							</c:if>
						</div>
					</div>
			</div>
		</div>
		</main>
