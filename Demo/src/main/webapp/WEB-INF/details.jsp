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
    <title>Expense Details</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
   <div class="wrapper">
   		<div class="title">
   			<h1>Expense Details</h1>
   			<a class="hyperlink" href="http://localhost:8080/expense">Go back</a>
   		</div>
   		<div class="output">
   			<div class="listedItem">
   				<p class="titleDescription">Expense Name:</p>
   				<p><c:out value="${expenseItem.expenseName}"></c:out></p>
   			</div>
   			
   			<div class="listedItem">
   				<p class="titleDescription">Expense Description:</p>
   				<p><c:out value="${expenseItem.description}"></c:out></p>
   			</div>
   			
   			<div class="listedItem">
   				<p class="titleDescription">Vendor:</p>
   				<p><c:out value="${expenseItem.vendor}"></c:out></p>
   			</div>
   			
   			<div class="listedItem">
   				<p class="titleDescription">Amount spent:</p>
   				<p>$<c:out value="${expenseItem.amount}"></c:out></p>
   			</div>	
   		</div>
   </div>
</body>
</html>