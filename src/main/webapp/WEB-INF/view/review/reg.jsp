<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="/resources/css/review/reg.css" type="text/css"
	rel="stylesheet">
		<main id="main">
			<h1 class="d-none">메인</h1>
			<section id="title-box">
				<h1 id="title">
					<span id="text-red">W</span><span>R</span><span id="text-green">I</span><span>T</span><span
						id="text-blue">E</span>
				</h1>

			</section>
			
			
			<form id="regForm"  method="post" enctype="multipart/form-data">
				<div id="middle-box">


					<div>
						<label>제목</label> <input type="text" name="title" value="" />
					</div>
					<div>
						<label>가게명</label> <input type="text" name="address"
							readonly="readonly" value="${company.name }" />
					</div>
					<div id="contentInput">
						<label>내용</label>
						<textarea name="content" style="vertical-align: top"></textarea>
					</div>
					<div>
						<label>사진</label>
						<input type="button" value="사진찾기" id="file_input_button" />
						<input type="file" name="file" class="file_input_hidden"
							onchange="javascript: document.getElementById('fileName').value = this.value.replace(/c:\\fakepath\\/i,'')">
						<input id="fileName" type="text" class="file_input_textbox"
								name="photo" readonly="readonly">
					</div>
				</div>
				<div id="reviewMenu">
					<span><input type="submit" value="등록"></span> 
					<span><a href="/review/list">취소</a></span>
				</div>

			</form>

		</main>
