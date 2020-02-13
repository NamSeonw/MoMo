<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="/resources/css/login/selectSignUp.css" type="text/css" rel="stylesheet">
	<main id="main">
		<div id="middle-box">
			<h1 class="d-none">메인</h1>
			<section id="title-box">
				<h1 id="title">
					<span id="text-red">M</span><span>o</span><span id="text-green">M</span><span
						id="text-blue">o</span>
				</h1>
				<h2>회원가입을 환영합니다.</h2>
				<span>회원의 종류를 선택하여 가입해 주십시오.</span>
			</section>
			
            <div id="list-box">
                <ul>
                    <li>고객 회원 가입하기</li>
                    <li>사업자 회원 가입하기</li>
                </ul>
            </div>
			
			<div id="selectSignUp-form">
				<div>
					<img src="/resources/images/indivial.png">
                    <a href="/login/signup"><input class="selectButton" type="button" value="고객 회원 가입"></input></a> 
                </div>
                
                <div>
					<img src="/resources/images/company2.png">
                     <a href="/login/companySignup"><input class="selectButton" type="button" value="사업자 회원 가입"></input></a> 
                </div>
			</div>
		</div>
	</main>
