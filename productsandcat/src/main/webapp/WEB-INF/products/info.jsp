<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head> <meta charset="ISO-8859-1"> 
<title>Product page</title> 
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script> 
<script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script> 
<link rel="stylesheet" type="text/css" href="/css/styles.css">
</head>
<body>
<div class="container">
<h1>${product.name}</h1>
<hr>
<h3>Categories</h3>
<ul>
<c:forEach items="${product.categories}" var="category">
	<li>${category.name }</li>
</c:forEach>
</ul>
<hr>
<h3>Non Categories</h3>
<ul>
<c:forEach items="${noCategories}" var="noCat">
	<li>${noCat.name }</li>
</c:forEach>
</ul>
<hr>
<h3>Add Category</h3>
<form action="/products/add/${product.id}" method="POST">
	<div class="form-group">
		<label>Add Categories:</label>
		<select name="category" class="custom-select">
		<c:forEach items="${noCategories}" var="noCat">
		  <option value="${noCat.id}">${noCat.name }</option>
		</c:forEach>
		</select>
    </div>
	<button class="btn btn-primary">Add</button>
</form>
</div>
</body>
</html>