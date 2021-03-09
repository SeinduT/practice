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
	<h1>Create a new idea</h1>
	<hr>
	<form:form action="/ideas/new" method="post" modelAttribute="idea">
		<form:input type="hidden" value="${ user_id }" path="creator" />
		<div class="form-group">
			<form:label path="ideaName">Content: </form:label>
			<form:errors path="ideaName"/>
			<form:input class="form-control" path="ideaName" />
		</div>
		<button>Create</button>
	</form:form>
	<a href="/logout">Log Out</a>
</div>
</body>
</html>