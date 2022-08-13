<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
	    <meta charset="UTF-8">
	    <title>Read Share</title>
	    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
	    <script src="/webjars/jquery/jquery.min.js"></script>
	    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
	   <div class="books-wrapper">
	   		<div class="header">
		   		<div class="leftHeader">
					<h1>Welcome, <c:out value="${user.userName}"/></h1>
					<p>Book's from everyone's shelves:</p>
				</div>
				<div class="rightHeader">
					<a href="http://localhost:8080/" class="booklinks">logout</a>
					<a href="http://localhost:8080/books/new" class="booklinks">+ Add a book to my shelf!</a>
				</div>
			</div>
			<div class="body">
				<table class="table">
					<tbody>
						<tr id="tableheader">
							<th>ID</th>
							<th>Title</th>
							<th>Author Name</th>
							<th>Posted By</th>
						</tr>
						<c:forEach var="book" items="${books}">
							<tr>
								<td>${book.id}</td>
								<td><a href="http://localhost:8080/books/${book.id}">${book.title}</a></td>
								<td>${book.author}</td>
								<td>${book.user.userName}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</body>
</html>