<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springform"%>
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
</head>
<body>

	<header id="header">
		<div class="navbar navbar-inverse" role="banner">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>

					<a class="navbar-brand" href="index.html">
						<h1>
							<img src="resources/images/logo.png" alt="logo">
						</h1>
					</a>

				</div>
				<div class="collapse navbar-collapse">
					<ul class="nav navbar-nav navbar-right">
						<li class="active"><a href="index.htm">Home</a></li>
						<li class="active"><a href="browserAgent.htm">Agent</a></li>

						<li class="dropdown" id="advancedMenu" style="display: none">
							<a href="#">Advanced<i class="fa fa-angle-down"></i></a>
							<ul role="menu" class="sub-menu">
								<li><a href="mailBox.htm">Mail Box</a></li>
								<li><a href="favoHose.htm" id="faveMenu">My Favorite</a></li>
							</ul>
						</li>
						<c:choose>
							<c:when test="${empty sessionScope.user}">
								<li><a href="" data-toggle="modal"
									data-target="#loginBlock" id="loginInfor">Log In</a></li>
								<li id="logoutDIV"></li>
							</c:when>
							<c:otherwise>
								<li class="dropdown"><a href="#">Advanced<i
										class="fa fa-angle-down"></i></a>
									<ul role="menu" class="sub-menu">
										<li><a href="mailBox.htm">Mail Box</a></li>
										<li><a href="favoHose.htm">My Favorite</a></li>
									</ul></li>
								<c:choose>
									<c:when test="${sessionScope.userRole == 'Client'}">
										<li><a href="myAccount.htm" id="loginInfor">${sessionScope.userFirst}</a></li>
										<li><a href="logout.htm">Log Out</a></li>
									</c:when>

									<c:when test="${sessionScope.userRole == 'Agent'}">
										<li><a href="manage.htm" id="loginInfor">${sessionScope.userFirst}</a></li>
										<li><a href="logout.htm">Log Out</a></li>
									</c:when>
								</c:choose>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
			</div>
		</div>
	</header>
	<section id="projects">
		<div class="container">
			<div class="row">
				<div class="col-md-9 col-sm-8">
					<div class="row">
						<ul class="portfolio-filter text-center">
							<li><a class="btn btn-default active" href="#"
								data-filter="*">All</a></li>

							<c:forEach var="companyItem" items="${requestScope.companyList}">
								<li><a class="btn btn-default" href="#"
									data-filter=".<c:out value="${companyItem.companyName}"/>"><c:out
											value="${companyItem.companyName}" /></a></li>
							</c:forEach>
						</ul>


						<div class="portfolio-items">

							<c:forEach var="agentItem" items="${requestScope.agentList}">
								<div
									class="col-xs-6 col-sm-6 col-md-4 portfolio-item <c:out value='${agentItem.company.companyName}'></c:out>">
									<div class="portfolio-wrapper">
										<div class="portfolio-single">
											<div class="portfolio-thumb">
												<img
													src="file:///Users/clark/Desktop/DestinationImage/<c:out value='${agentItem.agentPicturePath}'></c:out>"
													class="img-responsive" alt="">
											</div>
											<div class="portfolio-view">
												<ul class="nav nav-pills">
													<li><a
														href="updateAgent.htm?detailID=<c:out value='${agentItem.userID}'></c:out>"><i
															class="fa fa-link"></i></a></li>
												</ul>
											</div>
										</div>
										<div class="portfolio-info ">
											<h2>
												<c:out value="${agentItem.userFirstName}"></c:out>
												<c:out value="${agentItem.userLastName}"></c:out>
											</h2>
										</div>
									</div>
								</div>
							</c:forEach>

						</div>
					</div>
				</div>
			</div>
		</div>
	</section>



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