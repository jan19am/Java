<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fruity Loops</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/style.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<h1>Fruit Store</h1>
		<table class="table">
			<tbody>
				<tr>
					<th>Name</th>
					<th>Price</th>
				</tr>
				<c:forEach var="fruit" items="${fruits}">
					<tr>
						<td>${fruit.name}</td>
						<td>${fruit.price}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>