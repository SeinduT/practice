<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head> <meta charset="ISO-8859-1"> 
<title>New Category</title> 
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script> 
<script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script> 
<link rel="stylesheet" type="text/css" href="/css/styles.css">
</head>
<body>
<div class="container">
<h1>New Category</h1>
<form:form method="POST" action="/categories/new" modelAttribute="category">
	<div class="form-group row">
		<form:label path="name">Name:
		<form:errors path="name"></form:errors>
		<form:input class="form-control" path="name"/>
		</form:label>
	</div>
	<div class="form-group row">
	    <div class="col-sm-10 offset-sm-2">
	      <button type="submit" class="btn btn-primary">Create</button>
	    </div>
  	</div>
</form:form>
</div>
</body>
</html>