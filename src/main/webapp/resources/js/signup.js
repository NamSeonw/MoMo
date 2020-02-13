 $(document).ready(function(){
	  $("#loginId").on("change keyup",function(){
		  $.ajax({
			url:'idConfirm',
           	dataType:'json',
            success:function(data){
				for(let i=0 ; i<data.length;i++)
					if($("#loginId").val() == data[i].loginId){
						$("#idConfirm").text("아이디가 중복되었습니다.");
							return;
					}
					else 
						$("#idConfirm").text("");
            }
		  })
	  })
	  
	  $("#loginId").on("change keyup",function(){
		  var regLoginId = /^[a-z]+[a-z0-9]{5,19}$/;
		  var id = $("#loginId").val();
		  
		  if(!regLoginId.test(id)){
			  $("#idchk").text("아이디는 영문자로 시작하는 6~20자 영문자 또는 숫자이어야 합니다.");
		  }
		  else
			  $("#idchk").text("");
	  })
	  
	  $("#pwd").on("change keyup",function(){
		  var regPwd = /^(?=.*\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-z]).{9,15}$/;
		  var pwd = $("#pwd").val();
		  
		  if(!regPwd.test(pwd)){
			  $("#pwdConfirm").text("비밀번호는 소문자,특수문자,숫자를 포함해야 합니다.");
		  }
		  else
			  $("#pwdConfirm").text("");
	  })
	  
	  $("#checkPwd").on("change keyup",function(){
		if($("#pwd").val() != $("#checkPwd").val()){
			$("#pwdchk").text("비밀번호가 다릅니다.");
		}
		else{
			$("#pwdchk").text("");
		}
	  })
	  
	  $("#phone").on("change keyup",function(){
		  var regPhone = /^\d{3}-\d{3,4}-\d{4}$/;
		  var phone = $("#phone").val();
		  
		  if(!regPhone.test(phone)){
			  $("#phone-confirm").text("연결자(-)를 사용하여 입력하세요");
		  }
		  else
			  $("#phone-confirm").text("");
	  })
   });
   
   $(window).ready(function(){
	   var url = location.search.substring(1,8);
	   
	   if(url == "error=1"){
		   alert("아이디를 확인해주세요")
		   location.href = "/login/signup";
	   }
	   
	   if(url == "error=2"){
		   alert("비밀번호를 확인해주세요")
		   location.href = "/login/signup";
	   }
	   
	   if(url == "error=3"){
		   alert("핸드폰 번호를 확인해주세요")
		   location.href = "/login/signup";
	   }
	   
	   if(url == "error=4"){
		   alert("정보를 모두 입력해주세요")
		   location.href = "/login/signup";
	   }
   });
   