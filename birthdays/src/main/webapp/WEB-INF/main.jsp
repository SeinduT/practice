<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View all</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
	<div class="container">
	<nav class="navbar navbar-expand-sm bg-light navbar-light">
	  <ul class="navbar-nav ml-auto">
	    <li class="nav-item active">
	      <a class="nav-link" href="/logout">Log Out</a>
	    </li>
	  </ul>
	</nav>
	<h1>Welcome ${ user.usrName }</h1>
	<h3>Occasions</h3>
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th>Name</th>
				<th>Relation</th>
				<th>Occasion</th>
				<th>Date</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${user.person}" var="person">
			<tr>
				<td><a href="/main/${person.id}">${person.personName}</a></td>
				<td>${person.relation}</td>
				<td>${person.occasion}</td>
				<td>${person.date}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<button onclick="location.href='/main/new'" type="button">Create new Occasion</button>
</div>
</body>
</html>