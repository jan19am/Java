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
	    <title>Title</title>
	    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
	    <script src="/webjars/jquery/jquery.min.js"></script>
	    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
	   <div class="wrapper">
	   		<div class="title">
	   			<h1>Create a Project</h1>
	   		</div>
	   		<div class="output">
	   			<form:form action="/projects" method="POST" modelAttribute="project">

					<div class="inputgroup">
						<form:errors path="title" class="text-danger"/>
						<form:label path="title">Project Title:</form:label>
						<form:input path="title" type="text" />
					</div>
							
					<div class="inputgroup">
						<form:errors path="description" class="text-danger"/>
						<form:label path="description">Project Description:</form:label>
						<form:textarea path="description"></form:textarea>
					</div>
								
					<div class="inputgroup">
						<form:errors path="date" class="text-danger"/>
						<form:label path="date">Due Date:</form:label>
						<form:input path="date" type="date"/>
					</div>
							
					<div>
						<form:errors path="users" class="error"/>
						<form:input type="hidden" path="users" value="${users.id}"/>
					</div>
	
					<div class="button">
						<button class="submit">submit</button>
					</div>
				</form:form>
	   		</div>
   		</div>
	</body>
</html>