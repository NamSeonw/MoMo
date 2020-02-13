<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="/resources/css/member/matching-complete.css" type="text/css" rel="stylesheet">
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
				<div id="post-info">
					<div id="post-title" class="title"><div id="memberId"><span>고객ID</span><span>${member.loginId }</span></div></div>
					<div>
						<div id="peopleCount"><span>인원수</span><span>${post.peopleCount }</span></div>
						<div id="category"><span>목적</span><span>${post.category }</span></div>
					</div>
					<div>
						<div id="location" ><span>위치</span><span>${post.location }</span></div>
						<div id="reservationDate"><span>예약일</span><span>${post.reservationDate }</span></div>
					</div>
					<div>
						<div id="cus-content"><span class="content-span">${post.content }</span></div>
					</div>
				</div>
				<div id="appeal-info">
					<div>
						<div id="com-name" class="title"><span>업체 이름</span><span>${paper.name }</span></div>
						<div id="com-regdate"><span>등록일</span><span class="left">${paper.regdate }</span><span class="left">연락처</span><span>${company.contact }</span></div>
					</div>
					<div>
						<div><span id="com-content" class="content-span">${paper.content }</span></div>
					</div>
				</div>
				<div id="btn-box">
					<a id="cancel" href="" >매칭취소</a>
					<a id="declaration" href="/member/notifyCompany/${paper.companyId}">신고</a> 
					<a id="review" href="/review/reg/${paper.id}">리뷰작성</a>
					<script type="text/javascript">
						window.addEventListener("load",function(){
							var cancel = document.getElementById("cancel");
							
							cancel.onclick = function (e) {
								e.preventDefault();
								document.getElementById("frm").submit();
							}
						});
					</script>
					<form id="frm" method="post">
						<input type="hidden" name="postId" value="${post.id}"/>
						<input type="hidden" name="appealId" value="${paper.id}"/>
					</form>
				</div>
			</div>
      	</div>
	</main>
