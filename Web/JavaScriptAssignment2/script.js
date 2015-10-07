		function makeTable()  
		{  
		var rows=document.getElementById("rows").value;
			if ( rows == "") {
				alert("Please Enter row");	
			}
			else {
				var str= "<div class='lineSpace'><form>";
				for (i=0; i<rows; i++)
				{	
					str += "<div><input type='text' class='name' placeholder='Name' pattern='/^[A-Za-z]+$/'/><input type='text' class='min' min=0 max=10 placeholder='Minimum value' pattern='^(0|[1-9][0-9]*)$/'/><input type='text' class='max' min=0 max=10 placeholder='Maximum value' pattern='^(0|[1-9][0-9]*)$'/></div>";
				}
				str += "<div><input id='ok' type='button' value='OK' onclick='rangeRepresentation();'/></div></form></div><div id='represent'></div>";
				document.getElementById("input").innerHTML=str;
			}
		}
		
		function validate(min,max)
		{
			var rows = document.getElementById("rows").value;
			var name = document.getElementsByClassName("name");
			var min = document.getElementsByClassName("min");
			var max = document.getElementsByClassName("max");
			for ( i = 0; i < rows; i++ ) 
			{
				if(max[i].value < min[i].value)
				{
					return false;
				}
				else {
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
			if ( validate(min,max)) {
				document.getElementById("represent").innerHTML = makeRepresentation(rows,name,min,max);
			}else {
				alert("Enter correct values of min and max");
			}
		}
		
		
		function makeRepresentation(rows,name,min,max)
		{
			var str = "<table class='rangeTable'>";
			for ( i=0; i<rows; i++ )
			{	
				str += "<tr><td>"+name[i].value+"</td>";
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