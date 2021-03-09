<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head> <meta charset="ISO-8859-1"> 
<title>All Products</title> 
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script> 
<script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script> 
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div class="container">
<h1> All Products </h1>
<table class="table">
  <thead class="thead-dark">
    <tr>
  	  <th>ID</th>
      <th>Name</th>
      <th>Description</th>
      <th>Price</th>
      <th>Category</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${products}" var="product">
    <tr>
      	<td>${product.id}</td>
      	<td><a href="products/${product.id}">${product.name}</a></td>
      	<td>${product.description}</td>
      	<td>${product.price}</td>
      	<c:forEach items="${product.categories}" var="category">
	  	<td>${category.name}</td>
		</c:forEach>
    </tr>
   </c:forEach>
  </tbody>
</table>
<a href="/products/new">Add Product</a>
<div>
<a href="/categories">Categories</a>
</div>
</div>
</body>
</html>