<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create new license</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

</head>
<body>
	<div class="container">
		<h2>New License</h2>
		<form:form action="/licenses" method="POST" modelAttribute="license">
			<div class="form-group">
		        <form:label path="person">Person</form:label>
		        <form:errors path="person"/>
		        <form:select class="form-control" path="person">
		        <c:forEach items="${ persons }" var="p">
		        	<form:option value="${ p.id }">${ p.firstName } ${ p.lastName }</form:option>
		        </c:forEach>
		        </form:select>
		    </div>
			<div class="form-group">
		        <form:label path="state">State</form:label>
		        <form:errors path="state"/>
		        <form:input class="form-control" path="state"/>
		    </div>
		    <div class="form-group">
		        <form:label path="expirationDate">Expiration Date</form:label>
		        <form:errors path="expirationDate"/>
		        <form:input type="date" class="form-control" path="expirationDate"/>
		    </div>
		    <button>Add License</button>
		</form:form>
	</div>
</body>
</html>