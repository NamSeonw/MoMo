/**
 * 
 */

$(function() {
	$(".article-bg").click(function(e) {
		e.stopImmediatePropagation();
		e.preventDefault();
		
		var postId = e.currentTarget.getAttribute("id");
		let request = new XMLHttpRequest();
		request.open("GET", "./get-principal", true);
		request.onload = function () {
			username = request.responseText;
			let requestto = new XMLHttpRequest();
			var params ="postId="+postId+"&username="+username;
			
			requestto.open("GET", "./post-json?"+params, true);
			requestto.onload = function() {
				if(requestto.responseText == ""){
					var url = "/company/write/" + postId;
					location.href = url;
				}
				else{
					let requestAppeal = new XMLHttpRequest();
					requestAppeal.open("GET", "./appeal-json?"+params, true);
					requestAppeal.onload = function() {
						let appealId = requestAppeal.responseText;
						var url = "/company/"+appealId+"/edit";
						location.href = url;
					};
					requestAppeal.send();
					alert("이미 작성하신 글입니다.");
				}
			};
			requestto.send();
		};
		request.send();
	});

	$(".search-mark").click(function(e) {
		e.stopImmediatePropagation();
		e.preventDefault();
		location.href="/post?p="+
		$('input[name="p"]').val()+"&q="+$(".search-bar").val();
	});

	$('input[name="q"]').keydown(function(e) {
		if(e.keyCode == 13){
			e.preventDefault();
			location.href="/post?p="+
			$('input[name="p"]').val()+"&q="+$(".search-bar").val();
		}
	});
});
