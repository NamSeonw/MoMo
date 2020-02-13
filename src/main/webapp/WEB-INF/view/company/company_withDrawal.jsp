<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="/resources/css/company_withDrawal.css">
<script src="/resources/js/utils.js"></script>
<script src="/resources/js/company-withDrawalModal.js"></script>
		<main id="main">
		<div id="middle-box">
			<div id="title-box">
				<h1 id="title">
					<span id="text-red">WI</span><span>TH</span><span id="text-green">DR</span><span>AW</span><span
						id="text-blue">AL</span>
				</h1>
			</div>
			<div id="content-box">
				<div id="article-box">
					<form id="find-form" action="withdrawal" method="post">
						<div id="company-id">
							<span>사업자 ID<label>${loginId }</label></span>
						</div>
						<div id="company-regdate">
							<span>탈퇴일 <label>${nowdate }</label></span>
						</div>
						<div id="reason-box">
							<span id="reason">탈퇴 사유</span>
							<textarea placeholder="탈퇴사유" id="text-box"></textarea>
						</div>
						<div id="explan">
							<span>※ 남겨 주신 정보를 바탕으로 보다 나은 서비스를 제공해 드리기 위해
								더욱 노력하겠습니다.</span>
						</div>
						 <input type="hidden" id="result" value="">
						<div id="withDrawal-btn">
							 <input id="withDrawal" type="submit" value="회원탈퇴" />
						</div>
					</form>
				</div>
			</div>
		</div>
		</main>
