$(function() {
	$(".search-mark").click(function(e) {
		e.stopPropagation();
		e.preventDefault();
		$("#index-form").submit();
	});

});
