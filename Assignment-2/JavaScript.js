function byId(e) {
	return document.getElementById(e);
	}
 
function stateComboChange()
    {
        var combo1 = byId('stateCombo');
        var combo2 = byId('cityCombo');
        emptyCombo(combo2);
        switch(combo1.value)
        {
            case '-1':  addOption(combo2, -1, '-select state first-');
                        break;
            case '0':   addOption(combo2, 0, 'Jaipur');
                        addOption(combo2, 1, 'Ajmer');
						addOption(combo2, 2, 'Kota');
						addOption(combo2, 3, 'Jodhpur');
                        break;
            case '1':   addOption(combo2, 4, 'Bhopal');
                        addOption(combo2, 5, 'Indore');
						addOption(combo2, 6, 'Mandsor');
						addOption(combo2, 7, 'Gwalior');
                        break;
            case '2':   addOption(combo2, 8, 'Kanpur');
                        addOption(combo2, 9, 'Lucknow');
						addOption(combo2, 10, 'Noida');
						addOption(combo2, 11, 'Merut');
                        break;
			case '3': addOption(combo2, 9, 'Nasik');
					  addOption(combo2, 9, 'Mumbai');
					  addOption(combo2, 9, 'Pune');
					  addOption(combo2, 9, 'Nagpur');
					  break;
        }
        cityComboChange();
    }
function cityComboChange()
    {
        var combo2;
        combo2 = byId('cityCombo');

 
      
    }
 
function emptyCombo(e)
    {
        e.innerHTML = '';
    }
 
function addOption(combo, val, txt)
    {
        var option = document.createElement('option');
        option.value = val;
        option.title = txt;
        option.appendChild(document.createTextNode(txt));
        combo.appendChild(option);
    }


