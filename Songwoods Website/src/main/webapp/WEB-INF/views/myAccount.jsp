<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Blog Default | Triangle</title>
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
							<li class="active"><a href="userBroAgent.htm">Agent</a></li>
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

    <footer id="footer">
        <div class="container">
            <div class="row">
                <div class="col-sm-12 text-center bottom-separator">
                    <img src="images/home/under.png" class="img-responsive inline" alt="">
                </div>
                <div class="col-md-4 col-sm-6">
                    
                </div>
                
                <div class="col-md-4 col-sm-12">
                    <div class="contact-form bottom">
                        <h2>Change Password</h2>
                        <form id="main-contact-form" name="contact-form" method="post" action="changeP.htm">
                            <div class="form-group">
                                <input type="text" name="oldP" class="form-control" required="required" placeholder="Old One">
                            </div>
                            <div class="form-group">
                                <input type="text" name="newP" class="form-control" required="required" placeholder="New One">
                            </div>
                            <div class="form-group">
                                <input type="text" name="comP" class="form-control" required="required" placeholder="Confirm New Password">
                            </div>                        
                            <div class="form-group">
                                <input type="submit" name="submit" class="btn btn-submit" value="Submit">
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-sm-12">
                    <div class="copyright-text text-center">
                      
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!--/#footer-->


    <script type="text/javascript" src="resources/js/jquery.js"></script>
    <script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="resources/js/lightbox.min.js"></script>
    <script type="text/javascript" src="resources/js/wow.min.js"></script>
    <script type="text/javascript" src="resources/js/main.js"></script>   
</body>
</html>
