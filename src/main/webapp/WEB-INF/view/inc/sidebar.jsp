<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
   <script type="text/javascript" src="/resources/js/side.js"></script>
   <link href="/resources/css/sidebar.css" type="text/css" rel="stylesheet">
    <aside id="aside" class="side-transition side-off " >
    <!-- class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-right" id="cbp-spmenu-s2" -->
        <div id="aside-box">
            <h1 class="d-none">사이드바</h1>
            <section id="side-title">
                <span id="text-red">M</span><span>O</span><span id="text-green">M</span><span
                    id="text-blue">O</span>
            </section>
            <div id="aside-img-box">
	            <s:authorize access="isAnonymous()">
	                <img id="goMypage" src="/resources/images/mypage.png">
	            </s:authorize>
	            <s:authorize access="isAuthenticated()">
	            	<s:authorize access="hasRole('ROLE_COMPANY')">
		                <img id="goMypageCompany" src="/resources/images/mypage.png">
	               	</s:authorize>
	                <s:authorize access="hasRole('ROLE_CUSTOMER')">
		                <img id="goMypageMember" src="/resources/images/mypage.png">
	                </s:authorize>
                </s:authorize>
                <s:authorize access="isAnonymous()">
	                <img id="goNotify" src="/resources/images/ppiyong.png">
	            </s:authorize>
	            <s:authorize access="isAuthenticated()">
	            	<s:authorize access="hasRole('ROLE_COMPANY')">
		                <img id="goNotifyCompany" src="/resources/images/ppiyong.png">
	               	</s:authorize>
	                <s:authorize access="hasRole('ROLE_CUSTOMER')">
		                <img id="goNotifyMember" src="/resources/images/ppiyong.png">
	                </s:authorize>
	                <s:authorize access="hasRole('ROLE_ADMIN')">
		                <img id="goNotifyAdmin" src="/resources/images/ppiyong.png">
	                </s:authorize>
                </s:authorize>
                <img id="goReivew" src="/resources/images/review.png">
            </div>
            <div id="aside-list-box">
                <ul>
                	<s:authorize access="isAnonymous()">
	                    <li>
	                        <div><label id="goPromotionList">홍보글 보기</label></div>
	                    </li>
	                     <li>
	                        <div><label id="login">로그인</label></div>
	                    </li>
	                     <li>
	                        <div><label id="signUp">회원가입</label></div>
	                    </li>
                    </s:authorize>	
                    
                    <s:authorize access="isAuthenticated()">
                    	<s:authorize access="hasRole('ROLE_COMPANY')">
	                    	<li>
		                        <div><label id="goPostList">고객글 보기</label></div>
		                    </li>
		                    <li>
	                        	<div><label id="goMypaperCompany">내가쓴글</label></div>
	                    	</li>
	                    </s:authorize>
                  		<s:authorize access="hasRole('ROLE_CUSTOMER')">
	                    	<li>
		                        <div><label id="goPromotionList">홍보글 보기</label></div>
		                    </li>
	                    	<li>
		                        <div><label id="goMyreview">내가쓴리뷰</label></div>
		                    </li>
		                    <li>
	                        	<div><label id="goMypaperCustomer">내가쓴글</label></div>
	                    	</li>
	                    	<li>
	                        	<div><label id="goReg">글쓰기</label></div>
	                    	</li>
	                    </s:authorize>
	                   	 	<li>
	                        <div><label id="logout">로그아웃</label></div>
	                    	</li>
                    </s:authorize>
                </ul>
            </div>
        </div>
    </aside>
