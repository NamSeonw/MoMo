<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>

<head>
    <title><tiles:insertAttribute name ="title"/></title>
    <meta charset="UTF-8">
    <title>공지사항목록</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/default.css">
    <link href="/resources/css/layout.css" type="text/css" rel="stylesheet" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>

<body>

	<div id="bg-box" class="side-transition">
		<tiles:insertAttribute name="header"/>
		<!-- ---------------------------------------------------------------------------- -->
		<tiles:insertAttribute name="main" />
		<!-- ---------------------------------------------------------------------------- -->
		<tiles:insertAttribute name="sidebar"/>
		<!-- ---------------------------------------------------------------------------- -->
		<tiles:insertAttribute name="footer" />
	</div>
	
</body>
</html>