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
	    <title>New Ninja</title>
	    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
	    <script src="/webjars/jquery/jquery.min.js"></script>
	    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div>
	   		<div class="container">
				<h1>New Ninja</h1>
			</div>
			
			<div class="body">
				<form:form action="/ninja/new" method="POST" modelAttribute="ninja">
					<div>
						<form:label path="dojo">Dojo:</form:label>
						<form:select path="dojo">
		        			<c:forEach var="selectDojo" items="${dojos}">
		            			<form:option value="${selectDojo.id}" path="dojo">
		            				<c:out value="${selectDojo.name}"/>
		            			</form:option>
		        			</c:forEach>
		    			</form:select>
		    		</div>
		    		
		    		<div>
		    			<form:errors path="firstName" class="text-danger"/>
						<form:label path="firstName">First Name:</form:label>
						<form:input path="firstName" type="text" />
		    		</div>
		    		
		    		<div>
		    			<form:errors path="lastName" class="text-danger"/>
						<form:label path="lastName">Last Name:</form:label>
						<form:input path="lastName" type="text"/>
		    		</div>
		    		
		    		<div>
		    			<form:errors path="age" class="text-danger"/>
						<form:label path="age">Age:</form:label>
						<form:input path="age" type="number"/>
		    		</div>
		    		
		    		<div>
		    			<button class="create">Create</button>
		    		</div>
				</form:form>
			</div>
		</div>
	</body>
</html>