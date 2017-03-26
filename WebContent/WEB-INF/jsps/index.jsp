<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to MapEvents</title>
<link rel="stylesheet"
	href='${pageContext.request.contextPath}/resources/bootstrap.css'>
</head>
<body>
	<div class="container">
		<div class="btn-group btn-group-lg">
			<a class="btn btn-primary btn-block"
				href="${pageContext.request.contextPath}/admin/admin">Admin</a> <a
				class="btn btn-primary btn-block"
				href="${pageContext.request.contextPath}/user/user">User</a> <a
				class="btn btn-primary btn-block"
				href="${pageContext.request.contextPath}/map">Map</a> <a
				class="btn btn-primary btn-block"
				href="${pageContext.request.contextPath}/login">Login</a>
		</div>
	</div>
</body>
</html>