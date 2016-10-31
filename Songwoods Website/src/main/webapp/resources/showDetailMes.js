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

function getMessageDetai() {

	if (xmlHttp == null) {
		alert("Your Browser Does Not Support AJAX.");
		return;
	}
	xmlHttp.onreadystatechange = function stateChanged() {
		if (xmlHttp.readyState == 4) {
			var json = JSON.parse(xmlHttp.responseText);
			var owner = $("input[name='owner']")
			
			$("#detailMessage").css("opacity",'1');
			$("#mesTit").text(json.messageTitle);

			$("#messCon").text(json.messageCon);
			$("#mesTime").text("Post on " + json.messageDate);
			$("#mesType").append(json.messageType);
			$("#sender").text(json.messageSendName);
			$("#receive").text(json.messageReceiName);
			$("input[name='rec']").val(json.messageSenderEMail);
			
			alert(owner);
			alert(json.messageSendID);
			if (owner == json.messageSendID) {
				$("#judgeDiv").append("<li><a href='#' id='mesStatu'><i class='fa fa-weixin' aria-hidden='true'></i>" + json.messageStatus + "</a></li>");
			} else {
				$("#judgeDiv").append("<li><a href='#' data-toggle='modal' data-target='#loginBlock' id='loginInfor'><i class='fa fa-reply' aria-hidden='true'></i>Reply</a></li><li id='sender'><i class='fa fa-weixin' aria-hidden='true'></i>" + json.messageSendName + "</li>")
			}

		}
	};

	var messID = $("input[name='ajaxMes']").val();

	var query = "messageID=" + messID;
	xmlHttp.open("get", "messageDte.htm?" + query + "&t=" + Math.random(),true);
	xmlHttp.send();
	return false;
}


function sendMessageInMailBox() {

	if (xmlHttp == null) {
		alert("Your Browser Does Not Support AJAX.");
		return;
	}
	xmlHttp.onreadystatechange = function stateChanged() {
		if (xmlHttp.readyState == 4) {

			$("input[name='messageCon']").val("");
			$("input[name='mesTitle']").val("");
		}
	};


	var mesCon=$("input[name='messageCon']").val();
	var mesTit=$("input[name='mesTitle']").val();

	var mesTyp=$(".selectVal").val();

	var senderID = $("input[name='sender']").val(); 
	var receiverID = $("input[name='rec']").val();

	
	var query = "messageCon="+mesCon+"&mesTitle="+mesTit+"&mesType="+mesTyp+"&sender="+senderID+"&receiver="+receiverID;
	xmlHttp.open("post", "sendmessage.htm", true);
	xmlHttp.setRequestHeader("content-type", "application/x-www-form-urlencoded");
	xmlHttp.send(query);
	return false;
}
