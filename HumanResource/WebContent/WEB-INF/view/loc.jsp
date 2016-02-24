<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<th>LOCATION_ID</th>
		<th>STREET_ADDRESS</th>
		<th>POSTAL_CODE</th>
		<th>CITY</th>
		<th>STATE_PROVINCE</th>
		<th>COUNTRY_ID</th>
	</tr>
<c:forEach items="${ allLocations }" var="loc">
	<tr>
		<td>${ loc.locationId }</td>
		<td>${ loc.streetAddress }</td>
		<td>${ loc.postalCode }</td>
		<td>${ loc.city }</td>
		<td>${ loc.stateProvince }</td>
		<td>${ loc.countryId }</td>
	</tr>
</c:forEach>
</table>
</body>
</html>