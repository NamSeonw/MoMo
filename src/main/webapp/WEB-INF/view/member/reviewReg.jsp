<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="/resources/css/member/reviewReg.css" type="text/css" rel="stylesheet">
	<main id="main">
		<h1 class="d-none">메인</h1>
		<section id="title-box">
			<h1 id="title">
				<span id="text-red">W</span><span>R</span><span id="text-green">I</span><span>T</span><span
					id="text-blue">E</span>
			</h1>

		</section>
		<div id="middle-box">
			   
            <form action="reg" method="POST">

				<div>
					<label>식당명</label>
					<input type="text" name="companyName" value=""/>
				</div>
				<div>
					<label>위치</label>
					<input type="text" name="address" value=""/>
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

            </form>	
		</div>
		<div id="reviewMenu">
			<span>등록</span>
			<span>취소</span>
		</div>
	</main>
