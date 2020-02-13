$(function(){
	
	var submitBox=$(".submitbox");
	var submit=submitBox.find("a").eq(0);
	

	submit.click(function(e){
		
		if($('input:checkbox[id="checkbox"]').is(":checked")
			&& $('input:checkbox[id="checkbox1"]').is(":checked"))
			{

								
			}
		else
			{
				
				e.preventDefault();

			}
	});
});
