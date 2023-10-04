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
							<th>Actions</th>
						</tr>
						<c:forEach var="expense" items="${expenses}">
							<tr>
								<td><a href="http://localhost:8080/expense/${expense.id}">${expense.expenseName}</a></td>
								<td>${expense.vendor}</td>
								<td>$${expense.amount}</td>
								<td class="actions">
									<a href="http://localhost:8080/expense/edit/${expense.id}">edit</a>
									<form action="/expense/${expense.id}" method="post">
    									<input type="hidden" name="_method" value="delete">
    									<button class="delete">delete</button>
									</form>
								</td>
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
						<div class="inputgroup">
							<form:errors path="expenseName" class="text-danger"/>
							<form:label path="expenseName">Expense Name:</form:label>
							<form:input path="expenseName" type="text" />
						</div>
						
						<div class="inputgroup">
							<form:errors path="vendor" class="text-danger"/>
							<form:label path="vendor">Vendor:</form:label>
							<form:input path="vendor" type="text" />
						</div>
							
						<div class="inputgroup">
							<form:errors path="amount" class="text-danger"/>
							<form:label path="amount">Amount:</form:label>
							<form:input path="amount" type="number" step="0.01"/>
						</div>
						
						<div class="inputgroup">
							<form:errors path="description" class="text-danger"/>
							<form:label path="description">Description:</form:label>
							<form:textarea path="description"></form:textarea>
						</div>

						<div class="button">
							<button class="submit">submit</button>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</body>
</html>