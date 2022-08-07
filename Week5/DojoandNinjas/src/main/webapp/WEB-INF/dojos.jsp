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
	    <title>New Dojo</title>
	    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
	    <script src="/webjars/jquery/jquery.min.js"></script>
	    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
	   <div class="container">
			<div class="title">
				<h1>New Dojo</h1>
			</div>
			
			<div class="body">
				<form:form action="/dojo/new" method="POST" modelAttribute="dojo">
					<div class="display">
						<form:errors path="name" class="text-danger"/>
						<form:label path="name">Name:</form:label>
						<form:input path="name" type="text" />
					</div>
					
					<div class="button">
						<button class="create">Create</button>
					</div>
				</form:form>
			</div>
			
			<div>
				<table>
					<tbody>
						<tr>
							<th>Dojos</th>
						</tr>
						<c:forEach var="dojo" items="${dojos}">
							<tr>
								<td>
									<a href="/dojos/${dojo.id}">
										${dojo.name}
									</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</body>
</html>