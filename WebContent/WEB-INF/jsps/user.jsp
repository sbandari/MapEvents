<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href='${pageContext.request.contextPath}/resources/bootstrap.css'>
</head>
<body>
	<a class="btn btn-primary btn-block"
		href="${pageContext.request.contextPath}/map">Map</a>
	<c:url var="logoutUrl" value="/logout" />
	<form action="${logoutUrl}" method="post">
		<button class="btn btn-primary" type="submit">Log out</button>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	Session
	<%=session.getAttribute("userid")%>
	<h3>
		<c:out value="${name }"></c:out>
	</h3>

	<c:if test="${! empty ob }">
		<table class="table table-bordered table-inverse table-responsive">
			<tr>
				<th>name</th>
				<th>description</th>
				<th>contact</th>
				<th>city</th>
				<th>address</th>



			</tr>
			<c:forEach items="${ob}" var="ob">
				<tr>
					<td><c:out value="${ob[0]}"></c:out></td>
					<td><c:out value="${ob[1]}"></c:out></td>
					<td><c:out value="${ob[2]}"></c:out></td>
					<td><c:out value="${ob[3]}"></c:out></td>
					<td><c:out value="${ob[4]}"></c:out></td>
					<!-- should link to modal -->
					<td><a href="<c:url value='modal' />">Edit</a></td>
					<td><a
						href="<c:url value='user/userDelete/${usersList.userId }'/>">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>