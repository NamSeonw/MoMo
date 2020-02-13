<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="page" value="${(empty param.p) ? 1 : param.p}" />
<c:set var="lastNum" value="${fn:substringBefore(Math.ceil(countpaper / 3) , '.')}" />
<c:set var="startNum" value="${page - (page-1)%5}" />
<link href="/resources/css/member/matchingPaper.css" type="text/css"
	rel="stylesheet">
<script src="/resources/js/utils.js"></script>
<script src="/resources/js/selectModal.js"></script>
		<main id="main">
			<div id=middle-box>
				<div id="title-box">

					<h1 id="title">
						<span id="text-red">MY</span><span>P</span><span id="text-green">A</span><span>PE</span><span
							id="text-blue">R</span>
					</h1>
				</div>

				<div id="content-box">
					<div>
						<div class="small-box">
							<span>인원수 : </span><span>${post.peopleCount }</span> <span
								id="date">예약을 원하는 날 : </span><span>${post.reservationDate }</span>
							<span id="position">위치 : </span><span>${post.location }</span>
							<span id="time">시간 : </span><span></span>
							<div id="content">
								<span>${post.content }</span>
							</div>
						</div>
					</div>
				</div>
				
				<div id="align">
					<c:forEach items="${paper }" var="pa">
						<div id="rest-box"   >
							<div>
								<div id="${pa.id }" class="rest-small-box">
									<span>식당명 : </span><span class="company-name">${pa.name }</span>
									<div id="rest-content">
										<div style="word-break: break-all;">${pa.content }</div>
									</div>
									<input type="hidden" id="postId" value="${pa.postId }"> 
								</div>
							</div>
							<input type="hidden" id="result" value="">
						</div>
					</c:forEach>
				</div>
				
				<div class="margin-top align-center pager">
					<div id="pre">
						<c:if test="${startNum-5 < 1 }">
						</c:if>
						<c:if test="${startNum-5 >= 1 }">
							<a class="btn btn-prev"
								href="./${post.id }?p=${startNum-5}&q=&f=&m=${param.m}">이전</a>
						</c:if>
					</div>
					<ul id="paging">
						<c:forEach var="i" begin="0" end="4">
							<c:if test="${startNum+i <= lastNum }">
								<li id="paging1"><c:if test="${ startNum+i == page }">
										<c:set var="currentStyle" value="orange bold" />
									</c:if> <c:if test="${ startNum+i != page}">
										<c:set var="currentStyle" value="" />
									</c:if> <a class="${currentStyle}"
									href="./${post.id }?p=${startNum+i}&m=0">${startNum+i }</a></li>
							</c:if>
						</c:forEach>
					</ul>
					<div id="next">
						<c:if test="${startNum+5 > lastNum }">
						</c:if>
						<c:if test="${startNum+5 <= lastNum }">
							<a class="btn btn-next"
								href="./${post.id }?p=${startNum+5}&q=&f=&m=${param.m}">다음</a>
						</c:if>
					</div>
				</div>
			</div>

		</main>
