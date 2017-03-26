<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add User</title>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/admin/addUser" method="Post" commandName="users">
<form:label path="email">Email</form:label>
<form:input path="email"/><br/>
<form:label path="password"></form:label>
<form:input path="password"/><br/>
<input type="submit" value="Submit">
</form:form>
</body>
</html>