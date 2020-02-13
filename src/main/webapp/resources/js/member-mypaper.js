/**
 * 
 */

$(function(){
	if($("#m").val() == 0){
		$(".small-box").click(function(e){
			e.stopImmediatePropagation();
			e.preventDefault();
			var url = "/member/matchingpaper/" + e.currentTarget.getAttribute("id") + "?p=1&m=0";
			location.href = url;
		})
	};
	
	if($("#m").val() == 1){
		$(".small-box").click(function(e){
			e.stopImmediatePropagation();
			e.preventDefault();
			var url = "/member/matchingcomplete/" + e.currentTarget.getAttribute("id") + "?p=1&m=1";
			location.href = url;
		})
	};
});
