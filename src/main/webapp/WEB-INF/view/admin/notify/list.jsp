<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="page" value="${(empty param.p) ? 1 : param.p}" />
<c:set var="startNum" value="${page-(page-1)%5}" />
<c:set var="lastNum" value="${fn:substringBefore(Math.ceil(count / 14) , '.')}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/resources/css/default.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/blacklist.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/blacklist-pager.css" />
</head>
<body>
<div id="bg-box" class="side-transition">
	<jsp:include page="../../inc/header.jsp" />
	<main id="main">
		<div id="middle-box">
			<h1 class="d-none">메인</h1>
			<div id="title-box">
				<h1 id="title">
					<span id="text-red">BL</span><span>A</span><span id="text-green">CK</span><span>LI</span><span
						id="text-blue">ST</span>
				</h1>
			</div>
			<div id="content-box">
				<div id="article-box">
					<table class="list-table">
						<thead>
							<tr >
								<th class="w60">번호</th>
								<th class="expand">제목</th>
								<th class="w100">신고자</th>
								<th class="w200">신고일</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list }" var="list">
								<tr>
									<th class="w60">${list.id }</th>
									<td class="expand">
										<a href="./${list.id }">${list.title }</a>
									</td>
									<td class="w100">${list.customerLoginId }</td>
									<td class="w200">${list.regdate }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					
					<div class="margin-top align-center pager">
						<div id="pre">
							<c:if test="${startNum-5 < 1 }">
							</c:if>
							<c:if test="${startNum-5 >= 1 }">
								<a class="btn btn-prev" href="./list?p=${startNum-5}">이전</a>
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
										<a class="${currentStyle}" href="./list?p=${startNum+i}">${startNum+i }</a>
									</li>
								</c:if>
							</c:forEach>
						</ul>
						<div id="next">
							<c:if test="${startNum+5 > lastNum }">
							</c:if>
							<c:if test="${startNum+5 <= lastNum }">
								<a class="btn btn-next margin-left" href="./list?p=${startNum+5}">다음</a>
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
	
	<jsp:include page="../../inc/sidebar.jsp" />
	<jsp:include page="../../inc/footer.jsp" />
</div>
</body>
</html>