<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="/resources/css/member/notifyCompany.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="./resources/js/side.js"></script>
	<main id="main">
		<h1 class="d-none">메인</h1>
		<section id="title-box">
			<h1 id="title">
				<span id="text-red">NO</span><span>T</span><span id="text-green">I</span><span>F</span><span
					id="text-blue">Y</span>
			</h1>

		</section>
        <form action="${company.id }" method="POST">
			<div id="middle-box">
				
				<input type="hidden" name="appealId" value="${company.id }" >
				
				
	            <div id="notifyForm">
					   	<div>
							<label>제목</label>
							<input type="text" name="title"/>
						</div>
						<div>
							<label>업체명</label>
							<input type="text" value="${company.name}"/>
						</div>
						<div>
							<label>신고내용</label>
							<textarea name="content" style="vertical-align: top    padding-left: 10px;
   padding-right: 10px"></textarea>
						</div>
	
						<div>
							<label>첨부사진</label>
							<input type="file" name="photo" value="첨부사진"/>
						</div>
						
	            </div>
			</div>
			<div id="notifyMenu">
				<input type="submit" id="reg" value="등록"/>
				<input type="button" id="cancel" value="취소">
			</div>
       </form>
	</main>
