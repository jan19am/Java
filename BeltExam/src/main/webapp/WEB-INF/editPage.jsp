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
	<title>Edit Team</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="/css/style.css">
	<!-- change to match your file/naming structure -->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="wrapper">
			<div class="title">
				<h1>Edit Team</h1>
				<a href="/home">dashboard</a>
			</div>
			<div class="addTeamBody">
				<form:form action="/teams/${team.id}" method="POST" modelAttribute="team">
					
					<div class="form-rows">
						<form:errors path="teamName" class="text-danger" />
						<form:label path="teamName" class="labelgroup">Team Name</form:label>
						<form:input path="teamName" type="text" class="inputs" />
					</div>
	
					<div class="form-rows">
						<form:errors path="skill" class="text-danger" />
						<form:label path="skill" class="labelgroup">Skill Level (1-5)</form:label>
						<form:input path="skill" type="number" min="1" max="5" class="inputs" />
					</div>
	
					<div class="form-rows">
						<form:errors path="gameDay" class="text-danger" />
						<form:label path="gameDay" class="labelgroup">Game Day</form:label>
						<form:input path="gameDay" type="text" class="inputs-textarea" />
					</div>
					
					<div class="form-row">
						<form:errors path="user" class="error"/>
						<form:input type="hidden" path="user" value="${user.id}" class="form-control"/>
						<input type="hidden" name="_method" value="put"/>
					</div>
	
					<div class="addTeam-button">
						<button class="submit">Submit</button>
					</div>
				</form:form>
				<form action="/teams/${team.id}" method="POST">
					<input type="hidden" name="_method" value="delete"/>
					<input type="submit" value="delete" class="btn_btn-danger" />
				</form>
			</div>
		</div>
	</body>
</html>