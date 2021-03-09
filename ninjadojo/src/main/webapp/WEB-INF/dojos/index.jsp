<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Dojos and Ninjas</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	rel="stylesheet" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
	crossorigin="anonymous">
</head>
<body>
<div class="container">
	<h1>Dojos and Ninjas</h1>
	<h3><a href="/ninjas">Ninjas</a></h3>
	<a href="/dojos/new">Add New Dojo</a>
	<hr />
	<ul>
		<c:forEach items="${dojos}" var="dojo">
			<li><a href="/dojos/${dojo.id}">${dojo.name}</a></li>
		</c:forEach>
	</ul>
	<a href="/">Home</a>
</div>
</body>
</html>