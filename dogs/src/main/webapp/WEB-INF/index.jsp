<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dogs Dot Com</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h1>Welcome to Dogs dot Com</h1>
<h3>Hello, <c:out value="${user.firstName}"/><c:out value="${user.lastName}"/></h3>
<a href="/add">Add A Dog</a> | <a href="/new">Gift Pup a Toy</a>
<hr>
<h3>All Pups</h3>
<table class="table  table-dark">
<thead>
<tr>
<td></td>
<td>Name</td>
<td>Breed</td>
<td>Age</td>
<td>Registered?</td>
<td>Action</td>
<td>Number Of Likes</td>
</tr>
</thead>
<tbody>
<c:forEach items="${allDogs}" var="dog">
<tr>
<td>
<c:choose>
<c:when test="${dog.likers.contains(user) }">
<a href="/unlike/${dog.id}">un-Like</a>
</c:when>
<c:otherwise>
<a href="/like/${dog.id}">Like</a>
</c:otherwise>
</c:choose>
</td>
<td><a href="/${dog.id}">${dog.name}</a></td>
<td>${dog.breed }</td>
<td>${dog.age }</td>
<td>
<c:choose>
<c:when test="${dog.tag != null}">
Registered!
</c:when>
<c:otherwise>
Not Registered
</c:otherwise>
</c:choose>

</td>
<td><a href="/delete/${dog.id}">Delete From DB</a></td>
<td>${dog.likers.size()}</td>
</tr>
</c:forEach>
</tbody>
</table>

</div>
</body>
</html>