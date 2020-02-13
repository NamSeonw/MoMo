/**
 * 
 */
$(function() {
	$(".article-bg").click(function(e) {
		e.stopPropagation();
		e.preventDefault();
		console.log(e.currentTarget.getAttribute("id"));
		var url = "/promotion/" + e.currentTarget.getAttribute("id");
		location.href = url;
	});
	
	$(".search-mark").click(function(e) {
		e.stopPropagation();
		e.preventDefault();
		location.href="/promotion/list?p="+
		$('input[name="p"]').val()+"&q="+$(".search-bar").val();
	});
	
	$('input[name="q"]').keydown(function(e) {
		if(e.keyCode == 13){
			e.preventDefault();
			location.href="/promotion/list?p="+
			$('input[name="p"]').val()+"&q="+$(".search-bar").val();
		}
	});
});
