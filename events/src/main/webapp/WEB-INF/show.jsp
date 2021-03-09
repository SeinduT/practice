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
	<h1>${event.name}</h1>
	<label>Host: ${event.host.firstName} ${event.host.lastName }</label>
	<br>
	<label>Date:<fmt:formatDate value="${ event.date }" pattern="MMM dd, yyyy"/></label>
	<br>
	<label>Location: ${event.city}, ${event.state}</label>
	<br>
	<label>People who are attending this event: ${event.attendees.size()}</label>
	<table class="table table-dark">
		<thead>
			<tr>
				<th>Name</th>
				<th>Location</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${event.attendees}" var="user">
			<tr>
				<td>${user.firstName} ${user.lastName}</td>
				<td>${user.city }, ${user.state }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
<div>
<br>
	<h3>Message Wall</h3>
	<div>
		<c:forEach items="${event.messages }" var="message">
			<p>${message.user.firstName } says: ${message.content}</p>
		</c:forEach>
	</div>
	<br>
<form action="/comment/${event.id}" method="POST">
	<div class="form-group">
		<label for="content">Add Comment: </label>
		<span>${error }</span>
		<textarea name="content" id="content"></textarea>
		<button class="btn btn-dark">Submit</button>
	</div>
	</form>
</div>
</body>
</html>