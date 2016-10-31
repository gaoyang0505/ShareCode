<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springform"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="/project/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="/project/resources/css/font-awesome.min.css"
	rel="stylesheet">
<link href="/project/resources/css/lightbox.css" rel="stylesheet">
<link href="/project/resources/css/animate.min.css" rel="stylesheet">
<link href="/project/resources/css/main.css" rel="stylesheet">
<link href="/project/resources/css/responsive.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</head>
<body>


	<section id="portfolio-information" class="padding-top">
		<div class="container">
			<div class="row">
				<div class="col-sm-6">
					<img
						src="file:///Users/clark/Desktop/DestinationImage/${requestScope.agentDetail.agentPicturePath}"
						class="img-responsive" alt="">
				</div>


				<form action="updateAgent.htm" method="post">
					<div class="col-sm-6">
						<div class="project-name overflow">
							<h2 class="bold">
								<c:out value="${requestScope.agentDetail.userFirstName}"></c:out>
								<c:out value="${requestScope.agentDetail.userLastName}"></c:out>
							</h2>
							<ul class="nav navbar-nav navbar-default">
								<li><a href="#"><i class="fa fa-clock-o"></i>Agent</a></li>
								<li><a href="#"><i class="fa fa-tag"></i> <c:out
											value="${requestScope.agentDetail.company.companyName}"></c:out></a></li>
							</ul>
						</div>
						<div class="project-info overflow">
							<h3>Agent Description</h3>
							<p id="agentDescriptionArea"><c:out value="${requestScope.agentDetail.agentDescription}"></c:out></p>
							<ul class="elements">
								<li><i class="fa fa-angle-right"></i>Phone: <c:out
										value="${requestScope.agentDetail.agentPhoneNumber}"></c:out>
								</li>
								<li><i class="fa fa-angle-right"></i>E-Mail: <c:out
										value="${requestScope.agentDetail.userEMail}"></c:out></li>
								<li><i class="fa fa-angle-right"></i>Fax: <c:out
										value="${requestScope.agentDetail.agentFaxNumber}"></c:out></li>
							</ul>
						</div>

						<div class="client overflow">
							<h3>Agent Status:</h3>
							<ul class="nav navbar-nav navbar-default">
								<li><a href="#"><i class="fa fa-bolt"></i> ${requestScope.agentDetail.userStatus}</a></li>
							</ul>
						</div>

						<input type="hidden" name="agentItemID" value="<c:out value='${requestScope.agentDetail.userID}'></c:out>" />
						<!-- Update Agent -->
						
						<c:set var="status" scope="page" value="Active"/>
						
						<c:choose>
							<c:when
								test="${requestScope.agentDetail.userStatus == status}">
								<div class="live-preview">
									<input type="text" class="editA btn btn-common uppercase" value="Edit Agent" /> 
									<input type="text" class="disA btn btn-common uppercase" value="Disable Agent" data-toggle="modal" data-target="#loginBlock"/>
								</div>
							</c:when>
							<c:otherwise>
								<div class="live-preview">
									<input type="hidden" name="action" value="actA"/> 
									<input type="submit" class="btn btn-common uppercase" name="activeAgent" value="Active Agent">
								</div>
							</c:otherwise>

						</c:choose>
						
					</div>
					
<!--  Conform Active Modal -->
					<div class="modal fade" id="loginBlock" tabindex="-1" role="dialog"
						aria-labelledby="loginTile" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true">x</button>
									<h4 class="modal-title" id="loginTile">Important Message</h4>
								</div>

								<div class="form-horizontal">
									<div class="modal-body">
										<div class="form-group">
											<div class="col-sm-10">
												<p>You are trying to delete this agent.</p>
											</div>
										</div>
										<a href="updateAgent.htm?disAct=sure&detailID=<c:out value='${requestScope.agentDetail.userID}'></c:out>" class="btn btn-submit">Yes, I am Sure</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</section>


<script>
		$(".editA").click(function() {
			$(this).removeAttr("type");
			$(this).attr("type", "submit");
			/*$(this).removeClass("btn-common").addClass("btn-submit"); */
			$(this).attr("value", "Save Change");
			$(this).attr("name", "editA");
			$(this).attr("style","background:#fe8f80");

			var contentTxt = $("p#agentDescriptionArea").text();
			$("p#agentDescriptionArea").text("");
			$("p#agentDescriptionArea").replaceWith("<input id='agentDescriptionArea' />");
			$("input#agentDescriptionArea").attr("rows", "8");
			$("input#agentDescriptionArea").attr("name", "descArea");
			$("input#agentDescriptionArea").attr("type", "text");
			$("input#agentDescriptionArea").attr("value", contentTxt);
			$("input#agentDescriptionArea").addClass("form-control");
			$("input#agentDescriptionArea").append(contentTxt);
			$(this).removeClass("editA");
		});
	</script>
	


	<script type="text/javascript" src="/project/resources/js/jquery.js"></script>
	<script type="text/javascript"
		src="/project/resources/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="/project/resources/js/jquery.isotope.min.js"></script>
	<script type="text/javascript"
		src="/project/resources/js/lightbox.min.js"></script>
	<script type="text/javascript" src="/project/resources/js/wow.min.js"></script>
	<script type="text/javascript" src="/project/resources/js/main.js"></script>
</body>
</html>