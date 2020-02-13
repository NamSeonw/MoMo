<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<link href="/resources/css/review/detail.css" type="text/css" rel="stylesheet">
	<main id="main">
		<h1 class="d-none">메인</h1>
		<section id="title-box">
			<h1 id="title">
				<span id="text-red">RE</span><span>V</span><span id="text-green">I</span><span>E</span><span
					id="text-blue">W</span>
			</h1>
		</section>
			<div id="middle-box">
	            <div>
					<div id="photo">
						<input type="image" alt="사진을 넣어주세요" src="/resources/upload/${member.loginId}/${review.photo}"/>
					</div>
					<div>
						<div id="companyInpo">
							<label>업체명</label>
							<input type="text" name="companyName" value="${review.companyName }"/>
							<label>위치</label>
							<input type="text" name="address" value="${review.companyAddress }"/>
						</div>
						<div id="reviewText">${review.content}</div>    
					</div>
				</div>
				
			</div> 
			<div id="reviewMenu">
				<c:if test="${id eq review.postId }">
					<div>
					
						<form action="/member/review/edit" method="get">
							<input type="hidden" name="id" value="${review.id }"/>
							<input id="editButton" type="submit" value="수정">
						</form>
						<form action="/member/review/del" method="get">
							<input type="hidden" name="id" value="${review.id }"/>
							<input id="delButton" type="submit" value="삭제">
						</form>
						
					</div>
				</c:if>
					<a id="listButton" onclick="window.history.back();"><span>목록</span></a>
			</div>
			<br/>
	</main>
