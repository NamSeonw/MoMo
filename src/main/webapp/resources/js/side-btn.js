/**
 * 
 */
window
		.addEventListener(
				"load",
				function() {
					var showRightPush = document.getElementById('header'),
					menuRight = document.getElementById( 'aside' ),
					body = document.body;

					showRightPush.onclick = function() {
						alert("asdf");
						classie.toggle(this, 'active');
						classie.toggle(body, 'cbp-spmenu-push-toleft');
						classie.toggle(menuRight, 'cbp-spmenu-open');
						// disableOther( 'showRightPush' );
					};
				});
