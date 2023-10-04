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
	    <title>New License</title>
	    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
	    <script src="/webjars/jquery/jquery.min.js"></script>
	    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div>
			<div>
				<h1>New License</h1>
			</div>
			<div class="container">
				<form:form action="/license/new" method="POST" modelAttribute="license">
					<div>
						<form:label path="person">Person:</form:label>
						<form:select path="person">
		        			<c:forEach var="onePerson" items="${persons}">
		            <!--- Each option VALUE is the id of the person --->
		            			<form:option value="${onePerson.id}" path="person">
		            <!--- This is what shows to the user as the option --->
					                <c:out value="${onePerson.firstName}"/>
					                <c:out value="${onePerson.lastName}"/>
		            			</form:option>
		        			</c:forEach>
		    			</form:select>
		    		</div>
		    		<div>
		    			<form:errors path="state" class="text-danger"/>
						<form:label path="state">State:</form:label>
						<form:input path="state" type="text" />
		    		</div>
		    		<div>
		    			<form:errors path="expirationDate" class="text-danger"/>
						<form:label path="expirationDate">Exp Date:</form:label>
						<form:input path="expirationDate" type="date"/>
		    		</div>
		    			<button class="create">Create</button>
		    		<div>
		    			
		    		</div>
				</form:form>
			</div>
		</div>
	</body>
</html>