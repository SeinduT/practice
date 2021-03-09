<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head> <meta charset="ISO-8859-1"> 
<title>Question Dashboard</title> 
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script> 
<script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script> 
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div class="container">
	<h1>Questions Dashboard</h1>
	<table class="table">
	  <thead class="thead-dark">
	    <tr>
	      <th>Question</th>
	      <th>Answer</th>
	      <th>Tags</th>
	    </tr>
	  </thead>
	  <tbody>
	  <c:forEach items="${questions}" var="question">
	    <tr>
	      <td><a href="/questions/${question.id}">${question.question}</a></td>
	      <td><c:forEach items="${question.relatedAnswers}" var="answer">${answer.answer}</c:forEach></td>
	      <td><c:forEach items="${question.tags}" var="tag">${tag.tag}</c:forEach></td>
	    </tr>
	   </c:forEach>
	  </tbody>
	</table>
<a href="/questions/new">Add New Question</a>
</div>
</body>
</html>