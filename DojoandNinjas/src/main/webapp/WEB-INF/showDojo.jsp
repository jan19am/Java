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
	    <title>Dojo Page</title>
	    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
	    <script src="/webjars/jquery/jquery.min.js"></script>
	    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
	   <div class="container">
	   		<div class="title">
	   			<h1><c:out value="${dojo.name}"/> Location Ninjas</h1>
	   		</div>
	   		<div class="body">
	   			<table class="table">
					<tbody>
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Age</th>
						</tr>
						
						<c:forEach var="selectNinja" items="${dojo.ninjas}">
							<tr>
								<td>
									<c:out value="${selectNinja.firstName}"/>
								</td>
								<td>
									<c:out value="${selectNinja.lastName}"/>
								</td>
								<td>
									<c:out value="${selectNinja.age}"/>
								</td>
							</tr>
						</c:forEach>
				</table>
	   		</div>
	   </div>
	</body>
</html>