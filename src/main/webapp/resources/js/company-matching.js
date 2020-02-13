/**
 * 
 */

window.addEventListener("load", function() {
	var matchingIng = document.getElementById("matching-ing");
	matchingIng.onclick = function() {
		location.href = "./mypaper";
	};

	var matchingCom = document.getElementById("matching-complete");
	matchingCom.onclick = function() {
		location.href = "./mypaperSuccess";
	};
});