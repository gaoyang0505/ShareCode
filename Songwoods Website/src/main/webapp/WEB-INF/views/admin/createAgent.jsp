<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springform"%>
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

	<springform:form action="createAgent.htm" commandName="agent" method="post" enctype="multipart/form-data">

		<div class="form-group">
			First Name:
			<springform:input path="userFirstName" class="form-control" />
		</div>

		<div class="form-group">
			Last Name:
			<springform:input path="userLastName" class="form-control" />
		</div>

		<div class="form-group">
			E-Mail(*):
			<springform:input path="userEMail" class="form-control" />
		</div>

		<div class="form-group">
			Phone Number:
			<springform:input path="agentPhoneNumber" class="form-control" />
		</div>

		<div class="form-group">
			Password:
			<springform:input path="userPassword" class="form-control" />
		</div>

		<div class="form-group">
			Photo:
			<springform:input path="agentPicture" type="file"
				class="form-control" />
		</div>

		<div class="form-group">
			Company:
			<springform:select class="form-control" path="company.companyID">
				<springform:option value="==Please Select==" lable="==Please Select=="></springform:option>
				<springform:options items="${requestScope.companyList}" itemValue="companyID" itemLabel="companyName"></springform:options>
			</springform:select>
		</div>
		<input type="submit" value="Submit" class="btn btn-submit" />

	</springform:form>


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