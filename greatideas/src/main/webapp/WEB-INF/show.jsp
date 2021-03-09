<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Ideas Page</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div class="container">
	<h1>${idea.ideaName}</h1>
	<p>Created By: ${idea.creator.name}</p>
	<h3>Users who liked your idea:</h3>
	<table class="table table-gray table-hover">
		<thead>
			<tr>
				<th>Name</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${idea.likedby}" var="user">
			<tr>
				<td>${user.name}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<button onclick="location.href='/ideas/edit/${idea.id}'" type="button">Edit</button>
	<br>
	<a href="/logout">Log Out</a>
</div>
</body>
</html>