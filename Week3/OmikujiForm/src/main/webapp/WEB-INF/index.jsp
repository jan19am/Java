<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Omikuji</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/style.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="title">
			<h2>Send an Omikuji!</h2>
		</div>
		<div class="body">
			<form class="wrapper" action="/retrieve" method="POST">
				<div class="row">
					<label>Pick any number from 5 to 25:</label>
					<input class="pickanumber"type="number" name="num" min="5" max="25">
				</div>
				
				<div class="row">
					<label>Enter the name of any city:</label>
					<input type="text" name="city"> 
				</div>
				
				<div class="row">
					<label>Enter the name of any real person:</label>
					<input type="text" name="person">
				</div>
				
				<div class="row">
					<label>Enter professional endeavor or hobby:</label>
					<input type="text" name="hobby"> 
				</div>
				
				<div class="row">
					<label>Enter any type of living thing:</label>
					<input type="text" name="noun">
				</div>
				
				<div class="row">
					<label>Say something nice to someone:</label>
					<textarea name="comment" cols="20" rows="3"></textarea>
				</div>
				
				<div class="row1">
					<p>Send and show a friend</p>
				</div>
				
				<div class="button">
					<button>submit</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>