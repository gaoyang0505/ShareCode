<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page | TVXQ</title>


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>


<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script>

<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/font-awesome.min.css" rel="stylesheet">
<link href="resources/css/animate.min.css" rel="stylesheet">
<link href="resources/css/lightbox.css" rel="stylesheet">
<link href="resources/css/main.css" rel="stylesheet">
<link href="resources/css/responsive.css" rel="stylesheet">
</head>

<body>
	<div class="container-fluid">
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
		<!--/#header-->

		<section id="home-slider">
			<div class="container">
				<div class="row">
					<div class="main-slider">
						<div class="slide-text">
							<h1>Search Ideal House In City</h1>
							<form action="search_index.htm" method="post" class="form-inline">
								<div class="form-group">
									<input type="text" class="form-control" name="citySearch"
										style="width: 300px; height: 45px" placeholder="Enter City" />
									&nbsp&nbsp&nbsp<input type="submit" class="btn btn-submit"
										style="width: 100px" value="Search">
								</div>
							</form>
							
						</div>
						<img src="resources/images/home/slider/hill.png"
							class="slider-hill" alt="slider image"> <img
							src="resources/images/home/slider/house.png" class="slider-house"
							alt="slider image"> <img
							src="resources/images/home/slider/sun.png" class="slider-sun"
							alt="slider image"> <img
							src="resources/images/home/slider/birds1.png"
							class="slider-birds1" alt="slider image"> <img
							src="resources/images/home/slider/birds2.png"
							class="slider-birds2" alt="slider image">
					</div>
				</div>
			</div>
			<div class="preloader">
				<i class="fa fa-sun-o fa-spin"></i>
			</div>
		</section>
		<!--/#home-slider-->



		<!--/#Modal-->
		<div class="modal fade" id="loginBlock" tabindex="-1" role="dialog"
			aria-labelledby="loginTile" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">x</button>
						<h4 class="modal-title" id="loginTile">Log In</h4>
					</div>

					<form class="form-horizontal" onsubmit="return checkRole();">
						<div class="modal-body">

							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">E-Mail</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputEmail3"
										placeholder="Email" name="userEMail" />
									<!-- type=email -->
									<p id="loginNameInfor">E-Mail would be your log in
										username.</p>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
								<div class="col-sm-10">
									<input type="password" class="form-control" id="inputPassword3"
										placeholder="Password" name="userPassword">
								</div>
							</div>
							<input type="submit" class="btn btn-submit" name="action"
								value="Log In" />
						</div>
					</form>
					<div class="modal-footer">
						Not a member yet?&nbsp;&nbsp; <a href="signup.htm">LET'S SIGN
							UP.</a>
					</div>
				</div>
			</div>
		</div>

	</div>

	<script type="text/javascript" src="resources/js/jquery.js"></script>
	<script type="text/javascript" src="resources/js/lightbox.min.js"></script>
	<script type="text/javascript" src="resources/js/wow.min.js"></script>
	<script type="text/javascript" src="resources/js/main.js"></script>
	<script src="http://localhost:8080/project/resources/indexFunction.js"></script>
</body>
</html>