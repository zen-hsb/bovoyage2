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
	
	
	<table class="table">	<!-- class="table table-stripped" -->
	<c:forEach items="${destinations }" var="destination">
	<tr><th>${destination.region }</th>
		<td>${destination.description }</td>
		 <td><img src="images/${destination.images[0]}" alt="${destination.images[0]}"/></td>
		<td><a href="SupprimerDestinationServlet?id=${destination.id }">Supprimer la destination</a></td>
		<td><a href="ModifierDestinationServlet?id=${destination.id }">Modifier la destination</a></td>
		<td><a href="AfficherDatesServlet?id=${destination.id }">Afficher les dates</a></td>
		<td><a href="AjouterImagesServlet?id=${destination.id }">Ajouter une image</a></td>
	</tr>
	</c:forEach>
</table>

</body>
</html>