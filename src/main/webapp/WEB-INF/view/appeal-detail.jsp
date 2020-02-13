<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   <link rel="stylesheet" type="text/css" href="/resources/css/detail.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
   <script type="text/javascript" src="/resources/js/click.js"></script>
   
      <main id="main">
         <div id="middle-box">
            <h1 class="d-none">메인</h1>
            <div id="title-box">
               <h1 id="title">
                  <span id="text-red">RE</span><span>S</span><span id="text-green">TAU</span><span>RA</span><span
                     id="text-blue">NT</span>
               </h1>
            </div>
            <div id="content-box">
               <div id="article-box">
               <div></div>
                  <div id="com-info-box">
                     <div>
                        <div id="com-box-img">
                           <img src="/resources/images/company.png" width="20px" height="20px">
                        </div>
                        <div id="info-text-title">
                           <div id="name">
                              <span>상호명</span>
                           </div>
                           <div id="menu">
                              <span>업종</span>
                           </div>
                           <div id="location">
                              <span>위치</span>
                           </div>
                           <div id="contact">
                              <span>연락처</span>
                           </div>
                           </div>
                        <div id="info-text-content">
                           <div id="name-content">
                              <span>${company.name }</span>
                           </div>
                           <div id="menu-content">
                              <span>${company.category }</span>
                           </div>
                           <div id="location-content">
                              <span class="special-text">${company.address }</span>
                           </div>
                           <div id="contact-content">
                              <span >${company.contact }</span>
                           </div>
                        </div>
                     </div>
                     <div id="info-img">
                        <img src="/resources/images/korSoup.png" width="250px" height="150px">
                     </div>
                  </div>
                  <div id="com-content-box">
                     <div>
                        <span>
                          ${company.content }
                        </span>
                     </div>
                  </div>
                  <div id="btn-box">
                  	<div id="btn-content">
	                  	<a id="back">뒤로</a>
	                  	<a id="select">선택</a>
                  	</div>
                  </div>
               </div>
            </div>
         </div>
      </main>
</html>