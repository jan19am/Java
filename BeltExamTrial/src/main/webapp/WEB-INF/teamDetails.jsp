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
	    <title>Team Details</title>
	    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
	    <script src="/webjars/jquery/jquery.min.js"></script>
	    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
	   <div class="wrapper">
	   		<div class="title">
				<h1><c:out value="${team.teamName}"/></h1>
				<a href="/home">dashboard</a>
			</div>
			<div class="body">
				<p>Team Name: <c:out value="${team.teamName}"/></p>
				<p>Skill Level: <c:out value="${team.skill}"/></p>
				<p>Game Day: <c:out value="${team.gameDay}"/></p>	
			</div>
			<div>
				<p>Players:</p>
				<c:forEach var="player" items="${players}">
					<p>${player.playerName}</p>
				</c:forEach>
			</div>
			<div>
				<h4>Add Player:</h4>
			</div>
			<div>
				<form:form action="/players/${team.id}" method="POST" modelAttribute="player">
					<div class="form-row">
						<form:errors path="team" class="error"/>
						<form:input type="hidden" path="team" value="${team.id}" class="form-control"/>
						<!-- <input type="hidden" name="_method" value="put"/> -->
					</div>
					<%-- <div class="form-row">
						<form:input type="hidden" name="_method" value="${team.teamName}" path="teamName"/>
						<form:input type="hidden" name="_method" value="${team.skill}" path="skill"/>
						<form:input type="hidden" name="_method" value="${team.gameDay}" path="gameDay"/>
					</div> --%>
					<div class="form">
						<form:errors path="playerName" class="text-danger" />
						<form:label path="playerName" class="label-detail">Player Name</form:label>
						<form:input path="playerName" type="text" class="input-detail" />
					</div>
					
					<div class="addTeam-button">
						<button class="submit">Submit</button>
					</div>
				</form:form>
			</div>
			<div>
				<a href="/edit/${team.id}">edit</a>
			</div>
			<form action="/teams/${team.id}" method="POST">
				<input type="hidden" name="_method" value="delete"/>
				<input type="submit" value="delete" class="btn_btn-danger" />
			</form>
			
	   </div>
	</body>
</html>