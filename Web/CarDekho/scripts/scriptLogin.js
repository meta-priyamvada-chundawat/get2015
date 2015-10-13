function loginFunction() {
	var username = document.getElementById("username").value;
	var userPassword = document.getElementById("passwrd").value;
	if (username != "arushi" || userPassword != "arushi") {
		alert("Either username or password not correct.");
		return false;
	}

}
