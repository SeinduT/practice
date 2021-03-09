<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head> <meta charset="ISO-8859-1"> 
<title>New Question</title> 
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script> 
<script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script> 
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div class="container">
<h1>What is your question?</h1>
<form:form action="/questions/new" method="post" modelAttribute="newQuestion">
	<div class="form-group">
		<form:label path="question">Question: </form:label>
		<form:errors path="question"></form:errors>
		<form:input path="question" class="form-control"/>
	</div>
	<button>Submit</button>
</form:form>
</div>
</body>
</html>