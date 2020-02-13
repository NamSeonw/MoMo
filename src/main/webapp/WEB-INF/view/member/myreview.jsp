<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="page" value="${(empty param.p) ? 1 : param.p}" />
<c:set var="startNum" value="${page - (page-1)%5}" />
<c:set var="lastNum"
	value="${fn:substringBefore(Math.ceil(listCount / 3) , '.')}" />
<link href="/resources/css/member/myreview.css" type="text/css" rel="stylesheet">
<script>
$(function(){
	$(".small-box").click(function(e){
		e.stopImmediatePropagation();
		e.preventDefault();
		var url = "/review/" + e.currentTarget.getAttribute("id") ;
		location.href = url;
	})
});
</script>
	<main id ="main">
		<div id=middle-box>
			<div id="title-box">

			<h1 id="title">
				<span id="text-red">MY</span><span>R</span><span id="text-green">EV</span><span>IE</span><span id="text-blue">W</span>
			</h1>
		</div>
		
		<c:forEach var="r" items="${review}">
			<div id="content-box">
				<div>
					<div class="small-box" id="${r.id }">
						<span>식당명 : </span><span>${r.companyName }</span>
						<span id="position">위치 : </span><span>${r.companyAddress }</span>
						<div id="content"><span>${r.content }</span></div>
					</div>				
					<div id="list">
						<a href="review/edit?id=${r.id }" id="edit">수정</a>
						<a href="review/del?id=${r.id }" id="del">삭제</a>
					</div>
				</div>
			</div>
		</c:forEach>

		<div class="margin-top align-center pager">
				<div id="pre">
					<c:if test="${startNum-5 < 1 }">
					</c:if>
					<c:if test="${startNum-5 >= 1 }">
						<a class="btn btn-prev"
							href="review?p=${startNum-5}&q=%f=&m=${param.m}">이전</a>
					</c:if>
				</div>
				<ul id="paging">
					<c:forEach var="i" begin="0" end="4">
						<c:if test="${startNum+i <= lastNum }">
							<li id="paging1"><c:if test="${ startNum+i == page }">
									<c:set var="currentStyle" value="orange bold" />
								</c:if> <c:if test="${ startNum+i != page}">
									<c:set var="currentStyle" value="" />
								</c:if> <a class="-text- ${currentStyle}"
								href="review?p=${startNum+i}">${startNum+i }</a>
							</li>
						</c:if>
					</c:forEach>
				</ul>
				<div id="next">
					<c:if test="${startNum+5 > lastNum }">
					</c:if>
					<c:if test="${startNum+5 <= lastNum }">
						<a class="btn btn-next"
							href="review?p=${startNum+5}&q=%f=&m=${param.m}">다음</a>
					</c:if>
				</div>
			</div>
		</div>
	
	</main>
