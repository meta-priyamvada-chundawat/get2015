var cities = new Array();
cities['Rajasthan'] = new Array('Jaipur','Udaipur','Bikaner','Jodhpur','Jaisalmer','Kota');
cities['Karnataka'] = new Array('Kerura','Bangalore','Udupi','Tumkur','Shimoga');
cities['Maharashtra'] = new Array('Mumbai','Pune','Nagpur','Nashik','Aurangabad');
cities['Punjab'] = new Array('Jalandhar','Amritsar','Mansa','Patiala','Moga');
cities['Haryana'] = new Array('Hisar','Amritsar','Gurgaon','Panipat','YamunaNagar');
cities['Uttar Pradesh'] = new Array('Lucknow','Kanpur','Meerut','Allahabad','Aligarh');
cities['Madhya Pradesh'] = new Array('Indore','Gwalior','Bhopal','Jabalpur','Ujjain');

function setCities() {
	stateSel = document.getElementById("states");
	cityList = cities[stateSel.value];
	changeSelect("city", cityList, cityList);
}

function changeSelect(fieldID, newOptions, newValues) {
	selectField = document.getElementById(fieldID);
	selectField.options.length = 0;
		for (i=0; i<newOptions.length; i++) {
			selectField.options[selectField.length] = new Option(newOptions[i], newValues[i]);
		}
}

function addLoadEvent(func) {
	var oldonload = window.onload;
	if (typeof window.onload != 'function') {
			window.onload = func;
	} else {
		window.onload = function() {
		if (oldonload) {
			oldonload();
		}
		func();
		}
	}
}

addLoadEvent(function() {
	setCities();
});


function validateName()
{
	var letters = /^[A-Za-z]+$/;
	var user_name=document.getElementById("first_name").value;
	var name=document.getElementById("last_name").value;
	if(user_name=="")
		alert("empty");
	if (!user_name.match(letters)) {
		alert("Enter valid First name");  
		document.myForm.first_name.focus();
		}
	if(!name.match(letters)) {
		alert("Enter valid Last name");  
		document.myForm.last_name.focus();
	}
}

/*function hidePassword (e) {
	if (e.which) {
		keynum = e.which;
	}
	keychar = String.fromCharCode(keynum);
	return (e.unicode-bidi=42); 
	var x=document.getElementById("password");
	var y=document.getElementById("re_password");
	for (var i=0; i<x.maxlength; i++) {
	x.charAt(i).innerHTML="*";
	}
	for (var i=0; i<y.maxlength; i++) {
	y.charAt(i).innerHTML="*";
	}
}*/

function validatePassword() {
var y=document.getElementById("password").value;
if(y.length!=8)
	alert("Not 8 characters");
}

function validateRePassword() {
	var x=document.getElementById("password").value;
	var y=document.getElementById("re_password").value;
	if(!x.match(y))
		alert("Password do not match");
}

function validateAddress() {
	var addr=document.getElementById("address").value;
	if (addr.length>100) {
		alert("Address exceeding character limit");  
		document.myForm.address.focus();
		}
}

function validateAge() {
	var numbers = /\d/;
	var user_age=document.getElementById("age").value;
	if(!user_age.match(numbers)) {
		alert("Enter valid age");
		document.myForm.agree.focus();
	}
}

function validateChecked() {
	document.myForm.sub.disabled=true;
	if(document.myForm.agree.checked==true) {
		document.myForm.sub.disabled=false;
	}
	if(document.myForm.agree.checked==false) {
		document.myForm.sub.enabled=false;
	}
}

function validate() {
	validateName();
	validatePassword();
	validateRePassword();
	validateAge();
	validateAddress();
}

