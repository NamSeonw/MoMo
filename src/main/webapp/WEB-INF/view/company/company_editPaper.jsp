<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="/resources/css/company_editPaper.css" type="text/css" rel="stylesheet">
		<main id="main">
			<div id="middle-box">
				<div id="title-box">
					<h1 id="title">
						<span id="text-red">ED</span><span>IT</span><span id="text-green">PA</span><span>P</span><span
							id="text-blue">ER</span>
					</h1>
				</div>
				<div id="content-box">
					<div id="post-info">
						<div>
							<div class="blank"></div>
							<div id="memberId"><span>고객ID</span><span>${member.loginId }</span></div>
							<div id="blank"><span id="span-blank"></span><span id="blank-span"></span></div>
							<div class="blank"></div>
						</div>
						<div>
							<div class="blank"></div>
							<div id="peopleCount"><span>인원수</span><span>${post.peopleCount }</span></div>
							<div id="reservationDate"><span>예약일시</span><span>${post.reservationDate }</span></div>
							<div class="blank"></div>
						</div>
						<div>
							<div class="blank"></div>
							<div id="category"><span>목적</span><span>${post.category }</span></div>
							<div id="location" ><span>위치</span><span>${post.location }</span></div>
							<div class="blank"></div>
						</div>
						<div>
							<div class="blank"></div>
							<div id="cus-content"><span>내용</span><span id="content-span">${post.content }</span></div>
							<div class="blank"></div>
						</div>
					</div>
					<div id="write-box">
						<form action="edit" id="frm" method="post">
							<input type="hidden" name="postId" value="${post.id }">
							<div id="input-content">
								<span id="content-text">글쓰기</span> 
								<textarea id="content-textarea" name="content">${appeal.content }</textarea>
							</div>
							<div id="write-div"><a id="write" href="">수정</a></div>
							<script>
								window.addEventListener("load", function() {
									var okBtn = document.querySelector('#write');
									var form = document.querySelector('#frm');

									okBtn.onclick = function(e) {
										e.stopPropagation();
										e.preventDefault();
										form.submit();
									};
								});
							</script>
						</form>
					</div>
				</div>
			</div>
		</main>
