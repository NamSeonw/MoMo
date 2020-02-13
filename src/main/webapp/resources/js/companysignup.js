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
	  
	  $("#contact").on("change keyup",function(){
		  var regPhone = /^\d{3}-\d{3,4}-\d{4}$/;
		  var phone = $("#contact").val();
		  
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
		   location.href = "/login/companySignup";
	   }
	   
	   if(url == "error=2"){
		   alert("비밀번호를 확인해주세요")
		   location.href = "/login/companySignup";
	   }
	   
	   if(url == "error=3"){
		   alert("핸드폰 번호를 확인해주세요")
		   location.href = "/login/companySignup";
	   }
	   
	   if(url == "error=4"){
		   alert("정보를 모두 입력해주세요")
		   location.href = "/login/companySignup";
	   }
   });
   
   function execDaumPostcode() {
       new daum.Postcode({
           oncomplete: function(data) {
               var addr = ''; // 주소 변수
               var extraAddr = ''; // 참고항목 변수

               if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                   addr = data.roadAddress;
               } else { 
                   addr = data.jibunAddress;
               }

               if(data.userSelectedType === 'R'){
                   if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                       extraAddr += data.bname;
                   }
                   if(data.buildingName !== '' && data.apartment === 'Y'){
                       extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                   }
                   if(extraAddr !== ''){
                       extraAddr = ' (' + extraAddr + ')';
                   }
                   document.getElementById("extraAddress").value = extraAddr;
               
               } else {
                   document.getElementById("extraAddress").value = '';
               }

               // 우편번호와 주소 정보를 해당 필드에 넣는다.
               document.getElementById('postcode').value = data.zonecode;
               document.getElementById("address").value = addr;
               // 커서를 상세주소 필드로 이동한다.
               document.getElementById("detailAddress").focus();
           }
       }).open();
   }