<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Blog Details | Triangle</title>
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/font-awesome.min.css" rel="stylesheet">
    <link href="resources/css/lightbox.css" rel="stylesheet"> 
    <link href="resources/css/animate.min.css" rel="stylesheet"> 
	<link href="resources/css/main.css" rel="stylesheet">
	<link href="resources/css/responsive.css" rel="stylesheet">
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
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
							<li class="active"><a href="index.html">Home</a></li>
							<li class="dropdown"><a href="#">Pages <i
									class="fa fa-angle-down"></i></a>
								<ul role="menu" class="sub-menu">
									<li><a href="aboutus.html">About</a></li>
									<li><a href="aboutus2.html">About 2</a></li>
									<li><a href="service.html">Services</a></li>
									<li><a href="pricing.html">Pricing</a></li>
									<li><a href="contact.html">Contact us</a></li>
									<li><a href="contact2.html">Contact us 2</a></li>
									<li><a href="404.html">404 error</a></li>
									<li><a href="coming-soon.html">Coming Soon</a></li>
								</ul></li>
							<li class="dropdown"><a href="blog.html">Blog <i
									class="fa fa-angle-down"></i></a>
								<ul role="menu" class="sub-menu">
									<li><a href="blog.html">Blog Default</a></li>
									<li><a href="blogtwo.html">Timeline Blog</a></li>
									<li><a href="blogone.html">2 Columns + Right Sidebar</a></li>
									<li><a href="blogthree.html">1 Column + Left Sidebar</a></li>
									<li><a href="blogfour.html">Blog Masonary</a></li>
									<li><a href="blogdetails.html">Blog Details</a></li>
								</ul></li>
							<li class="dropdown"><a href="portfolio.html">Portfolio
									<i class="fa fa-angle-down"></i>
							</a>
								<ul role="menu" class="sub-menu">
									<li><a href="portfolio.html">Portfolio Default</a></li>
									<li><a href="portfoliofour.html">Isotope 3 Columns +
											Right Sidebar</a></li>
									<li><a href="portfolioone.html">3 Columns + Right
											Sidebar</a></li>
									<li><a href="portfoliotwo.html">3 Columns + Left
											Sidebar</a></li>
									<li><a href="portfoliothree.html">2 Columns</a></li>
									<li><a href="portfolio-details.html">Portfolio Details</a></li>
								</ul></li>
								
							<c:choose>
								<c:when test="${empty sessionScope.user}">
									<li><a href="" data-toggle="modal" data-target="#loginBlock" id="loginInfor">Log In</a></li>
									<div id="logoutDIV"></div>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${requestScope.user.roleType == 'Client'}">
											<li><a href="myAccount.htm" id="loginInfor">${requestScope.user.userFirstName}</a></li>
											<li><a href="logout.htm">Log Out</a></li>
										</c:when>
										<c:when test="${requestScope.user.roleType == 'Agent'}">
											<li><a href="manage.htm" id="loginInfor">${requestScope.user.userFirstName}</a></li>
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

    <section id="blog-details" class="padding-top">
        <div class="container">
            <div class="row">
                <div class="col-md-9 col-sm-7">
                    <div class="row">
                         <div class="col-md-12 col-sm-12">
                            <div class="single-blog blog-details two-column">
                                <div class="post-thumb">
                                
                                <!-- PIC -->
                                    <a href="#"><img src="images/blog/7.jpg" class="img-responsive" alt=""></a>
                                <!-- PIC -->
                                 
                                    <div class="post-overlay">
                                        <span class="uppercase"><a href="#">14 <br><small><c:out value="${houseItem.houseStatus}"></c:out></small></a></span>
                                    </div>
                                </div>
                                <div class="post-content overflow">
                                    <h2 class="post-title bold"><a href="#">${requestScope.houseDetail.houseName}</a></h2>
                                    <h3 class="post-author"><a href="#">Posted by ${requestScope.houseDetail.ownerAgent.userFirstName} ${requestScope.houseDetail.ownerAgent.userLastName}</a></h3>
                                    <p>${requestScope.houseDetail.houseDescription}</p>
                                    <div class="post-bottom overflow">
                                        <ul class="nav navbar-nav post-nav">
                                            <li><a href="#"><i class="fa fa-tag"></i>Creative</a></li>
                                            
                                            <li><a href="#" onclick="return favoriteHo(this)"><i class="fa fa-heart"></i>Collection</a></li>
                                            
                                            <li><a href="#"><i class="fa fa-comments"></i>3 Comments</a></li>
                                        </ul>
                                        <input type="hidden" name="houseID" value="${requestScope.houseDetail.houseID}">
                                    </div>
                                    
                                    <div class="author-profile padding">
                                        <div class="row">
                                            <div class="col-sm-2">
                                                <img src="file:///Users/clark/Desktop/DestinationImage/<c:out value='${requestScope.houseDetail.ownerAgent.agentPicturePath}'></c:out>" alt="">
                                            </div>
                                            <div class="col-sm-10">
                                                <h3>${requestScope.houseDetail.ownerAgent.userFirstName} ${requestScope.houseDetail.ownerAgent.userLastName}</h3>
                                                <p>${requestScope.houseDetail.ownerAgent.agentDescription}</p>
                                            </div>
                                        </div>
                                    </div>
                                   
                                </div>
                            </div>
                        </div>
                    </div>
                 </div>
                <div class="col-md-3 col-sm-5">
                    <div class="sidebar blog-sidebar">
                        <div class="sidebar-item  recent">
                            <h3>Comments</h3>
                            <div class="media">
                                <div class="pull-left">
                                    <a href="#"><img src="images/portfolio/project1.jpg" alt=""></a>
                                </div>
                                <div class="media-body">
                                    <h4><a href="#">Lorem ipsum dolor sit amet consectetur adipisicing elit,</a></h4>
                                    <p>posted on  07 March 2014</p>
                                </div>
                            </div>
                            <div class="media">
                                <div class="pull-left">
                                    <a href="#"><img src="images/portfolio/project2.jpg" alt=""></a>
                                </div>
                                <div class="media-body">
                                    <h4><a href="#">Lorem ipsum dolor sit amet consectetur adipisicing elit,</a></h4>
                                    <p>posted on  07 March 2014</p>
                                </div>
                            </div>
                            <div class="media">
                                <div class="pull-left">
                                    <a href="#"><img src="images/portfolio/project3.jpg" alt=""></a>
                                </div>
                                <div class="media-body">
                                    <h4><a href="#">Lorem ipsum dolor sit amet consectetur adipisicing elit,</a></h4>
                                    <p>posted on  07 March 2014</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--/#blog-->

    <footer id="footer">
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-sm-6">
                </div>
                <c:choose>
                <c:when  test="${empty sessionScope.user}">
                <p>LOG IN TO SEND MESSAGE TO AGENT.</p>
                </c:when>
                <c:otherwise>
                <div class="col-md-4 col-sm-12">
                    <div class="contact-form bottom">
                        <h2>Send a message</h2>
                        <form onsubmit="return sendMessage();" id="main-contact-form" name="contact-form" >
                            <div class="form-group">
                                <input type="text" name="mesTitle" class="form-control" required="required" placeholder="Title">
                            </div>
                            <div class="form-group">
                                <select name="mesType" class="selectVal">
									<option value="Appointment">Appointment</option>
									<option value="Message">Message</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <input name="messageCon" id="message" required="required" class="form-control" style="height:400px;" placeholder="Your text here"></input>
                            </div>                        
                            <div class="form-group">
                            <input type="hidden" name="sender" value="${sessionScope.user}">
                            <input type="hidden" name="receiver" value="${requestScope.houseDetail.ownerAgent.userEMail}">
                                <input type="submit" name="submit" class="btn btn-submit" value="Send">
                            </div>
                        </form>
                    </div>
                </div>
                </c:otherwise>
                </c:choose>
            </div>
        </div>
    </footer>
    <!--/#footer-->


    <script type="text/javascript" src="resources/js/jquery.js"></script>
    <script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="resources/js/lightbox.min.js"></script>
    <script type="text/javascript" src="resources/js/wow.min.js"></script>
    <script type="text/javascript" src="resources/js/main.js"></script> 
    <script type="text/javascript" src="resources/favoriteHouse.js"></script>   
</body>
</html>
