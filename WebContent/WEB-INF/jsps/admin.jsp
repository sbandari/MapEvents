<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
<link rel="stylesheet"
	href='${pageContext.request.contextPath}/resources/bootstrap.css'>
</head>
<body>
	<div class="container">
		<h1>Users</h1>
		<a class="btn btn-primary"
			href="${pageContext.request.contextPath}/admin/userAdd">Add User</a>
		<a class="btn btn-primary" href="${pageContext.request.contextPath}/">Home</a>
		<a class="btn btn-primary btn-block"
			href="${pageContext.request.contextPath}/map">Map</a> <a
			class="btn btn-primary"
			href="${pageContext.request.contextPath}/logout">Logout</a>
		<c:if test="${! empty usersList }">
			<table class="table table-bordered table-inverse table-responsive">
				<tr>
					<th>UserId</th>
					<th>Email</th>
					<th>Password</th>

				</tr>
				<c:forEach items="${usersList}" var="usersList">
					<tr>
						<td><c:out value="${usersList.userId}"></c:out></td>
						<td><c:out value="${usersList.email}"></c:out></td>
						<td><c:out value="${usersList.password}"></c:out></td>
						<!-- should link to modal -->
						<td><a class="btn btn-success"
							href="<c:url value='/admin/userEdit/${usersList.userId }' />">Edit</a></td>
						<td><a class="btn btn-danger"
							href="<c:url value='/admin/userDelete/${usersList.userId }'/>">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>

		<h1>Events</h1>
		<a class="btn btn-primary"
			href="${pageContext.request.contextPath}/admin/eventAdd">Add
			Event</a>
		<c:if test="${! empty EventsList }">
			<table class="table table-bordered table-inverse table-responsive">
				<tr>
					<th>EventId</th>
					<th>name</th>
					<th>longitude</th>
					<th>latitude</th>
					<th>description</th>
					<th>contact</th>
					<th>city</th>
					<th>address</th>

				</tr>
				<c:forEach items="${EventsList}" var="EventsList">
					<tr>
						<td><c:out value="${EventsList.eventId}"></c:out></td>
						<td><c:out value="${EventsList.name}"></c:out></td>
						<td><c:out value="${EventsList.longitude}"></c:out></td>
						<td><c:out value="${EventsList.latitude}"></c:out></td>
						<td><c:out value="${EventsList.description}"></c:out></td>
						<td><c:out value="${EventsList.contact}"></c:out></td>
						<td><c:out value="${EventsList.city}"></c:out></td>
						<td><c:out value="${EventsList.address}"></c:out></td>
						<!-- should link to modal -->
						<td><a class="btn btn-success"
							href="<c:url value='/admin/eventEdit/${EventsList.eventId }'/>">Edit</a></td>
						<td><a class="btn btn-danger"
							href="<c:url value='/admin/eventDelete/${EventsList.eventId }'/>">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<h1>Users Regisrations</h1>
		<a class="btn btn-primary"
			href="${pageContext.request.contextPath}/admin/ureventAdd">Add
			Registration</a>
		<c:if test="${! empty regisEvents }">
			<table class="table table-bordered table-inverse table-responsive">
				<tr>
					<th>registrationId</th>
					<th>eventId</th>
					<th>userId</th>

				</tr>
				<c:forEach items="${regisEvents}" var="regisEvents">
					<tr>
						<td><c:out value="${regisEvents.registrationId}"></c:out></td>
						<td><c:out value="${regisEvents.eventId}"></c:out></td>
						<td><c:out value="${regisEvents.userId}"></c:out></td>
						<!-- should link to modal -->
						<td><a class="btn btn-success"
							href="<c:url value='/admin/editUrEvents/${regisEvents.registrationId }' />">Edit</a></td>
						<td><a class="btn btn-danger"
							href="<c:url value='/admin/deleteUrEvents/${regisEvents.registrationId }'/>">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
</body>
</html>