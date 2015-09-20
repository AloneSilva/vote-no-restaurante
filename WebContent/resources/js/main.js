$("document").ready(function(){
	
	$("input[type=radio]").click(function(){
		$(".id").val($(this).val());
	});
	
});