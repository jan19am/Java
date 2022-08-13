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
	    <title>Book Details</title>
	    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
	    <script src="/webjars/jquery/jquery.min.js"></script>
	    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
	   <div class="wrapper">
		   	<div class="header">
		   		<div>
		   			<h1 class="bookDetailsTitle">
		   				<c:out value="${bookItem.title}"/>
		   			</h1>
		   		</div>
		   		
		   		<div>
		   			<a href="http://localhost:8080/books">back to the shelves</a>
		   		</div>
		   	</div>
		   	<div class="midBody">
		   		<h5 class="read">
		   			<span class="book-user"><c:out value="${bookItem.user.userName}"/></span> read 
		   			<span class="book-title"><c:out value="${bookItem.title}"/></span> by 
		   			<span class="book-author"><c:out value="${bookItem.author}"/></span>
		   		</h5>
		   		<h5 class="thoughts">
		   			Here are <c:out value="${bookItem.user.userName}"/>'s thoughts:
		   		</h5>
		   	</div>
		   	<div class="lowerBody">
		   		<c:out value="${bookItem.myThoughts}"/>
		   	</div>
	   </div>
	</body>
</html>