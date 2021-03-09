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
<h1>Welcome, ${user.firstName}</h1>
<a class="float-right" href="/logout">logout</a>
<p>Here are some of the events in your state:
<table class="table table-dark">
<thead>
<tr>
	<th>Name</th>
	<th>Date</th>
	<th>Location</th>
	<th>Host</th>
	<th>Actions/Status</th>
</tr>
</thead>
<tbody>
<c:forEach items="${allEvents}" var="event">
<tr>
	<td><a href="/events/${event.id}">${event.name}</a></td>
	<td><fmt:formatDate value="${ event.date }" pattern="MMM dd, yyyy"/></td>
	<td>${event.city}</td>
	<td>${event.host.firstName}</td>
	<td>
	<c:choose>
		<c:when test="${event.host.id == user.id}">
		<a href="events/edit/${event.id}">Edit</a>
		<a href="/events/delete/${event.id}">Delete</a>
		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${event.attendees.contains(user)}">
					<span>Joining <a href="/events/${event.id}/cancel">Cancel</a></span>
				</c:when>
				<c:otherwise>
					<a href="/events/${event.id}/join">Join</a>
				</c:otherwise>
			</c:choose>
		</c:otherwise>
	</c:choose>
	</td>
</tr>
</c:forEach>
</tbody>
</table>
<br>
<p>Here are some of the events in other states:
<table class="table table-dark">
<thead>
<tr>
	<th>Name</th>
	<th>Date</th>
	<th>City</th>
	<th>State</th>
	<th>Host</th>
	<th>Actions</th>
</tr>
</thead>
<tbody>
<c:forEach items="${otherStates}" var="event">
<tr>
	<td><a href="/events/${event.id}">${event.name}</a></td>
	<td><fmt:formatDate value="${ event.date }" pattern="MMM dd, yyyy"/></td>
	<td>${event.city}</td>
	<td>${event.state}
	<td>${event.host.firstName}</td>
	<td>
	<c:choose>
		<c:when test="${event.host.id == user.id}">
		<a href="events/edit/${event.id}">Edit</a>
		<a href="/events/delete/${event.id}">Delete</a>
		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${event.attendees.contains(user)}">
					<span>Joining <a href="/${event.id}/cancel">Cancel</a></span>
				</c:when>
				<c:otherwise>
					<a href="/${event.id}/join">Join</a>
				</c:otherwise>
			</c:choose>
		</c:otherwise>
	</c:choose>
	</td>
</tr>
</c:forEach>
</tbody>
</table>
<br>
<h3>Create An Event</h3>
<div>
	<form:form method="POST" action="/newevent" modelAttribute="event">
	<form:hidden value="${user_id }" path="host"/>
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
		<c:forEach items="${states }" var="state">
			<option value="${state}">${state}</option>
		</c:forEach>
		</form:select>
	</div>
	<button class="btn btn-dark">Create Event</button>
	</form:form>
</div>
</body>
</html>