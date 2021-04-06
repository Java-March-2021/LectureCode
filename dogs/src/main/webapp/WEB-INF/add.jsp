<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add A Dog</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h3>JSTL Spring MVC Forms Way</h3>
<form:form method="POST" action="/addDog" modelAttribute="dog">
<p>
<form:label path="name">Name:
<form:errors path="name"/>
<form:input path="name"/></form:label>
</p>
<p>
<form:label path="breed">Breed:
<form:errors path="breed"/>
<form:input path="breed"/></form:label>
</p>
<p>
<form:label path="age">Age:
<form:errors path="age"/>
<form:input path="age"/></form:label>
</p>
<button>Add Dog!</button>
</form:form>


<h3>HTML Way Of Adding To Database</h3>
<form action="/addDog" method="POST">
<div class="form-group">
<c:forEach items="${errors}" var="err">
<p>${err}</p>
</c:forEach>
<label for="name">Name</label>
<input type="text" name="name">
</div>
<div class="form-group">
<label for="breed">Breed</label>
<input type="text" name="breed">
</div>
<div class="form-group">
<label for="age">Age</label>
<input type="text" name="age">
</div>
<button>Add Dog</button>
</form>

</div>
</body>
</html>