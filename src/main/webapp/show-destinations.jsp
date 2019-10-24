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
				<td><a href="SupprimerDestinationServlet?id=${destination.id}">(X)</a></td>
				<td><a href="ModifierDestinationServlet1?id=${destination.id}">Modifier
						la destination</a>
			</tr>
		</c:forEach>

	</table>
	<h2>-----------------------------------------------------------------------------</h2>
	<div class="container">
		<form action="" method="POST">
			<div>
				<label for="region">Region : </label> <input name="region"
					id="region" type="text" placeholder="Region de votre destination" />
			</div>
			<div>
				<label for="description">Description : </label><br>
				<textarea rows="6" cols="50" id="description" name="description"></textarea>
			</div>
			<div>
				<input type="hidden" name="id" id="id" value="${destination.id }">
			</div>
			<div>
				<input type="submit" value="Créer une destination" formaction="AjouterDestinationServlet"/>
			</div>
		</form>
	</div>
</body>
</html>