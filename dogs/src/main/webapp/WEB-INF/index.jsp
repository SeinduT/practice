<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to dogs dot com</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

</head>
<body>
<div class="container">
<h1>Welcome to Dogs dot com</h1>
<table class="table table-dark">
<thead>
<tr>
<th>Id</th>
<th>Name</th>
<th>Breed</th>
<th>Age</th>
<th>Registered</th>
</tr>
</thead>
<tbody>
<c:forEach items="${allDogs}" var="dog">
<tr>
<td>${dog.id }</td>
<td><a href="/${dog.id}">${dog.name }</a></td>
<td>${dog.breed }</td>
<td>${dog.age }</td>
<td>
<c:choose>
<c:when test="${dog.tag != null}">
Registered
</c:when>
<c:otherwise>
Not Registered
</c:otherwise>
</c:choose>
</td>
</tr>
</c:forEach>
</tbody>
</table>

</div>
</body>
</html>