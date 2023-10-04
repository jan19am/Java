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
	    <title>Kickball League</title>
	    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
	    <script src="/webjars/jquery/jquery.min.js"></script>
	    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
	   <div class="index-wrapper">
	   		<div class="index-title">
	   			<h1 class="welcomepage">Welcome!</h1>
	   		</div>
	   		
	   		<div class="index-body">
	   			<div class="registration">
	   				<h2 class="index-header">Register</h2>
	   				<form:form action="/register" method="POST" modelAttribute="newUser">
	   					<div class="form-rows">
			    			<form:errors path="userName" class="text-danger"/>
							<form:label path="userName" class="labelgroup">User Name:</form:label>
							<form:input path="userName" type="text" class="inputs" />
		    			</div>
		    			
	   					<div class="form-rows">
			    			<form:errors path="email" class="text-danger"/>
							<form:label path="email" class="labelgroup">Email:</form:label>
							<form:input path="email" type="text" class="inputs" />
		    			</div>
		    			
	   					<div class="form-rows">
			    			<form:errors path="password" class="text-danger"/>
							<form:label path="password" class="labelgroup">Password:</form:label>
							<form:input path="password" type="password" class="inputs"/>
		    			</div>
		    			
	   					<div class="form-rows">
			    			<form:errors path="confirm" class="text-danger"/>
							<form:label path="confirm" class="labelgroup">Confirm PW:</form:label>
							<form:input path="confirm" type="password" class="inputs"/>
		    			</div>
		    			
		    			<div>
			    			<button class="sub-button">Register</button>
			    		</div>
	   				</form:form>	
	   			</div>
	   			
	   			<div class="log_in">
	   				<h2 class="index-header">Log in</h2>
	   				<form:form action="/login" method="POST" modelAttribute="newLogin">
	   					<div class="form-rows">
			    			<form:errors path="email" class="text-danger"/>
							<form:label path="email" class="labelgroup">Email:</form:label>
							<form:input path="email" type="text" class="inputs"/>
			    		</div>
			    		
			    		<div class="form-rows">
			    			<form:errors path="password" class="text-danger"/>
							<form:label path="password" class="labelgroup">Password:</form:label>
							<form:input path="password" type="password" class="inputs"/>
			    		</div>
			    		
			    		<div>
			    			<button class="sub-button">Log In</button>
			    		</div>
	   				</form:form>
	   			</div>
	   		</div>
	   </div>
	</body>
</html>