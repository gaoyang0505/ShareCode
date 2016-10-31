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
		<springform:form method="post" action="createCompany.htm"
			commandName="company">
			<div class="form-group">
				Company Name:
				<springform:input type="text" name="comName" class="form-control"
					required="required" path="companyName" />
			</div>

			<div class="form-group">
				Contact E-Mail:
				<springform:input type="email" name="email" class="form-control"
					required="required" path="contactEMail" />
			</div>

			<div class="form-group">
				Phone Number:
				<springform:input type="text" name="message" required="required"
					class="form-control" path="phoneNumber" />
			</div>

			<div class="form-group">
				Address:
				<div id="locationField">
					<input id="autocomplete" placeholder="Enter your address"
						onFocus="geolocate()" type="text" class="form-control"></input>
				</div>

				<table id="address">
					<tr>
						<td class="label">Street address</td>
						<td class="slimField"><springform:input type="hidden"
								class="field" id="street_number" disabled="true"
								path="companyAddress.addressNumber"></springform:input></td>
						<td class="wideField" colspan="2"><springform:input
								class="field" type="hidden" id="route" disabled="true"
								path="companyAddress.addressStreet"></springform:input></td>

						<td class="wideField" colspan="3"><springform:input
								type="hidden" class="field" id="locality" disabled="true"
								path="companyAddress.addressCity"></springform:input></td>


						<td class="slimField"><springform:input class="field"
								type="hidden" path="companyAddress.addressState"
								id="administrative_area_level_1" disabled="true"></springform:input></td>

						<td class="wideField"><springform:input class="field"
								id="postal_code" type="hidden"
								path="companyAddress.addressZipCode" disabled="true"></springform:input></td>


						<td class="wideField" colspan="3"><input class="field"
							type="hidden" id="country" disabled="true"></input></td>
					</tr>
				</table>
			</div>

			<div class="form-group">
				<input type="submit" name="submit" class="btn btn-submit"
					value="Submit">
			</div>
		</springform:form>
	</div>
</body>
</html>