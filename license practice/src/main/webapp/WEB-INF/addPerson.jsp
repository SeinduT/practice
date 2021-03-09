<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Person</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

</head>
<body>
<h1>New Person</h1>
<div class="container">
<form:form method="POST" action="/addNewPerson" modelAttribute="person">
<div class="form-group">
<form:label path="firstName">First Name:
<form:errors path="firstName"/>
<form:input path="firstName"/>
</form:label>
</div>
<div class="form-group">
<form:label path="lastName">Last Name:
<form:errors path="lastName"/>
<form:input path="lastName"/>
</form:label>
</div>
<button>Create</button>

</form:form>

</div>
</body>
</html>