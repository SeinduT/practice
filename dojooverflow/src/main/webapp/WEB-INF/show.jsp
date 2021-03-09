<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head> <meta charset="ISO-8859-1"> 
<title>Questions</title> 
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script> 
<script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script> 
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div class="container">
<h1>${question.question }</h1>
<h3>Tags:</h3>
<ul>
<c:forEach items="${question.tags}" var="tag">
	<li>${tag.relatedTags}</li>
</c:forEach>
<h3>Add Tag:</h3>
<form:form action="/tags" method="post" modelAttribute="newTag">
	<div class="form-group">
		<form:label path="tag">Answer</form:label>
		<form:errors path="tag"/>
		<form:input path="tag" class="form-control"/>
		<button class="btn btn-primary" type="submit">Add Tag</button>
	</div>
</form:form>
</ul>
<h3>Answers:</h3>
<ul>
<c:forEach items="${ question.relatedAnswers }" var="answer">
	<li>${ answer.relatedAnswers}</li>		
</c:forEach>
</ul>
<h3>Add your answer:</h3>
<form:form action="/answers" method="post" modelAttribute="newAnswer">
	<div class="form-group">
		<form:label path="name">Answer</form:label>
		<form:errors path="name"/>
		<form:input path="name" class="form-control"/>
		<button class="btn btn-primary" type="submit">Submit Answer</button>
	</div>
</form:form>
</div>
</body>
</html>