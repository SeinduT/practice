<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dog Detail Page</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

</head>
<body>

<div class="container">
<h1>Details For ${dog.name}</h1>
<hr>

<h3>Name: </h3>
<p>${dog.name}</p>
<h3>Breed: </h3>
<p>${dog.breed}</p>
<c:choose>
<c:when test="${dog.tag != null }">
<h3>City: </h3>
<p>${dog.tag.city}</p>
<h3>State: </h3>
<p>${dog.tag.state}</p>
</c:when>
<c:otherwise>
<form:form method="POST" action="/addTag" modelAttribute="tag">
<div class="form-group">
	<form:label path="city">City:
	<form:errors path="city"/>
	<form:input path="city"/></form:label>
 </div>
 <div class="form-group">
	<form:label path="state">State:
	<form:errors path="state"/>
	<form:input path="state"/></form:label>
 </div>
 <form:hidden path="dog" value="${dog.id}"/>
 <button>Register This Pet</button>
 </form:form>
 
</c:otherwise>
</c:choose>
<form method="post" action="/edit/${dog.id}">
<hr>
<h2>Edit Dog</h2>
<form:form method="POST" action="/addNewDog" modelAttribute="dog">
<div class= "form-group">
<form:label path="name">Name:
<form:errors path="name"/>
<form:input path="name"/></form:label>
 </div>
 <div class= "form-group">
<form:label path="breed">Breed:
<form:errors path="breed"/>
<form:input path="breed"/></form:label>
 </div>
 <div class= "form-group">
<form:label path="age">Age:
<form:errors path="age"/>
<form:input path="age"/></form:label>
 </div>
 <button>Update Dog Details</button>
</form:form>

</form>

</div>
</body>
</html>