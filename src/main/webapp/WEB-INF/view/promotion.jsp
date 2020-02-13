<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="page" value="${(empty param.p) ? 1 : param.p}" />
<c:set var="startNum" value="${page-(page-1)%5}" />
<c:set var="lastNum" value="${fn:substringBefore(Math.ceil(count / 4) , '.')}" />

    <link rel="stylesheet" type="text/css" href="/resources/css/promotion.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/pager.css">
    <script type="text/javascript" src="/resources/js/promotion-list.js"></script>
    <script type="text/javascript" src="/resources/js/click.js"></script>
        <main id="main">
            <div id="middle-box">
                <h1 class="d-none">메인</h1>
                <div>
                    <div id="title-box">
                        <h1 id="title">
                            <span id="text-red">RE</span><span>S</span><span
                                id="text-green">TAU</span><span>RA</span><span id="text-blue">NT</span>
                        </h1>
                    </div>
                    <form id="promotion-form" action="" method="post">
	                    <div class="search-box">
	                        <input type="text" class="search-bar"  name="q" value="${querys }"/><img class="search-mark"
	                            src="/resources/images/search.png">
	                    </div>
	                    <input type="hidden" name="p" value="${page}">
	                </form>
                </div>
                <div id="content-box">
                    <ul>
                    	<c:forEach items="${list }" var="list">
                        <li>
                            <div class="article-bg" id="${list.id }">
                                <div class="article-content">
                                    <img src="/resources/upload/${list.photo}" width="150px">
                                    <label class="label-title">${list.name }</label>
                                    <div class="content-div">
	                                    <label class="label-location">${list.address }</label>
	                                  	<label class="label-category">${list.category }</label>
	                                  	<label class="label-contact">${list.contact }</label>
                                  	</div>
                                </div>
                            </div>
                        </li>
                        </c:forEach>
                    </ul>
					<div class="margin-top align-center pager">
						<div id="pre">
							<c:if test="${startNum-5 < 1 }">
							</c:if>
							<c:if test="${startNum-5 >= 1 }">
								<a class="btn btn-prev"
									href="./list?p=${startNum-5}&q=${querys }">이전</a>
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
										<a class="${currentStyle}" href="./list?p=${startNum+i}&q=${querys }">${startNum+i }</a>
									</li>
								</c:if>
							</c:forEach>
						</ul>
						<div id="next">
							<c:if test="${startNum+5 > lastNum }">
							</c:if>
							<c:if test="${startNum+5 <= lastNum }">
								<a class="btn btn-next margin-left"
									href="./list?p=${startNum+5}&q=${querys }">다음</a>
							</c:if>
						</div>
					</div>
                </div>
            </div>
        </main>
