/**
 * 
 */

$(function() {
	var sideWidth = $("#aside").width();
	$("#side-list").click(function(e) {
		e.stopPropagation();
		e.preventDefault();
		var aside = $("#aside");
		if (!aside.hasClass("side-open")) {
			$("#bg-box").css({
				position : "relative",
				right : aside.width()
			});
			aside.addClass("side-open");
		} else {
			$("#bg-box").css({
				position : "relative",
				right : "0px"
			});
			aside.removeClass("side-open");
		}
	});

	$("#side-title").click(function() {
		location.href = "/index";
	});

	$("#goMypage").click(function() {
		location.href = "/login/login";
	});
	$("#goMypageCompany").click(function() {
		location.href = "/company/mypage";
	});
	$("#goMypageMember").click(function() {
		location.href = "/member/mypage";
	});
	
	$("#goNotify").click(function() {
		location.href = "/login/login";
	});
	$("#goNotifyCompany").click(function() {
		location.href = "/company/mypaperSuccess";
	});
	$("#goNotifyMember").click(function() {
		location.href = "/member/mypaper?m=1";
	});
	$("#goNotifyAdmin").click(function() {
		location.href = "/admin/notify/list";
	});
	$("#goReivew").click(function() {
		location.href = "/review/list";
	});

	$("#goPromotionList").click(function() {
		location.href = "/promotion/list";
	});
	$("#goPostList").click(function() {
		location.href = "/post?p=1&q=";
	});
	
	$("#goMypaperCompany").click(function() {
		location.href= "/company/mypaper";
	});
	$("#goMypaperCustomer").click(function() {
		location.href = "/member/mypaper?m=0";
	});
	$("#goReg").click(function() {
		location.href = "/member/writepaper";
	});
	$("#goMyreview").click(function() {
		location.href = "/member/review";
	});
	$("#login").click(function() {
		location.href = "/login/login";
	});
	$("#logout").click(function() {
		location.replace("/logout");
	});
	$("#signUp").click(function(){
		location.href="/login/signupAgree";
	});
});
