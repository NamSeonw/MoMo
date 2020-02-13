$(function() {
	$(".rest-small-box").click(function(e) {
		e.stopImmediatePropagation();
		e.preventDefault();
		var appealId=e.currentTarget.getAttribute("id");
		var postId=document.querySelector("#postId");
		
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
        
        // alert, confirm,prompt
        var dlg=document.createElement("div");
        var width=260;
        var height=100;

        // width값을 갖기위함
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
        
        var companyDiv = e.currentTarget;
        var companyName = companyDiv.querySelector(".company-name");
	    dlg.innerText= companyName.innerText +" 업체와 매칭하시겠습니까?";

        var textDiv=document.createElement("div");
        
        CSS.set(textDiv, {
        	"flex-grow": 1
        });
        
        dlg.append(textDiv);
        
        var buttonDiv=document.createElement("div");
        var okButton=document.createElement("input");
        var cancelButton=document.createElement("input");
        
        okButton.type="button";
        
        okButton.value="확인";
        CSS.set(buttonDiv, {
        	height:"30px",
        	"text-align":"center",
        	cursor: "pointer"
        });
        
        cancelButton.type="button";
        cancelButton.value="취소";
        CSS.set(buttonDiv, {
        	height:"30px",
        	"text-align":"center",
        	cursor: "pointer"
        });
        
        dlg.append(buttonDiv);
        
        buttonDiv.append(okButton);
        buttonDiv.append(cancelButton);
        
        CSS.set(okButton,{
        	padding:"5px 15px",
        	margin:"0px 10px"
        
        });
        
        CSS.set(cancelButton,{
        	padding:"5px 15px",
        	margin:"0px 10px"
        });
        
        okButton.onclick=function(){
        	var pId=postId.value;
        	location.href="../matchingSuccess/"+pId+"?appealId="+appealId;
        	screen.remove();
        	dlg.remove();
        	
        };
        
        cancelButton.onclick=function(){
        	screen.remove();
        	dlg.remove();
        };
        
        document.body.append(dlg);
		
	});
	
});
