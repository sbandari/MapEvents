<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${user}" var="user">
		<form:form
			action="${pageContext.request.contextPath}/admin/userUpdate"
			method="Post" commandName="users">
			<form:label path="userId">User ID</form:label>
			<form:input path="userId" value="${user.userId}" readonly="true" />
			<br />
			<form:label path="email">Email</form:label>
			<form:input path="email" value="${user.email }" />
			<br />
			<form:label path="password"></form:label>
			<form:input path="password" value="${user.password }" />
			<br />
			<input type="submit" value="Submit">
		</form:form>
	</c:forEach>
</body>
</html>