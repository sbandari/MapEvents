<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Event</title>
</head>
<body>
	<form:form action="${pageContext.request.contextPath}/admin/addEvent"
		method="Post" commandName="events">
		<form:label path="name">Name</form:label>
		<form:input path="name" />
		<br />
		<form:label path="longitude"> longitude</form:label>
		<form:input path="longitude" />
		<br />
		<form:label path="latitude"> latitude</form:label>
		<form:input path="latitude" />
		<br />
		<form:label path="description"> description</form:label>
		<form:input path="description" />
		<br />
		<form:label path="contact"> contact</form:label>
		<form:input path="contact" />
		<br />
		<form:label path="city"> city</form:label>
		<form:input path="city" />
		<br />
		<form:label path="address"> address</form:label>
		<form:input path="address" />
		<br />
		<input type="submit" value="Submit">
	</form:form>
</body>
</html>