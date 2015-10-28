function show() {
				var showValue=document.getElementById('input');
				showValue.innerHTML="My name is Anshita Arya";
			}
			function hide() {
				var showValue=document.getElementById('input');
				showValue.innerHTML="";
			}
			function showOrHide() {
				var showValue=document.getElementById('input');
				if (showValue.innerHTML.length == 0)
					showValue.innerHTML="My name is Anshita Arya";
				else
					showValue.innerHTML="";
			}