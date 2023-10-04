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
<title>Project Manager Dashboard</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/style.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="books-wrapper">
		<div class="header">
			<div>
				<h1>
					Welcome,
					<c:out value="${user.userName}" />
				</h1>
				<p>All Projects</p>
			</div>
			<div>
				<a href="/logout" class="">logout</a>
			</div>
			<div class="button">
				<a href="/projects/new"><button class="create">+ new
						project</button></a>
			</div>
		</div>
		<div class="body">
			<table class="table">
				<tbody>
					<tr id="tableheader">
						<th>Project</th>
						<th>Team Lead</th>
						<th>Due Date</th>
						<th>Actions</th>
					</tr>
					<c:forEach var="project" items="${projects}">
						<tr>
							<td>${project.title}</td>
							<td>
								<c:forEach var="user" items="${project.users}">
									${user.userName}
								</c:forEach>
							</td>
							<td><fmt:formatDate pattern="MMM dd" value="${project.date}" /></td>

							<td><a href="/join/${project.id}">Join team</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div>
				<p>Your Projects</p>
			</div>
			<%-- <input type="hidden" path="project" value="${projectId}" /> --%>
			<form action="/add" method="post">
			<input type="hidden" name="projectId" value="${projectId}" /> 
				<table class="table">
					<tbody>
						<tr id="tableheader">
							<th>Project</th>
							<th>Lead</th>
							<th>Due Date</th>
							<th>Actions</th>
						</tr>						
						
							<tr>
							<c:forEach var="project" items="${myprojects}">
								<td>${project.title}</td>
								<td><fmt:formatDate pattern="MMM dd" value="${project.date}" /></td>
								<td><a href=#>Leave team</a></td>
							</c:forEach>
							</tr>
						
					</tbody>
					</table>
			</form>
		</div>
	</div>
</body>
</body>
</html>