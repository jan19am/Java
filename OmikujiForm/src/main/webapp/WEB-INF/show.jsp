<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>This Is Your Fortune!</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/style.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="title">
			<h2>Here's Your Omikuji!</h2>
		</div>
		<div class="body1">
			<div class="row2">
				<p class="fortune">
					In
					<c:out value="${num}" />
					years, you will live in
					<c:out value="${city}" />
					with
					<c:out value="${person}" />
					as your roommate,
					<c:out value="${hobby}" />
					for a living. The next time you see a
					<c:out value="${noun}" />, 
					you will have good luck. Also,
					<c:out value="${comment}" />
				</p>
			</div>
			<div>
				<a href="http://localhost:8080">Go Back</a>
			</div>	
		</div>
	</div>	
</body>
</html>