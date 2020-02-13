<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="./resources/css/index.css" type="text/css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="./resources/js/index.js"></script>

	<main id="main">
		<div id="middle-box">
			<h1 class="d-none">메인</h1>
			<div class="bg-middle-box">
				<section id="main-title-box">
					<h1>
						<span id="text-red">M</span><span>O</span><span id="text-green">M</span><span
							id="text-blue">O</span>
					</h1>
				</section>
				<form id="index-form" action="index" method="post">
				<div id="main-search-box">
					<div class="search-box">
						<input type="text" class="search-bar" name="q" /><img class="search-mark" id="search-mark-cus" src="./resources/images/search.png" width="50px" height="50px">
					</div>
				</div>
				<input type="hidden" name="p" value="${param.p}">
				</form>
			</div>
		</div>
	</main>

