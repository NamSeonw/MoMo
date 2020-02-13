<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="page" value="${(empty param.p) ? 1 : param.p}" />
<c:set var="startNum" value="${page - (page-1)%5}" />

<c:if test="${param.m == 0}">
	<c:set var="lastNum" value="${fn:substringBefore(Math.ceil(countmatching / 3) , '.')}" />
	<c:set var="matchingcolor1" value="matchingcolor1" />
</c:if>

<c:if test="${param.m == 1}">
	<c:set var="lastNum" value="${fn:substringBefore(Math.ceil(countcomplete / 3) , '.')}" />
	<c:set var="matchingcolor2" value="matchingcolor2" />
</c:if>

<link href="/resources/css/member/mypaper.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="/resources/js/member-mypaper.js"></script>

	<input type="hidden" name="p" value="${param.p}">
	<input type="hidden" name="q" value="${param.q}">
	<input type="hidden" name="f" value="${param.f}">
	<input type="hidden" id="m" name="m" value="${param.m}">
	<input type="hidden" name="memberId" value="${param.memberId}">
	<input type="hidden" name="c" value="${param.c}">
	
	<main id ="main">
		<div id=middle-box>
			<div id="title-box">

			<h1 id="title">
				<span id="text-red">MY</span><span>P</span><span id="text-green">A</span><span>PE</span><span id="text-blue">R</span>
			</h1>
		</div>

		<div id="matching">
			<a id="matching-text" href="/member/mypaper?p=1&q=%f=&m=0" class="${matchingcolor1}">매칭중</a>
			<span>/</span>
			<a id="matching-complete" href="/member/mypaper?p=1&q=%f=&m=1" class="${matchingcolor2}">매칭완료</a>
		</div>
		<c:forEach var="d" items="${detail}">
			<div id="content-box">
				<div>
					<div class="small-box" id="${d.id }">
						<span>인원수 : </span><span>${d.peopleCount }</span>
						<span id="date">예약을 원하는 날 : </span><span>${d.reservationDate }</span>
						<span id="position">위치 : </span><span>${d.location }</span>
						<span id="time">시간 : </span><span>20:20</span>
						<div id="content"><span>${d.content }</span></div>
					</div>
						<div id="list">
							<c:if test="${param.m == 0}">
								<a href="mypaper/del?id=${d.id }&p=${param.p}&m=${param.m}" id="del">삭제</a>
								<a href="mypaper/edit?id=${d.id }" id="edit">수정</a>
							</c:if>
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
							href="mypaper?p=${startNum-5}&q=%f=&m=${param.m}">이전</a>
					</c:if>
				</div>
				<ul id="paging">
					<c:forEach var="i" begin="0" end="4">
						<c:if test="${startNum+i <= lastNum }">
							<li id="paging1">
							<c:if test="${ startNum+i == page }">
								<c:set var="currentStyle" value="orange bold" />
							</c:if> 
							<c:if test="${ startNum+i != page}">
								<c:set var="currentStyle" value="" />
							</c:if> 
								<a class="${currentStyle}" href="mypaper?p=${startNum+i}&q=%f=&m=${param.m}">${startNum+i }</a>
							</li>
						</c:if>
					</c:forEach>
				</ul>
				<div id="next">
					<c:if test="${startNum+5 > lastNum }">
					</c:if>
					<c:if test="${startNum+5 <= lastNum }">
						<a class="btn btn-next"
							href="mypaper?p=${startNum+5}&q=%f=&m=${param.m}">다음</a>
					</c:if>
				</div>
			</div>
		</div>
	
	</main>
