<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="/resources/css/member/editpaper.css" type="text/css" rel="stylesheet">

<script>
	function submit(){
		 document.querySelector("#formId").submit();
	}
</script>
    <main id="main">
        <div id="middle-box">
	        <div id="title-box">
	            <h1 id="title">
	                 <span id="text-red">ED</span><span>IT</span><span id="text-green">PA</span><span>P</span><span id="text-blue">ER</span>
	            </h1>
	         </div>
    	     <div id="content-box">
      		  <img id="member-icon" src="/resources/images/memberIcon.png">
	     	   <form id="formId" action="edit" method="POST">
	     	   <input type="hidden" name="id"value="${detail.id }">
	     	   <input type="hidden" name="memberId" value="${detail.memberId }">
	            <div id="input-people"><span>인원수</span><input type="number" class="text-box" name="peopleCount" value="${detail.peopleCount }"></div>
	            <div id="input-date"><span>예약일시</span><input type="date" id="text-date" name="reservationDate" value="${detail.reservationDate }"><input name="reservationTime" type="time" id="text-time"></div>
	            <div id="input-position"><span>위치</span><input type="text" id="text-position" name="location" class="text-box" value="${detail.location }"></div>
	            <div id="input-goal"><span>목적</span><input type="text" id="text-goal" name="category" class="text-box" value="${detail.category }"></div>
	            <div id="input-content"><span>내용</span><input id="text-content" type="text" name="content" value="${detail.content }"></div>
	            <a style="cursor:pointer" onclick="submit(); return false;" id="btn">수정하기</a>
	      	  </form>
	        </div>
	    </div>
	</main>
