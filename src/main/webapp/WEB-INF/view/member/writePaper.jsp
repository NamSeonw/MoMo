<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="/resources/css/member/writePaper.css" type="text/css" rel="stylesheet">
<script>
function submit(){
	 document.querySelector("#formId").submit();
}
</script>
	<main id="main">
        <div id="middle-box">
	        <div id="title-box">
	            <h1 id="title">
	                 <span id="text-red">WR</span><span>IT</span><span id="text-green">EP</span><span>AP</span><span id="text-blue">ER</span>
	            </h1>
	         </div>
    	     <div id="content-box">
      		  <img id="member-icon" src="/resources/images/memberIcon.png">
	     	   <form id="formId" action="writepaper" method="post">
	            <div id="input-people"><span>인원수</span><input type="number" class="text-box" name="peopleCount"></div>
	            <div id="input-date"><span>예약일시</span><input type="date" id="text-date" name="reservationDate"><input type="time" id="text-time" name="reservationTime"></div>
	            <div id="input-position"><span>위치</span><input type="text" id="text-position" class="text-box" name="location"></div>
	            <div id="input-goal"><span>목적</span><input type="text" id="text-goal" class="text-box" name="category"></div>
	            
	            <c:if test="${not empty param.error}">
			       		<span style="color: red;"id="comfirm" >
			       			내용이 30자를 넘어갑니다.
			       		</span>
			   	</c:if>
	            
	            
	            <div id="input-content"><span>내용</span>
	            <input id="text-content" type="text" name="content" placeholder=" ※30자 이내로 작성해주세요."></div>
	            <a style="cursor:pointer" onclick="submit(); return false;" id="write">작성하기</a>
	      	  </form>
	        </div>
	    </div>
	</main>
