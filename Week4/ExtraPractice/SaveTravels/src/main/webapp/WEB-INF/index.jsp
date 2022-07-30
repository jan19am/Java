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
    <title>Save Travels</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
	<body>
		<div class="wrapper">
		   <div class="container">
				<h1>Save Travels</h1>
				<table class="table">
					<tbody>
						<tr>
							<th>Expense</th>
							<th>Vendor</th>
							<th>Amount</th>
						</tr>
						<c:forEach var="expense" items="${expenses}">
							<tr>
								<td>${expense.expenseName}</td>
								<td>${expense.vendor}</td>
								<td>$${expense.amount}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="container2">
				<div class="title">
					<h2>Add an expense:</h2>
				</div>
				<div class="body">
					<form:form action="/expense/new" method="POST" modelAttribute="expense">
						<div>
							<form:errors path="expenseName" class="text-danger"/>
							<form:errors path="vendor" class="text-danger"/>
							<form:errors path="amount" class="text-danger"/>
							<form:errors path="description" class="text-danger"/>
						</div>
					
						<div class="inputgroup">
							<form:label path="expenseName">Expense Name:</form:label>
							<form:input path="expenseName" type="text" />
						</div>
						
						<div class="inputgroup">
							<form:label path="vendor">Vendor:</form:label>
							<form:input path="vendor" type="text" />
						</div>
							
						<div class="inputgroup">
							<form:label path="amount">Amount:</form:label>
							<form:input path="amount" type="number" />
						</div>
						
						<div class="inputgroup">
							<form:label path="description">Description:</form:label>
							<form:textarea path="description"></form:textarea>
						</div>

						<div class="button">
							<button>submit</button>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</body>
</html>