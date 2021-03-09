<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create new Idea</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div class="container">
	<nav class="navbar navbar-expand-sm bg-light navbar-light">
	  <ul class="navbar-nav ml-auto">
	    <li class="nav-item active">
	      <a class="nav-link" href="/main">Home</a>
	    </li>
	    <li class="nav-item active">
	      <a class="nav-link" href="/logout">Log Out</a>
	    </li>
	  </ul>
	</nav>
	<h1>Update this occasion</h1>
	<hr>
	<form:form action="/main/edit/${person.id}" method="post" modelAttribute="person">
		<form:input type="hidden" value="${ user_id }" path="thisUser" />
		<div class="form-group">
			<form:label path="personName">Name: </form:label>
			<form:errors path="personName"/>
			<form:input class="form-control" path="personName" />
		</div>
				<div class="form-group">
			<form:label path="relation">Relation: </form:label>
			<form:errors path="relation"/>
			<form:input class="form-control" path="relation" />
		</div>
				<div class="form-group">
			<form:label path="occasion">Occasion: </form:label>
			<form:errors path="occasion"/>
			<form:input class="form-control" path="occasion" />
		</div>
				<div class="form-group">
			<form:label path="date">Date: </form:label>
			<form:errors path="date"/>
			<form:input class="form-control" path="date" />
		</div>
				<div class="form-group">
			<form:label path="comments">Comment: </form:label>
			<form:errors path="comments"/>
			<form:input class="form-control" path="comments" />
		</div>
		<button>Update</button>
	</form:form>
</div>
</body>
</html>