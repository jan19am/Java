<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Share</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/style.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="addbook-wrapper">
		<div class="addbook-title">
			<h1>Add a Book to Your Shelf!</h1>
			<a href="http://localhost:8080/books">back to the shelves</a>
		</div>
		<div class="addbook-body">
			<form:form action="/books/create" method="POST" modelAttribute="book">
				<form:input type="hidden" path="user" value="${userId}" />
				<div class="form-rows">
					<form:errors path="title" class="text-danger" />
					<form:label path="title" class="labelgroup">Title</form:label>
					<form:input path="title" type="text" class="inputs" />
				</div>

				<div class="form-rows">
					<form:errors path="author" class="text-danger" />
					<form:label path="author" class="labelgroup">Author</form:label>
					<form:input path="author" type="text" class="inputs" />
				</div>

				<div class="form-rows">
					<form:errors path="myThoughts" class="text-danger" />
					<form:label path="myThoughts" class="labelgroup">My Thoughts</form:label>
					<form:textarea path="myThoughts" class="inputs-textarea"></form:textarea>
				</div>

				<div class="addbook-button">
					<button class="submit">submit</button>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>