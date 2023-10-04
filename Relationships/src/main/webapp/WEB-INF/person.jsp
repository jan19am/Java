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
	    <title>New Person</title>
	    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
	    <script src="/webjars/jquery/jquery.min.js"></script>
	    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="container">
			<div class="title">
				<h1>New Person</h1>
			</div>
			<div class="body">
				<form:form action="/person/new" method="POST" modelAttribute="person">
					<div class="inputgroup">
						<form:errors path="firstName" class="text-danger"/>
						<form:label path="firstName">First Name:</form:label>
						<form:input path="firstName" type="text" />
					</div>
						
					<div class="inputgroup">
						<form:errors path="lastName" class="text-danger"/>
						<form:label path="lastName">Last Name:</form:label>
						<form:input path="lastName" type="text" />
					</div>

					<div class="button">
						<button class="create">Create</button>
					</div>
				</form:form>
			</div>
		</div>
	</body>
</html>