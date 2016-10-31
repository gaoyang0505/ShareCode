<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springform"%>
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
	<div class="contact-form bottom">
		<springform:form method="post" action="createHouseType.htm" commandName="houseType">
			<div class="form-group">
			House Type:
				<springform:input type="text" class="form-control"
					required="required" path="houseTypeName"/>
			</div>
			<div class="form-group">
				<input type="submit" name="submit" class="btn btn-submit"
					value="Submit">
			</div>
		</springform:form>
	</div>
</body>
</html>