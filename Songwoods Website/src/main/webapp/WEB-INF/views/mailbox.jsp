<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>MailBox | Songwoods</title>
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
<input type="hidden" name="owner" value="${sessionScope.userID}">
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

    <section id="page-breadcrumb">
        <div class="vertical-center sun">
             <div class="container">
                <div class="row">
                    <div class="action">
                        <div class="col-sm-12">
                            <h1 class="title">Mail Box</h1>
                            <p><a href="mailBox.htm">Inbox (${requestScope.unread})</a> | <a href="outBox.htm">Send (${requestScope.send})</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
   </section>
    <!--/#action-->

    <section id="blog" class="padding-top">
        <div class="container">
            <div class="row">
            
                <div class="col-md-3 col-sm-5">
                    <div class="sidebar blog-sidebar">
                        <div class="sidebar-item  recent">
                            <h3>List Message</h3>
                            <c:forEach var="messIte" items="${requestScope.messageList}">
                            <div class="media">
                                <div class="pull-left">
                                <c:choose>
                                <c:when test="${messIte.receiver.userEMail eq sessionScope.user}">
                                <c:choose>
                                <c:when test="${messIte.messageStatus == 'Unread'}"><i class="fa fa-envelope" aria-hidden="true"></i></c:when>
                                </c:choose>
                                </c:when>
                                </c:choose>
                                </div>
                                <div class="media-body">
                                	<input type="hidden" name="ajaxMes" value="${messIte.messageID}">
                                    <h4><a href="#" onclick="return getMessageDetai();"><c:out value="${messIte.messageTitle}"></c:out></a></h4>
                                    <p>posted on  <c:out value="${messIte.messageDate}"></c:out></p>
                                </div>
                            </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
              
                
                <div class="col-md-9 col-sm-7">
                    <div class="row" id="detailMessage" style="opacity:0">
                        
                        <div class="col-md-12 col-sm-12">
                            <div class="single-blog two-column">
                                <div class="post-content overflow">
                                    <h2 class="post-title bold"><a href="#" id="mesTit">Title</a></h2>
                                    <h3 class="post-author"><a href="#" id="mesTime">Posted by</a></h3>
                                    <p id="messCon">Message</p>
                                    <div class="post-bottom overflow">
                                        <ul class="nav navbar-nav post-nav" id="judgeDiv">
                                        
                                            <li id="mesType"><i class="fa fa-diamond" aria-hidden="true"></i></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                 </div>
            </div>
        </div>
    </section>

<input type="hidden" name="rec"/>


<!--/#Modal-->
		<div class="modal fade" id="loginBlock" tabindex="-1" role="dialog"
			aria-labelledby="loginTile" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">x</button>
						<h4 class="modal-title" id="loginTile">Send A Message</h4>
					</div>

					<form class="form-horizontal" onsubmit="return sendMessageInMailBox();" id="main-contact-form" name="contact-form">
						<div class="modal-body">

							<div class="form-group">
                                <input type="text" name="mesTitle" class="form-control" required="required" placeholder="Title">
                            </div>
                            <div class="form-group">
                                <select name="mesType" class="selectVal form-control">
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
						</div>
					</form>
					<div class="modal-footer">
						<a></a>
					</div>
				</div>
			</div>
		</div>

    <script type="text/javascript" src="resources/js/jquery.js"></script>
    <script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="resources/js/lightbox.min.js"></script>
    <script type="text/javascript" src="resources/js/wow.min.js"></script>
    <script type="text/javascript" src="resources/js/main.js"></script> 
    <script type="text/javascript" src="resources/showDetailMes.js"></script> 
</body>
</html>
