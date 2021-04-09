<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Dog</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h2>Edit ${dog.name}</h2>

<form:form method="POST" action="/edit/${dog.id}" modelAttribute="dog">
<div class="form-group">
<form:label path="name">Name:
<form:errors path="name"/>
<form:input path="name"/></form:label>
</div>
<div class="form-group">
<form:label path="breed">Breed:
<form:errors path="breed"/>
<form:input path="breed"/></form:label>
</div>
<div class="form-group">
<form:label path="age">Age:
<form:errors path="age"/>
<form:input path="age"/></form:label>
</div>
<button>Submit Changes</button>
</form:form>


</div>
</body>
</html>