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
<h1>${category.name}</h1>
<hr>
<h3>Products</h3>
<ul>
<c:forEach items="${category.products}" var="products">
	<li>${products.name }</li>
</c:forEach>
</ul>
<hr>
<h3>Non Products</h3>
<ul>
<c:forEach items="${noProducts}" var="noProd">
	<li>${noProd.name }</li>
</c:forEach>
</ul>
<hr>
<h3>Add Product</h3>
<form action="/category/add/${category.id}" method="POST">
<select name="product" class="custom-select">
<c:forEach items="${noProducts}" var="noProd">
  <option value="${noProd.id}">${noProd.name }</option>
</c:forEach>
</select>
<button class="btn btn-primary">Add</button>
</form>
</div>
</body>
</html>