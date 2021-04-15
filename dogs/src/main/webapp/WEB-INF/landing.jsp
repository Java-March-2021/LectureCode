<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rinky Dink Login for Dogs dot Com</title>
</head>
<body>
<form method="POST" action="/login">
<select name="userToBeLoggedIn">
<c:forEach items="${users}" var="user">
<option value="${user.id}">${user.firstName} ${user.lastName}</option>

</c:forEach></select>
<button>Login</button>
</form>
</body>
</html>