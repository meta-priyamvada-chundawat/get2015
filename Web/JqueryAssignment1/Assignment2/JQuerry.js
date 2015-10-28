$(document).ready(function(){
				$("#hide").click(function(){
					$("#input").hide();
				});
			});
			
			$(document).ready(function(){
				$("#show").click(function(){
					$("#input").show();
				});
			});
			
			$(document).ready(function(){
					$("#showhide").click(function(){
						if($("#input").is(":hidden")) 
							$("#input").show(); 
						else 
							$("#input").hide(); 
				});
			});
			
			