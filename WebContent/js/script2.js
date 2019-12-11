function validate()
{
	var Title = document.forms["Form"]["txtname"].value;
	if (Title == "") {
		alert("Title should not be empty")
		return false;
	}
	if (Title.length <2) {
		alert("title should have 2 to 65 characters")
		return false;
	}
	var gross = document.forms["Form"]["txtGross"].value;
	if (gross=="") {
		alert("please provide gross value")
		return false;
	}
	if(/[^0-9]/.test(gross)) {
		alert("the gross value should contain only numbers...")
		return false;
	}
	var datelaunch = document.forms["Form"]["txtLaunch"].value;
	if (datelaunch == "") {
		alert("please provide the date of launch")
		return false;
	}
	
}