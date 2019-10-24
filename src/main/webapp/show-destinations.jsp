<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des destinations disponibles</title>
</head>
<body>
	<h1>Liste des destinations</h1>
	<table>
		<c:forEach items="${destinations}" var="destination">
			<tr>
				<td>${destination.region}</td>
				<td>${destination.description}</td>
			</tr>
		</c:forEach>
	</table>
	

</body>
</html>