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
	    <title>Kickball League Dashboard</title>
	    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
	    <script src="/webjars/jquery/jquery.min.js"></script>
	    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
	   <div class="team-wrapper">
	   		<div class="dashboardHeader">
				<h1>Welcome,  <c:out value="${user.userName}"/></h1>
				<a href="/logout" class="logoutLink">log out</a>
			</div>
			<div class="body">
				<div>
					<table class="table">
						<tbody>
							<tr id="tableheader">
								<th>Team Name</th>
								<th>Skill Level (1-5)</th>
								<th>Game Day</th>
							</tr>
							<c:forEach var="team" items="${teams}">
								<tr>
									<td><a href="/teams/${team.id}">${team.teamName}</a></td>
									<td>${team.skill}</td>
									<td>${team.gameDay}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div>
			    	<a href="/teams/new"><button class="homebutton">Create New Team</button></a>
			    </div>
			</div>
		</div>
	</body>
	</body>
</html>