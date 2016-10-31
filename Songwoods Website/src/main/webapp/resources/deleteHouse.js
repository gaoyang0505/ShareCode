var xmlHttp;
xmlHttp = GetXmlHttpObject();

function GetXmlHttpObject() {
	var xmlHttp = null;
	try {
		// Firefox, Opera 8.0+, Safari
		xmlHttp = new XMLHttpRequest();
	} catch (e) {
		// Internet Explorer
		try {
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
	}
	return xmlHttp;
}


function deleteHo(obj) {

	if (xmlHttp == null) {
		alert("Your Browser Does Not Support AJAX.");
		return;
	}
	xmlHttp.onreadystatechange = function stateChanged() {
		if (xmlHttp.readyState == 4) {
			$(obj).closet(".firstParent").remove();
		}
	};
	
	var houseID=$("input[name='houseID']").val();
	var query = "houseID="+houseID;
	xmlHttp.open("get", "houseDelete.htm?"+query+"&t="+Math.random(), true);
	xmlHttp.send();
	return false;
}

