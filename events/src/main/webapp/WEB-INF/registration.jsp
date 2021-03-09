<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<h1 class="text-center">Welcome to the Events Page</h1>
<div class="row justify-content-end">
<div class="col-8">
<h3>Register</h3>
<div>
	<form:form method="POST" action="/" modelAttribute="user">
	<div class="form-group">
	<form:label path="firstName"/> First Name:
	<form:errors path="firstName"/>
	<form:input path="firstName"/>
	</div>
	<div class="form-group">
	<form:label path="lastName"/> Last Name:
	<form:errors path="lastName"/>
	<form:input path="lastName"/>
	</div>
	<div class="form-group">
	<form:label path="email"/> Email:
	<form:errors path="email"/>
	<form:input path="email"/>
	</div>
	<div class="form-group">
	<form:label path="city"/>City: 
	<form:errors path="city"/>
	<form:input path="city"/>
	</div>
	<div class="form-group">
	<form:label path="state"/>State:
	<form:errors path="state"/>
	<form:select path="state">
	<c:forEach items="${states }" var="state">
		<option value="${state }">${state }</option>
	</c:forEach>
	</form:select>
	</div>
	<div class="form-group">
	<form:label path="password"/> Password:
	<form:errors path="password"/>
	<form:input type="password" path="password"/>
	</div>
	<div class="form-group">
	<form:label path = "confirmPassword"/>Confirm Password: 
	<form:errors path="confirmPassword"/>
	<form:input type="password" path="confirmPassword"/>
	</div>
	<input class="btn btn-dark" type="submit" value="Submit"/>
	</form:form>
	</div>
	</div>
	
	<div class="col-4">
	<h3>Login</h3>
	<p>${loginError}</p>
	<form method="POST" action="/login">
		<div class="form-group">
			<label for="email">Email: </label>
			<input type="email" name="email1">
		</div>
		<div>
		<label for="password">Password: </label>
		<input type="password" name="password1">
		</div>
		<br>
		<input class="btn btn-dark" type="submit" value="Login">
	</form>
</div>
</div>
</body>
</html>