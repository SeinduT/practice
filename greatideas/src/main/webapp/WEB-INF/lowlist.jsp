<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Ideas Page</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
	<a href="/logout">Log Out</a>
<div class="container">
	<h1>Welcome ${ user.name }</h1>
	<h3>Ideas</h3>
	<a href="/lowLikes">Low Likes</a> | <a href="/highLikes">High Likes</a>
	<hr>
	<table class="table table-gray table-hover">
		<thead>
			<tr>
				<th>Idea</th>
				<th>Created By</th>
				<th>Likes</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${ideas}" var="idea">
			<tr>
				<td><a href="/ideas/${idea.id}">${idea.ideaName}</a></td>
				<td>${idea.creator.name}</td>
				<td>${idea.likedby.size()}</td>
				<td>
					<c:choose>
						<c:when test="${idea.likedby.contains(user)}">
							<a href="/ideas/${idea.id}/unLike">Unlike</a>
						</c:when>
						<c:otherwise>
							<a href="/ideas/${idea.id}/like">Like</a>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<button onclick="location.href='/ideas/new'" type="button">Create an idea</button>
</div>
</body>
</html>