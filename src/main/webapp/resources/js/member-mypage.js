/**
 * 
 */
window.addEventListener("load",function(){
		
 		var pwdText = document.querySelector("#pwd");
 		var pwdChecked = false;
 		var confirm = document.querySelector("#pwdconfirm");
 		var edit = document.querySelector("#edit");
 		
 		pwd.oninput = function(e){
			var request = new XMLHttpRequest();
 			var pwd = pwdText.value;
			request.open("GET", "checkpwd?pwd="+pwd);
			request.onload = function(){
				console.log(request.responseText);
				if(request.responseText == "false"){
					pwdChecked = false;
					confirm.innerText = "사용 불가능한 비밀번호입니다.";
				}
				else{
					pwdChecked = true;
					confirm.innerText = "사용가능한 비밀번호입니다.";
				}
			};
			
			tid = setTimeout(function() {							
    			request.send();
    			tid = null;
			}, 500);
 		};
 		
 		edit.onclick = function(e){
 			if(pwdChecked == true){
 				document.querySelector("#form").submit();
 			}
 		}
 	});