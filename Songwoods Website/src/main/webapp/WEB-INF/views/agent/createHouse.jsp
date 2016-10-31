<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springform"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

	<br />
	<springform:form action="createHouse.htm" commandName="house" method="post" enctype="multipart/form-data">
	<!--  -->

		<div class="form-group">
			House Name:
			<springform:input path="houseName" class="form-control" />
		</div>
		
		<div class="form-group">
			House Room:
			<springform:input type="number" path="houseRoom" class="form-control" />
		</div>
		
		<div class="form-group">
			House Bath:
			<springform:input type="number" path="houseBath" class="form-control" />
		</div>
		
		

		<div class="form-group">
			Description:
			<springform:input path="houseDescription" id="message"
				class="form-control" />
		</div>

		<div class="form-group">
			House Type:<br/>
			<c:forEach var="typesInf" items="${requestScope.typeList}">
			&nbsp&nbsp<springform:radiobutton path="typeID.houseTypeID" value="${typesInf.houseTypeID}"/> <c:out value="${typesInf.houseTypeName}"></c:out>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
			<%-- <input type="radio" name="houseTD" value="${typesInf.houseTypeID}"/><c:out value="${typesInf.houseTypeName}"></c:out> --%>
			</c:forEach>
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
							path="houseAddress.addressNumber"></springform:input></td>
					<td class="wideField" colspan="2"><springform:input
							class="field" type="hidden" id="route" disabled="true"
							path="houseAddress.addressStreet"></springform:input></td>

					<td class="wideField" colspan="3"><springform:input
							type="hidden" class="field" id="locality" disabled="true"
							path="houseAddress.addressCity"></springform:input></td>

					
					<td class="slimField"><springform:input class="field"
							type="hidden" path="houseAddress.addressState"
							id="administrative_area_level_1" disabled="true"></springform:input></td>

					<td class="wideField"><springform:input class="field"
							id="postal_code" type="hidden" path="houseAddress.addressZipCode"
							disabled="true"></springform:input></td>

					
					<td class="wideField" colspan="3"><input class="field" type="hidden" id="country" disabled="true"></input></td>
				</tr>
			</table>
		</div>

		<div class="form-group">
			Photo:
			<input name="pics" type="file" class="form-control" />
		</div>
		
		<springform:input type="hidden" path="ownerAgent.userID" value="${sessionScope.userID}"></springform:input>
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


	<script
		src="https://maps.googleapis.com/maps/api/js?signed_in=true&libraries=places&callback=initAutocomplete"
		async defer></script>

	<script>
		// This example displays an address form, using the autocomplete feature
		// of the Google Places API to help users fill in the information.

		var placeSearch, autocomplete;
		var componentForm = {
			street_number : 'short_name',
			route : 'long_name',
			locality : 'long_name',
			administrative_area_level_1 : 'short_name',
			country : 'long_name',
			postal_code : 'short_name'
		};

		function initAutocomplete() {
			// Create the autocomplete object, restricting the search to geographical
			// location types.
			autocomplete = new google.maps.places.Autocomplete(
			/** @type {!HTMLInputElement} */
			(document.getElementById('autocomplete')), {
				types : [ 'geocode' ]
			});

			// When the user selects an address from the dropdown, populate the address
			// fields in the form.
			autocomplete.addListener('place_changed', fillInAddress);
		}

		// [START region_fillform]
		function fillInAddress() {
			// Get the place details from the autocomplete object.
			var place = autocomplete.getPlace();

			for ( var component in componentForm) {
				document.getElementById(component).value = '';
				document.getElementById(component).disabled = false;
			}

			// Get each component of the address from the place details
			// and fill the corresponding field on the form.
			for (var i = 0; i < place.address_components.length; i++) {
				var addressType = place.address_components[i].types[0];
				if (componentForm[addressType]) {
					var val = place.address_components[i][componentForm[addressType]];
					document.getElementById(addressType).value = val;
				}
			}
		}
		// [END region_fillform]

		// [START region_geolocation]
		// Bias the autocomplete object to the user's geographical location,
		// as supplied by the browser's 'navigator.geolocation' object.
		function geolocate() {
			if (navigator.geolocation) {
				navigator.geolocation.getCurrentPosition(function(position) {
					var geolocation = {
						lat : position.coords.latitude,
						lng : position.coords.longitude
					};
					var circle = new google.maps.Circle({
						center : geolocation,
						radius : position.coords.accuracy
					});
					autocomplete.setBounds(circle.getBounds());
				});
			}
		}
		// [END region_geolocation]
	</script>
</body>
</html>