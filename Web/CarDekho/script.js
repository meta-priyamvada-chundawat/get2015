		function nameValidate(e) {
	if (e.which) {
		keynum = e.which;
	}
	keychar = String.fromCharCode(keynum);
	numcheck = /\d/;
	return !numcheck.test(keychar);
}
function rowValidate(e) {
	if (e.which) {
		keynum = e.which;
	}
	keychar = String.fromCharCode(keynum);
	numcheck = /\d/;
	return numcheck.test(keychar);
}
function makeTable()  
		{  
		var rows=document.getElementById("rows").value;
			if ( rows == "") {
				alert("Please Enter row");
				document.getElementById("rows").focus();
				return false;
			}
			else {
				var str= "<div class='lineSpace'><form>";
				for (i=0; i<rows; i++)
				{	
					str += "<div><input type='text' class='name' placeholder='Name' onkeypress='return nameValidate(event);' /><input type='text' class='min' placeholder='Minimum value' onkeypress='return rowValidate(event);'/><input type='text' class='max' placeholder='Maximum value' onkeypress='return rowValidate(event);'/></div>";
				}
				str += "<div><input id='ok' type='button' value='OK' onclick='rangeRepresentation();'/></div></form></div><div id='represent'></div>";
				document.getElementById("input").innerHTML=str;
				return true;
			}
		}
		
		function validate(rows,min,max)
		{
			for ( i = 0; i < rows; i++ ) 
			{
				if(max[i].value < min[i].value)
				{
					return false;
				}
				else if((max[i].value ==""||max[i].value <0||max[i].value >10 )&&(min[i].value ==""||min[i].value <0||min[i].value >10))
				{
					return false;
				}else {
					continue;
				}
			}
			return true;
		}
		
		function rangeRepresentation()
		{
			var rows = document.getElementById("rows").value;
			var name = document.getElementsByClassName("name");
			var min = document.getElementsByClassName("min");
			var max = document.getElementsByClassName("max");
			if ( validate(rows,min,max)) {
				document.getElementById("represent").innerHTML = createRepresentation(rows,name,min,max);
			}else {
				alert("Enter correct values of min and max between 0-10 and maximum value should be greater than minimum value");
			}
		}
		
		
		function createRepresentation(rows,name,min,max)
		{
			var str = "<table class='rangeTable' cellspacing='0' cellpadding='10'>";
			for ( i=0; i<rows; i++ )
			{	
				str += "<tr><td id='nameColor'>"+name[i].value+"</td>";
				for ( j=1; j<=11; j++ )
				{
					if( j>=min[i].value && j<=max[i].value ) {
						str += "<td id='cell'></td>";	
					}
					else {
						str += "<td></td>";
					}
				}
				str += "</tr>";
			}
			str += "</table>";
			return str;
		}