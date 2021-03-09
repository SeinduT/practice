<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<form method="POST" action="/events/edit/${event.id}">
	<h1>Edit ${event.name}</h1>
	<form:form method="POST" action="/events/edit/${event.id}" modelAttribute="event">
	<input type="hidden"name="method" value="put">
	<form:hidden value="${user_id}" path="host"/>
	<div class="form-group">
	<form:label path="name"/> Name: 
	<form:errors path="name"/>
	<form:input path="name"/>
	</div>
		<div class="form-group">
	<form:label path="date"/> Date:
	<form:errors path="date"/>
	<form:input type="date" path="date"/>
	</div>
	<div class="form-group">
	<form:label path="city"/>Location:
	<form:errors path="city"/>
	<form:input path="city"/>
	</div>
	<div class="form-group">
	<form:label path="state"/>State:
	<form:errors path="state"/>
	<form:select path="state">
		<c:forEach items="${states}" var="state">
		<c:choose>
		<c:when test="${state.equals(event.state)}">
			<option selected value="${state}">${state}</option>
		</c:when>
		<c:otherwise>
			<option value="${state}">${state}</option>
		</c:otherwise>
		</c:choose>
		</c:forEach>
		</form:select>
	</div>
	<button class="btn btn-dark">Update Event</button>
	</form:form>
	</form>
</body>
</html>