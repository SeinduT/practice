<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Personal Details</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

</head>
<body>
<div class="container">
<h1>Welcome to Personal detail page</h1>
<table class="table table-light">
<thead>
<tr>
<th>Id</th>
<th>First Name</th>
<th>Last Name</th>
</tr>
</thead>
<tbody>
<c:forEach items="${allPersons}" var="person">
<tr>
<td>${person.id}</td>
<td>${person.firstName}</td>
<td>${person.lastName}</td>
</tr>
</c:forEach>
</tbody>
</table>


</div>

</body>
</html>