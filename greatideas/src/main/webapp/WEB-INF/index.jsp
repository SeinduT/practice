<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Wlcome to Me dot com</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

</head>
<body>
<div class="container">
	<h1>Welcome to Me dot com</h1>
	<div class="row">
	<div class="col">
	<h3><a href="/login">Login</a></h3>
	<p>${loginError}</p>
	<form method="POST" action="/login">
		<div class="form-group">
			<label>Email:</label>
			<input class="form-control" type="email" name="loginEmail">
		</div>
		<div class="form-group">
			<label>Password:</label>
			<input class="form-control" type="password" name="loginPassword">
			<button class="btn btn-danger">Login</button>
		</div>
	</form>
	<h3>Register</h3>

	<form:form action="/register" method="post" modelAttribute="user">
		<div class="form-group">
			<form:label path="name">Name</form:label>
			<form:errors path="name"/>
			<form:input class="form-control" path="name"/>
		</div>

		<div class="form-group">
			<form:label path="email">Email</form:label>
			<form:errors path="email"/>
			<form:input class="form-control" path="email"/>
		</div>
		<div class="form-group">
			<form:label path="password">Password</form:label>
			<form:errors path="password"/>
			<form:input class="form-control" path="password"/>
		</div>
		<div class="form-group">
			<form:label path="confirmPassword">Confirm Password</form:label>
			<form:errors path="confirmPassword"/>
			<form:input class="form-control" path="confirmPassword"/>
		</div>
		<input class="btn btn-danger" type="submit" value="Submit"/>
	</form:form>

	</div>
	</div>
</div>
</body>
</html>