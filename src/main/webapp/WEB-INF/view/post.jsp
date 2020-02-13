<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="page" value="${(empty param.p) ? 1 : param.p}" />
<c:set var="startNum" value="${page - (page-1)%5}" />
<c:set var="lastNum" value="${fn:substringBefore(Math.ceil(count / 8) , '.')}" />

<link rel="stylesheet" type="text/css" href="./resources/css/post.css">
<link rel="stylesheet" type="text/css" href="/resources/css/pager.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="./resources/js/post.js"></script>
<script type="text/javascript" src="/resources/js/click.js"></script>

        <main id="main">
            <div id="middle-box">
                <h1 class="d-none">메인</h1>
                <div>
                    <div id="title-box">
                        <h1 id="title">
                            <span id="text-red">P</span><span>O</span><span
                                id="text-green">S</span><span id="text-blue">T</span>
                        </h1>
                    </div>
                    <div class="search-box">
                        <form id="post-form" action="" method="post">
	                    <div class="search-box">
	                        <input type="text" class="search-bar"  name="q" value="${query}"/><img class="search-mark"
	                            src="/resources/images/search.png">
	                    </div>
	                    <input type="hidden" name="p" value="1">
                    </form>
                    </div>
                </div>
                <div id="content-box">
                    <ul>
                    	<c:forEach items="${postsUp}" var="post">
	                     	<li>
	                            <div class="article-bg" id="${post.id }">
	                                <div class="article-content">
	                                    <div class="customer-id-box">
	                                        <span class="brown">고객 ID: </span>
	                                        <span class="customer-id">${post.loginId }</span>
	                                    </div>
	                                    <div>
	                                        <div class="customer-content-box">
	                                            <div class="customer-content-title">
	                                                <span>인원수:</span>
	                                                <span>예약일시:</span>
	                                                <span>위치:</span>
	                                                <span>목적:</span>
	                                            </div>
	                                            <div style="width: 10px">
	                                            </div>
	                                            <div class="customer-content-text">
	                                                <span>${post.peopleCount }명</span>
	                                                <span>${post.reservationDate }</span>
	                                                <span>${post.location}</span>
	                                                <span>${post.category }</span>
	                                            </div>
	                                        </div>
	                                        <div class="customer-content-tag">
	                                            <div>내용:</div>
	                                            <div style="width:32px"></div>
	                                            <div id="post-content"><p>${post.content}</p></div>
	                                        </div>
	                                    </div>
	                                </div>
	                            </div>
	                        </li>
                        </c:forEach>
                    </ul>
                    <div class="blank"></div>
                    <ul>
                    	<c:forEach items="${postsDown}" var="post">
	                     	<li>
	                            <div class="article-bg" id="${post.id }">
	                                <div class="article-content">
	                                    <div class="customer-id-box">
	                                        <span class="brown">고객 ID: </span>
	                                        <span class="customer-id">${post.loginId }</span>
	                                    </div>
	                                    <div>
	                                        <div class="customer-content-box">
	                                            <div class="customer-content-title">
	                                                <span>인원수:</span>
	                                                <span>예약일시:</span>
	                                                <span>위치:</span>
	                                                <span>목적:</span>
	                                            </div>
	                                            <div style="width: 10px">
	                                            </div>
	                                            <div class="customer-content-text">
	                                                <span>${post.peopleCount }명</span>
	                                                <span>${post.reservationDate }</span>
	                                                <span>${post.location}</span>
	                                                <span>${post.category }</span>
	                                            </div>
	                                        </div>
	                                        <div class="customer-content-tag">
	                                            <div>내용:</div>
	                                            <div style="width:32px"></div>
	                                            <div id="post-content"><p>>${post.content }</p></div>
	                                            <!-- <div><a>#분위기 있는</a><a>#맛집</a><a>#한식</a></div> -->
	                                        </div>
	                                    </div>
	                                </div>
	                            </div>
	                            <!-- <div id="end2">약완료</div> -->
	                        </li>
                        </c:forEach>
                    </ul>
                    <div class="blank"></div>
					<div class="post-pager pager">
						<div id="pre">
							<c:if test="${startNum-5 < 1 }">
							</c:if>
							<c:if test="${startNum-5 >= 1 }">
								<a class="btn btn-prev"
									href="./post?p=${startNum-5}&q=${query }">이전</a>
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
										<a class="${currentStyle}" href="./post?p=${startNum+i}&q=${query }">${startNum+i }</a>
									</li>
								</c:if>
							</c:forEach>
						</ul>
						<div id="next">
							<c:if test="${startNum+5 > lastNum }">
							</c:if>
							<c:if test="${startNum+5 <= lastNum }">
								<a class="btn btn-next margin-left"
									href="./post?p=${startNum-5}&q=${query }">다음</a>
							</c:if>
						</div>
					</div>
                </div>
            </div>
        </main>
