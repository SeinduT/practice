<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to all persons Page</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
	<div class="container">
	<nav class="navbar navbar-expand-sm bg-light navbar-light">
	  <ul class="navbar-nav ml-auto">
	    <li class="nav-item active">
	      <a class="nav-link" href="/main">Home</a>
	    </li>
	    <li class="nav-item active">
	      <a class="nav-link" href="/logout">Log Out</a>
	    </li>
	  </ul>
	</nav>
		<div class="container">
			<h1>${person.personName}</h1>
			<h5>Details</h5>
			<p>${person.personName}'s ${person.occasion} is on ${person.date}</p>
				<p>Relationship: ${person.relation}</p>
				<p>Occasion: 	 ${person.occasion}</p>
				<p>Date:		 ${person.date}</p>
			<h3>Comments</h3>
			<p>${person.comments}</p>
			<p><a href="/main/edit/${person.id}">Edit</a></p>
		</div>
	</div>
</body>
</html>