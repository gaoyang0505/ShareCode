<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!-- Template by quackit.com -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Search House</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/font-awesome.min.css" rel="stylesheet">
<link href="resources/css/animate.min.css" rel="stylesheet">
<link href="resources/css/lightbox.css" rel="stylesheet">
<link href="resources/css/main.css" rel="stylesheet">
<link href="resources/css/responsive.css" rel="stylesheet">

 <script src="http://maps.google.com/maps/api/js?sensor=false" 
          type="text/javascript"></script>
          
          
<style type="text/css">
body {
	margin: 0;
	padding: 0;
	overflow: hidden;
	height: 100%;
	max-height: 100%;
	font-family: Sans-serif;
	line-height: 1.5em;
}

#header {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 205px;
	overflow: hidden;
	/* Disables scrollbars on the header frame. To enable scrollbars, change "hidden" to "scroll" */
	background: white;
}

#nav {
	position: absolute;
	top: 205px;
	left: 0;
	bottom: 0;
	width: 600px;
	overflow: auto;
	/* Scrollbars will appear on this frame only when there's enough content to require scrolling. To disable scrollbars, change to "hidden", or use "scroll" to enable permanent scrollbars */
	background: white;
}

#logo {
	padding: 40px;
}

main {
	position: fixed;
	top: 205px; /* Set this to the height of the header */
	left: 600px;
	right: 0;
	bottom: 0;
	overflow: auto;
	background: white;
}

.innertube {
	margin: 15px; /* Provides padding for the content */
}

p {
	color: #555;
}

nav ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
}

nav ul a {
	color: darkgreen;
	text-decoration: none;
}

#mapGuge {
margin:5px auto 0 auto;
padding 15px 15px 45px;
heignt:150px;
width:500px;
}
/*IE6 fix*/
* html body {
	padding: 100px 0 0 230px;
	/* Set the first value to the height of the header and last value to the width of the nav */
}

* html main {
	height: 100%;
	width: 100%;
}

#header {
	padding-top: 5px;
}
</style>

</head>

<body>



	<!-- set search item status in cookie -->

	<header id="header">
	<div id="mapGuge"></div>
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


		<div id="logo">
		
			<form action="search_advance.htm" method="post" class="form-inline">

				<input class="form-control form-inline" type="text" name="cityZip" id="city" style="width: 400px" value="${requestScope.city}" placeholder="City or ZipCode"/> 
				&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspPrice <input type="number" class="form-control" name="minPrice" id="min" placeholder="Min" style="width: 100px"/> to <input class="form-control" type="number" style="width: 100px" name="maxPrice" id="max" placeholder="Max" /> 
				<br/><label for="bedRoom">Bed</label>
				<select name="bedNum" class="form-control" style="width:100px">
					<option value="Any">Any</option>
					<option value="1">1+</option>
					<option value="2">2+</option>
					<option value="3">3+</option>
					<option value="4">4+</option>
					<option value="5">5+</option>
				</select> 
				&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
				<label for="bathRoom">Baths</label> 
				
				<select class="form-control" name="bathNum" style="width:100px">
					<option value="Any">Any</option>
					<option value="1">1+</option>
					<option value="2">2+</option>
					<option value="3">3+</option>
					<option value="4">4+</option>
					<option value="5">5+</option>
				</select>
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
				<c:forEach var="houseTypeItem" items="${requestScope.typeList}">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					<input type="checkbox" name="checkType" value="${houseTypeItem.houseTypeName}" />
					<c:out value="${houseTypeItem.houseTypeName}"></c:out>
				</c:forEach>
				<input type="hidden" name="advancedSearch" value="advancedSearch" />
				<input type="submit" class="btn btn-submit" style="width: 100px"
					value="Search" />
			</form>
			<hr>
		</div>

	</header>




	<!-- Right -->
	<main>

	<div class="innertube">
		<div id="map" style="width: 700px; height: 600px;"></div>
	</div>
	</main>
	<script type="text/javascript">
    var locations = [
      ['Bondi Beach', -71.0881734, 42.339348, 4]
    ];

    var map = new google.maps.Map(document.getElementById('map'), {
      zoom: 10,
      center: new google.maps.LatLng(-71.08, 42.33),
      mapTypeId: google.maps.MapTypeId.ROADMAP
    });

    var infowindow = new google.maps.InfoWindow();

    var marker, i;

    for (i = 0; i < locations.length; i++) {  
      marker = new google.maps.Marker({
        position: new google.maps.LatLng(locations[i][1], locations[i][2]),
        map: map
      });

      google.maps.event.addListener(marker, 'click', (function(marker, i) {
        return function() {
          infowindow.setContent(locations[i][0]);
          infowindow.open(map, marker);
        }
      })(marker, i));
    }
  </script>

	<!-- Left -->
	<nav id="nav">
		<div class="innertube">
			<section id="blog" class="padding-top">
				<div class="container">
					<div class="row">
						<div class="col-md-9 col-sm-7">
							<div class="row">

								<c:choose>
									<c:when test="${empty requestScope.houseList}">
									Sorry there is no result.
								</c:when>
									<c:otherwise>
										<c:forEach var="houseItem" items="${requestScope.houseList}">
											<div class="col-sm-12 col-md-12">
												<div class="single-blog single-column">
													<div class="post-thumb">



														<!-- PIC -->
														<a href="#"><img src="" class="img-responsive"
															alt="list of pics"></a>
														<!-- PIC -->
														<div class="post-overlay">
															<span class="uppercase"><a
																href="houseDetail.htm?houseInfor=<c:out value='${houseItem.houseID}'></c:out>">12
																	<br> <small><c:out
																			value="${houseItem.houseStatus}"></c:out></small>
															</a></span>
														</div>
													</div>
													<div class="post-content overflow">
														<h2 class="post-title bold">
															<a href="#"><c:out value="${houseItem.houseName}"></c:out></a>
														</h2>
														<h3 class="post-author">
															<a href="#">Posted by <c:out
																	value="${houseItem.ownerAgent.userFirstName}"></c:out>
																<c:out value="${houseItem.ownerAgent.userLastName}"></c:out></a>
														</h3>
														<p>
															$
															<c:out value="${houseItem.housePrice}"></c:out>
															|
															<c:out value="${houseItem.houseRoom}"></c:out>
															Rooms |
															<c:out value="${houseItem.typeID.houseTypeName}"></c:out>
														</p>
														<!-- <a href="#" class="read-more">View More</a> -->
														<div class="post-bottom overflow">
															<ul class="nav navbar-nav post-nav">
																<li><a href="#"><i class="fa fa-tag"></i>Creative</a></li>
																<li><a href="addToMyFavorite.htm"><i
																		class="fa fa-star"></i>Collection</a></li>
																<li><a href="#"><i class="fa fa-comments"></i>3
																		Comments</a></li>
															</ul>
														</div>
													</div>
												</div>
											</div>
										</c:forEach>
									</c:otherwise>
								</c:choose>




							</div>
						</div>
					</div>
				</div>
			</section>
		</div>
	</nav>

	<script type="text/javascript" src="resources/js/jquery.js"></script>
	<script type="text/javascript" src="resources/js/lightbox.min.js"></script>
	<script type="text/javascript" src="resources/js/wow.min.js"></script>
	<script type="text/javascript" src="resources/js/main.js"></script>
</body>
</html>