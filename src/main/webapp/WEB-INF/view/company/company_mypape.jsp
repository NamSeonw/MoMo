<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css"
	href="/resources/css/company_mypage.css">
<script src="/resources/js/utils.js"></script>
		<main id="main">
			<div id="middle-box">
				<h1 class="d-none">메인</h1>
				<div id="title-box">
					<h1 id="title">
						<span id="text-red">MY</span><span>P</span><span id="text-green">A</span><span>G</span><span
							id="text-blue">E</span>
					</h1>
				</div>
				<div id="content-box">
					<div id="article-box">
						<form id="frm" action="" method="post"
							enctype="multipart/form-data">
							<div id="article-inbox">
								<div id="input-box">
									<div id="company-name">
										<img id="company" src="/resources/images/company.png"
											width="20px" height="20px" /> <span>상호명</span><input
											id="company-name-input" type="text" name="name"
											value="${company.name}">
									</div>
									<div id="company-pwd">
										<span>비밀번호</span><input id="company-pwd-input" type="password"
											name="pwdInput" value=""> <input id="company-pwd-db"
											type="hidden" name="pwdDB" value="${company.pwd}">
										<c:if test="${not empty param.error}">
											<div id="comfirmCompany">비밀번호가 올바르지 않습니다.</div>
										</c:if>
									</div>
									<div id="company-menu">
										<span>주종목 <input type="text"
											id="company-category-input" name="category"
											value="${company.category}"></span>
									</div>
									<div id="company-location">
										<span>위치 <input id="company-location-textbox"
											type="text" name="address" value="${company.address}"></span>
									</div>
									<div id="company-tel">
										<span>연락처 <input id="company-tel-textbox" type="text"
											name="contact" value="${company.contact}"></span>
									</div>
									<div id="company-photo">
										<span>사진</span>
										<div id="filebox">
											<input id="fileName" type="text" class="file_input_textbox"
												name="photo" readonly="readonly" value="${company.photo}">
											<div class="file_input_div">
												<input type="button" value="사진찾기" class="file_input_button" />
												<input type="file" name="file" class="file_input_hidden"
													onchange="javascript: document.getElementById('fileName').value = this.value.replace(/c:\\fakepath\\/i,'')">
											</div>
										</div>
									</div>
								</div>
								<div id="company-img">
									<img id="company-img-input"
										src="/resources/upload/${company.photo}" width="220px"
										height="155px">
								</div>
							</div>
							<span id="company-article">홍보글 <img id="onoffBtn"
								src="/resources/images/onOffIcon.png" width="20px" height="20px"></span>
							<div id="company-article-textbox">
								<textarea id="company-article-input" name="content"
									placeholder="완전 맛있어요~!">${company.content}</textarea>
							</div>
							<div id="button-box">
								<a id="pwdEditBtn" href="/company/editpwd">비밀번호변경</a> <a
									id="editBtn" href="">수정</a> <a id="outBtn"
									href="/company/confirm">탈퇴</a>
							</div>
							<input id="isChk" type="hidden" name="isChk" value="${isChk}">
							<input id="state" type="hidden" name="state" value="${state}">
							<script>
								window
										.addEventListener(
												"load",
												function() {
													var form = document
															.querySelector('#frm');
													var pwdInput = document
															.querySelector('#company-pwd-input');
													var pwdDB = document
															.querySelector('#company-pwd-db');
													var editBtn = document
															.querySelector('#editBtn');
													var isChk = document
															.querySelector('#isChk');
													var state = document
													.querySelector('#state');
													
													//moder
													if(state.value=="1"){
														var screen=document.createElement("div");

												        CSS.set(screen,{
												            width:"100%",
												            height:"100%",
												            background:"#000",
												            opacity:"0.5",
												            position:"fixed",
												            top:"0px",
												            left:"0px"
												        });

												        document.body.append(screen);
												        
												        //alert, confirm,prompt
												        //뜨는 상자
												        var dlg=document.createElement("div");
												        var width=260;
												        var height=100;

												        //width값을 갖기위함
												        var screenStyle = window.getComputedStyle(screen);

												        var x=(parseInt(screenStyle.width)/2-width/2) +"px";
												        var y=(parseInt(screenStyle.height)/4-height/3) +"px";
												  
												        CSS.set(dlg,{
												            width:width+"px",
												            height:height+"px",
												            background:"#fff",
												            position:"fixed",
												            left:x,
												            top:y,
												            borderRadius: "10px",
												            paddingLeft:"60px",
												            paddingRight:"40px",
												            paddingTop:"60px",
												            paddingBottom:"30px",
												            boxShadow : "2px 2px 2px #5b9bd5",
												            display:"flex",
												            "flex-direction":"column"
												        });
/* 												      
												        var request = new XMLHttpRequest();
												        
												        request.open("POST", "../mypage");
												      
												        request.onload = function(){
												        	
												        	dlg.innerText=request.responseText;
												        	
												        };
												        
												        request.send(); */
												        
												        
												        var buttonDiv=document.createElement("div");
												        var okButton=document.createElement("input");
												        okButton.type="button";
												        okButton.value="확인";
												        CSS.set(buttonDiv, {
												        	height:"30px",
												        	"text-align":"center"
												        });
												        
												        dlg.append(buttonDiv);
												        
												        buttonDiv.append(okButton);
												        CSS.set(okButton,{
												        	padding:"5px 15px"
												        });
												        
												        okButton.onclick=function(){
												        	screen.remove();
												        	dlg.remove();
												        	location.href="../company/mypage";
												        };
												        
												        document.body.append(dlg);
													}
													

													//수정클릭
													editBtn.onclick = function(
															e) {
														e.preventDefault();
														e.stopPropagation();
														if (pwdInput.value == "") {
															alert("비밀번호를 입력하세요.");
														}
														else{
															form.submit();
														}
													};

												});
							</script>
						</form>
					</div>
				</div>
			</div>
		</main>
