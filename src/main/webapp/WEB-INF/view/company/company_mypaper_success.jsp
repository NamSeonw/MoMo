<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="page" value="${(empty param.p) ? 1 : param.p}" />
<c:set var="startNum" value="${page - (page-1)%5}" />
<c:set var="lastNum"
	value="${fn:substringBefore(Math.ceil(count / 2) , '.')}" />
<link rel="stylesheet" type="text/css"
	href="/resources/css/company_mypaper_success.css">
<link rel="stylesheet" type="text/css" href="/resources/css/pager.css">
<script type="text/javascript" src="/resources/js/company-matching.js"></script>
<script>
$(window).ready(function() {
	var hiddenPost = $("#hidden-post").val();
	var hiddenAppeal = $("#hidden-appeal").val();

	$.ajax({
		url : 'appeal',
		dataType : 'json',
		success : function(data) {
			$(".notifyBtn").click(function(e) {
				let d = e.currentTarget.getAttribute("id");
				for (let i = 0; i < data.length; i++) {
					if (d == data[i].appealId) {
						alert("이미 작성하신글입니다.")
						location.href = "/company/mypaperSuccess";
					} else
						location.href = "./notify?postId="
								+ hiddenPost
								+ "&appealId="
								+ hiddenAppeal;
				}
			})
		}
	})
});
</script>
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
				<span id="matching-ing">매칭중</span> / <span id="matching-complete"
					class="matching-text">매칭완료</span>
			</div>
			<c:forEach items="${list }" var="list">
				<div id="article-box">
					<div id="article-inbox">
						<div id="customer-article">
							<div class="article-inbox-title">
								<span>고객ID: <label id="customerId">${list.post.loginId }</label></span>
							</div>
							<div class="customer-article-input">
								<span>인원수: <label>${list.post.peopleCount }명</label></span> <span>일시:
									<label>${list.post.reservationDate }</label>
								</span> <span>위치: <label>${list.post.location }</label></span> <span>목적:
									<label>${list.post.category }</label>
								</span>
							</div>
						</div>

						<div id="company-article">
							<div class="article-inbox-title">
								<span>${list.regdate }</span>
							</div>
							<div class="company-article-input">${list.appeal.content }</div>
						</div>
					</div>
					<div id="notifyBtn-box">
						<a class="notifyBtn" id="${list.appeal.id}">신고</a>
					</div>
					<input type="hidden" id="hidden-post" value="${list.post.id}">
					<input type="hidden" id="hidden-appeal" value="${list.appeal.id}">

				</div>
			</c:forEach>
			<div class="success-pager post-pager pager">
				<div id="pre">
					<c:if test="${startNum-5 < 1 }">
					</c:if>
					<c:if test="${startNum-5 >= 1 }">
						<a class="btn btn-prev" href="./mypaperSuccess?p=${startNum-5}">이전</a>
					</c:if>
				</div>
				<ul id="pages">
					<c:forEach var="i" begin="0" end="4">
						<c:if test="${startNum+i <= lastNum }">
							<li class="margin-left btn"><c:if
									test="${ startNum+i == page }">
									<c:set var="currentStyle" value="orange bold" />
								</c:if> <c:if test="${ startNum+i != page}">
									<c:set var="currentStyle" value="" />
								</c:if> <a class="${currentStyle}"
								href="./mypaperSuccess?p=${startNum+i}">${startNum+i }</a></li>
						</c:if>
					</c:forEach>
				</ul>
				<div id="next">
					<c:if test="${startNum+5 > lastNum }">
					</c:if>
					<c:if test="${startNum+5 <= lastNum }">
						<a class="btn btn-next margin-left"
							href="./mypaperSuccess?p=${startNum-5}">다음</a>
					</c:if>
				</div>
				<script>

				</script>
			</div>
		</div>
	</div>
</main>
