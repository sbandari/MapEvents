<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Login Page</title>
</head>
<body onload='document.f.username.focus();'>
	<center>
		<h3>Login with Username and Password</h3>
		<c:if test="${param.error != null}">
			<p class=error>Invalid Credentials</p>
		</c:if>
		<form name='f' action='${pageContext.request.contextPath}/login'
			method='POST'>
			<table>
				<tr>
					<td>User:</td>
					<td><input type='text' name='username' value=''></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type='password' name='password' /></td>
				</tr>
				<tr>
					<td colspan='2'><input name="submit" type="submit"
						value="Login" /></td>
				</tr>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</table>
		</form>
		<p>
			<a href="${pageContext.request.contextPath}/newaccount"> Create
				Acoount</a>
		</p>
	</center>
</body>
</html>