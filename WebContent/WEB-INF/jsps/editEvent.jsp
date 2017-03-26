<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Event</title>
</head>
<body>
	<c:forEach items="${event}" var="event">
		<form:form action="${pageContext.request.contextPath}/admin/addEvent"
			method="Post" commandName="events">
			<form:label path="eventId">Event ID</form:label>
			<form:input path="name" value="${event.eventId }" readonly="true" />
			<form:label path="name">Name</form:label>
			<form:input path="name" value="${event.name }" />
			<br />
			<form:label path="longitude"> longitude</form:label>
			<form:input path="longitude" value="${event.longitude }" />
			<br />
			<form:label path="latitude"> latitude</form:label>
			<form:input path="latitude" value="${event.latitude }" />
			<br />
			<form:label path="description"> description</form:label>
			<form:input path="description" value="${event.description }" />
			<br />
			<form:label path="contact"> contact</form:label>
			<form:input path="contact" value="${event.contact }" />
			<br />
			<form:label path="city"> city</form:label>
			<form:input path="city" value="${event.city }" />
			<br />
			<form:label path="address"> address</form:label>
			<form:input path="address" value="${event.address }" />
			<br />
			<input type="submit" value="Submit">
		</form:form>
	</c:forEach>
</body>
</html>