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

function checkUser(obj) {

	if ($(".fa-check").length) {
		if($("#passInup").val()!=""){
			obj.submit();
			return true;
		}
	} else {
		if (xmlHttp == null) {
			alert("Your Browser Does Not Support AJAX.");
			return;
		}
		xmlHttp.onreadystatechange = function stateChanged() {
			if (xmlHttp.readyState == 4) {
				var json = JSON.parse(xmlHttp.responseText);
				var a = $(".emailCheck");
				
				if(json.userOnly == "true"){
					$(".emailadd").append("<i class='fa fa-check'></i>");
					$("#informationMessage").text("E-Mail is wonderful.");
					$(".emailCheck").attr("readonly","readonly");
					$("#signinBtn").removeAttr("disabled");
				}
				
				if (json.userOnly == "false") {
					$("#informationMessage").text("E-Mail has been used.");
				}
			}
		};
		var email = $(".emailCheck").val();
		var query = "action=check&userEMail=" + email;
		xmlHttp.open("post", "signup.htm", true);
		xmlHttp.setRequestHeader("content-type","application/x-www-form-urlencoded");
		xmlHttp.send(query);
		return false;
	}
	return;
}
