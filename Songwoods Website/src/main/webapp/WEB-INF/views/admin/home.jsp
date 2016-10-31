<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="adminForm"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet"
	href="http://localhost:8080/project/resources/adminHome.css">
</head>
<body>

	<div class="body"></div>
	<div class="grad"></div>
	<div class="header">
		<div>
			Admin<span>Login</span>
		</div>
	</div>
	<br>

	<div class="login">
		<%
			if (request.getAttribute("error") != null) {
				String errorMessage = request.getAttribute("error").toString();
		%>
		<%=errorMessage%>
		<jsp:scriptlet>}</jsp:scriptlet>
		<form action="home.htm" method="post">
			<input type="text" placeholder="username" name="adminEMail"><br>
			<input type="password" placeholder="password" name="adminPassword"><br>
			<input type="submit" value="Login">
		</form>
	</div>

</body>
</html>