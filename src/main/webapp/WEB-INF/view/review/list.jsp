<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="page" value="${(empty param.p) ? 1 : param.p}" />
<c:set var="lastNum" value="${fn:substringBefore(Math.ceil(count / 10) , '.')}" />
<c:set var="startNum" value="${page - (page-1)%5}" />
<c:set var="num" value="${count -(page-1)*10}"/>
<link href="/resources/css/review/list.css" type="text/css" rel="stylesheet">
<link href="/resources/css/search.css" type="text/css" rel="stylesheet">
		<main id="main">
			<h1 class="d-none">메인</h1>
			<section id="title-box">
				<h1 id="title">
					<span id="text-red">RE</span><span>V</span><span id="text-green">I</span><span>E</span><span
						id="text-blue">W</span>
				</h1>
				<form id="search-form" action="" method="post">
                    <div class="search-box">
                        <input type="text" class="search-bar" name="q" value="${param.q}"/>
                        <img class="search-mark" src="/resources/images/search.png">
                    </div>
                    <input type="hidden" name="p" value="${page}">
	            </form>
	            <script type="text/javascript">
	            $(function(){
	            	$(".search-mark").click(function(e){
	            		e.preventDefault();
	            		$("#search-form").submit();
	            	});
	            	
	            	$('input[name="q"]').keydown(function(e) {
	            		if(e.keyCode == 13){
	            			e.preventDefault();
	            			location.href="./list?p="+
	            			$('input[name="p"]').val()+"&q="+$(".search-bar").val();
	            		}
	            	});
	            });
	            </script>
			</section>
			<div id="middle-box">
				<table class="table">
					<thead>
						<tr class="title">
							<th class="w60">번호</th>
				            <th class="expand">제목</th>
				            <th class="w200">위치</th>
				            <th class="w100">작성자</th>
				            <th class="w101">작성일</th>
				       
						</tr>
					</thead>
					<tbody>
						<!-- items : 출력하려는 배열, val : 배열의 단일 값 -->
						<c:forEach var="n" items="${list }" varStatus="status">
							<tr>
								<th class="w60">${num}</th>
								<c:set var="num" value="${num-1}"/>
								<td class="expand">
									<!-- ${n.id }페이지 객체에 있는 값을 출력 --> <!-- 주석에도 빈 EL이 있으면 안됨. --> <a
									href="./${n.id }">${n.title}</a>
								</td>
								<td class="w200">${n.companyAddress }</td>
								<td class="w100">${member[status.index].loginId }</td>
								<td class="w101">${n.regdate }</td>
							</tr>
							
						</c:forEach>
					</tbody>
				</table>
			</div>
			
			<div id="paging">
				<div>
					<c:if test="${startNum-5 < 1 }">
						<a class="btn btn-prev"
							href="./list?p=${startNum-5}"></a>
					</c:if>
					<c:if test="${startNum-5 >= 1 }">
						<a class="btn btn-prev"
							href="./list?p=${startNum-5}">이전</a>
					</c:if>
				</div>
				<ul class="page">
					<c:forEach var="i" begin="0" end="4">
						<c:if test="${startNum+i <= lastNum }">
							<li id="paging1">
							<c:if test="${ startNum+i == page }">
								<c:set var="currentStyle" value="orange bold" />
							</c:if> 
							
							<c:if test="${ startNum+i != page}">
								<c:set var="currentStyle" value="" />
							</c:if> 
							
								<a class="${currentStyle}" href="./list?p=${startNum+i}"> &nbsp; ${startNum+i } &nbsp;</a>
							</li>
						</c:if>
					</c:forEach>
				</ul>
				<div id="next">
					<c:if test="${startNum+5 > lastNum }">
						<a class="btn btn-next"
							href="./list?p=${startNum+5}"></a>
					</c:if>
					<c:if test="${startNum+5 <= lastNum }">
						<a class="btn btn-next"
							href="./list?p=${startNum+5}">다음</a>
					</c:if>
				</div>
			</div>


		</main>
