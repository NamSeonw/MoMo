<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="/resources/css/member/reviewReg1.css" type="text/css" rel="stylesheet">
	<main id="main">
		<h1 class="d-none">메인</h1>
		<section id="title-box">
			<h1 id="title">
				<span id="text-red">ED</span><span>IT</span><span id="text-green">RE</span><span>VI</span><span
					id="text-blue">EW</span>
			</h1>

		</section>
		<div id="middle-box">
            <form id="form" action="edit" method="POST" enctype="multipart/form-data">
            <input type="hidden" value="${detail.id }" name="id" />
				<div>
					<label>식당명</label>
					<input type="text" name="title" value="${detail.companyName }"/>
				</div>
				<div>
					<label>위치</label>
					<input type="text" name="address" value="${detail.companyAddress }"/>
				</div>
				<div id="contentInput">
					<label>내용</label>
					<textarea name="content" style="vertical-align: top">${detail.content }</textarea>
				</div>
				<div>
					<label>사진</label>
					<input type="button" value="사진찾기" id="file_input_button" />
					<input type="file" name="file" class="file_input_hidden"
						onchange="javascript: document.getElementById('fileName').value = this.value.replace(/c:\\fakepath\\/i,'')">
					<input id="fileName" type="text" class="file_input_textbox"
							name="photo" readonly="readonly" value="${detail.photo }">
				</div>
				
            </form>	
		</div>
		<div id="reviewMenu">
			<a onclick="document.querySelector('#form').submit();">수정</a>
		</div>
	</main>
