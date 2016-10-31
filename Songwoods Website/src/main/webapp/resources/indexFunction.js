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

function checkRole() {

	if (xmlHttp == null) {
		alert("Your Browser Does Not Support AJAX.");
		return;
	}
	xmlHttp.onreadystatechange = function stateChanged() {
		if (xmlHttp.readyState == 4) {

			var json = JSON.parse(xmlHttp.responseText);
			if (json.access == "true") {
				$(".modal").fadeToggle();
				$(".modal").removeClass("in");
				$("body").removeClass("modal-open")
				$("#loginInfor").text(json.userFirstName);
				$("#loginInfor").removeAttr("data-toggle");
				$("#loginInfor").removeAttr("data-target");
				if(json.role == "Agent"){
					$("#advancedMenu").show();
					$("#faveMenu").hide();
					$("#loginInfor").attr("href", "manage.htm");
					$("#logoutDIV").append("<a href='logout.htm'>Log Out</a>");
				}
				if(json.role == "Client"){
					$("#advancedMenu").show();
					$("#loginInfor").attr("href", "myAccount.htm");
					$("#logoutDIV").append("<a href='logout.htm'>Log Out</a>");
				}
				$(".modal-backdrop").fadeToggle();
			}
			
			if (json.access == "false") {
				$( "#loginNameInfor" ).text(json.error);
			}
			
		}
	};
	var email = $("input[name='userEMail']").val();
	var password = $("input[name='userPassword']").val();

	var query = "action=submit&userEMail=" + email + "&userPassword="
			+ password;
	xmlHttp.open("post", "index.htm", true);
	xmlHttp.setRequestHeader("content-type",
			"application/x-www-form-urlencoded");
	xmlHttp.send(query);
	return false;
}
