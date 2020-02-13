window.addEventListener("load", function() {
    var button=document.querySelector("#findId");
    var result=document.querySelector("#result");
    
    var form=document.querySelector("#find-form");
    var name=form.querySelector("#name");
    var email=form.querySelector("#email");
    
    button.onclick=function(e){
    	
    	e.preventDefault();
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
        
        var nameVal=name.value;
        var emailVal=email.value;
      
        var request = new XMLHttpRequest();
        
        request.open("POST", "../../login/findId?n="+nameVal+"&e="+emailVal,false);
      
        request.onload = function(){
        	
        	dlg.innerText=request.responseText;
        	
        };
        
        request.send();

        var textDiv=document.createElement("div");
        
        
        textDiv.innerText=result.value;
        
        
        CSS.set(textDiv, {
        	"flex-grow": 1
        });
        dlg.append(textDiv);
        
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
        	location.href= "/login/login";
        	screen.remove();
        	dlg.remove();
        };
        
        document.body.append(dlg);

    };
    
});