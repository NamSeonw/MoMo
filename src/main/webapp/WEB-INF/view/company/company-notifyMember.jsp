<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="/resources/css/company-notifyMember.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="./resources/js/side.js"></script>
	<main id="main">
		<h1 class="d-none">메인</h1>
		<section id="title-box">
			<h1 id="title">
				<span id="text-red">NO</span><span>T</span><span id="text-green">I</span><span>F</span><span
					id="text-blue">Y</span>
			</h1>

		</section>
        <form id="frm" action="" method="POST" enctype="multipart/form-data">
			<div id="middle-box">
				
				<input type="hidden" name="loginId" value="${session.getValue}" >
				
	            <div id="notifyForm">
					   	<div>
							<label>제목</label>
							<input type="text" name="title"/>
						</div>
						<div>
							<label>회원ID</label>
							<input type="text" name="memberId" value="${memberId}"/>
						</div>
						<div>
							<label>신고내용</label>
							<textarea id="content" name="content" style="vertical-align: top"></textarea>
						</div>
	
						<div>
							<label>첨부사진</label>
							<input type="file" name="file" value="첨부사진"/>
						</div>
						
	            </div>
			<div id="notifyMenu">
				<a id="reg">등록</a>
				<a id="cancel" href="./mypaperSuccess">취소</a>
			</div>
			<script>
			window.addEventListener("load",function(){
				var frm = document.querySelector('#frm');
				var reg = document.querySelector('#reg');
				reg.onclick = function(
						e) {
					e.preventDefault();
					e.stopPropagation();
					frm.submit();
				};

			});
			</script>
			</div>
       </form>
	</main>
