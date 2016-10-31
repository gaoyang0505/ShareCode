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


function sendMessage() {

	if (xmlHttp == null) {
		alert("Your Browser Does Not Support AJAX.");
		return;
	}
	xmlHttp.onreadystatechange = function stateChanged() {
		if (xmlHttp.readyState == 4) {

			$("input[name='messageCon']").val("");
			$("input[name='mesTitle']").val("");
			alert("Message sends successfully");
			
		}
	};


	var mesCon=$("input[name='messageCon']").val();
	var mesTit=$("input[name='mesTitle']").val();

	var mesTyp=$(".selectVal").val();

	var senderID =$("input[name='sender']").val(); 
	var receiverID = $("input[name='receiver']").val();

	var query = "messageCon="+mesCon+"&mesTitle="+mesTit+"&mesType="+mesTyp+"&sender="+senderID+"&receiver="+receiverID;
	xmlHttp.open("post", "sendmessage.htm", true);
	xmlHttp.setRequestHeader("content-type", "application/x-www-form-urlencoded");
	xmlHttp.send(query);
	return false;
}


function favoriteHo(obj) {

	if (xmlHttp == null) {
		alert("Your Browser Does Not Support AJAX.");
		return;
	}
	xmlHttp.onreadystatechange = function stateChanged() {
		if (xmlHttp.readyState == 4) {
			$(obj).children("i").removeClass("fa-heart").addClass("fa-check-square-o");
		}
	};
	
	var houseID=$("input[name='houseID']").val();
	var userEMail = $("input[name='sender']").val();

	var query = "houseID="+houseID+"&userEMail="+userEMail;
	xmlHttp.open("get", "addFav.htm?"+query+"&t="+Math.random(), true);
	xmlHttp.send();
	return false;
}

