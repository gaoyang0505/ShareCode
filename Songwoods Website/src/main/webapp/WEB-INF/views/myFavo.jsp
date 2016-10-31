<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>My Favorite | Songwoods</title>
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/font-awesome.min.css" rel="stylesheet">
    <link href="resources/css/lightbox.css" rel="stylesheet"> 
    <link href="resources/css/animate.min.css" rel="stylesheet"> 
	<link href="resources/css/main.css" rel="stylesheet">
	<link href="resources/css/responsive.css" rel="stylesheet">
</head><!--/head-->

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
							
							<li class="dropdown" id="advancedMenu" style="display:none">
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
									<li class="dropdown"><a href="#">Advanced<i class="fa fa-angle-down"></i></a>
										<ul role="menu" class="sub-menu">
											<li><a href="mailBox.htm">Mail Box</a></li>
											<li><a href="favoHose.htm">My Favorite</a></li>
										</ul>
									</li>
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

    <section id="page-breadcrumb">
        <div class="vertical-center sun">
             <div class="container">
                <div class="row">
                    <div class="action">
                        <div class="col-sm-12">
                            <h1 class="title">My Favorite</h1>
                        </div>
                    </div>
                </div>
            </div>
        </div>
   </section>
    <!--/#action-->

    <section id="portfolio">
        <div class="container">
            <div class="row">
               
                <c:forEach var="house" items="${requestScope.houseList}">
                <div class="portfolio-items firstParent">
                    <div class="col-sm-6 portfolio-item">
                        <div class="portfolio-wrapper">
                            <div class="portfolio-single">
                                <div class="portfolio-thumb">
                                     <img src="${house.houseID}" class="img-responsive" alt="house pic"> 
                                </div>
                                <div class="portfolio-view">
                                    <ul class="nav nav-pills">
                                        <li><a href="houseDetail.htm?houseInfor=${house.houseID}"><i class="fa fa-link"></i></a></li>
                                        <li><a href="#" onclick="return deleteHo(this)"><i class="fa fa-times-circle-o"></i></a></li>
                                    </ul>
                                </div>
                            </div>
                             <input type="hidden" name="houseID" value="${house.houseID}"> 
                            <div class="portfolio-info">
                                 <h2><c:out value="${house.houseName}"></c:out></h2> 
                            </div>
                        </div>
                    </div>
                </div>
                </c:forEach>
                
            </div>
        </div>
    </section>
    <!--/#portfolio-->

    <script type="text/javascript" src="resources/js/jquery.js"></script>
    <script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="resources/js/jquery.isotope.min.js"></script>
    <script type="text/javascript" src="resources/js/lightbox.min.js"></script>
    <script type="text/javascript" src="resources/js/wow.min.js"></script>
    <script type="text/javascript" src="resources/js/main.js"></script>  
    <script type="text/javascript" src="resources/deleteHouse.js"></script>
</body>
</html>
