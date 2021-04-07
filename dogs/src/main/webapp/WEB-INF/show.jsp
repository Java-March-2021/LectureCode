<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dog Details</title>
</head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<body>
<div class="container">
<h2>Details For ${dog.name}</h2>
<hr>
<p>Name: ${dog.name}</p>
<p>Breed: ${dog.breed}</p>

<c:choose>
<c:when test="${dog.tag != null}">
<h1>Dog Has Been Registered!</h1>
<p>City: ${dog.tag.city}</p>
<p>State: ${dog.tag.state}</p>
</c:when>
<c:otherwise>
<form:form method="POST" action="/tag/${dog.id}" modelAttribute="tag">
<p>
<form:label path="city">City
<form:errors path="city"/>
<form:input path="city"/></form:label>
</p>
<p>
<form:label path="state">State
<form:errors path="state"/>
<form:input path="state"/></form:label>
</p>
<button>Register This Pet!</button>

</form:form>
</c:otherwise>
</c:choose>



</div>
</body>
</html>