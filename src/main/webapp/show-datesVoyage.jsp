<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des dates de voyage disponibles pour la destination </title>	<%-- ${destination.region } --%>
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
	
	

<a href="index.jsp">Retour</a>
	
	
	<table>
<c:forEach items="${dates_voyages }" var="dates">
		<tr><td>${dates_voyages }</td>
		
			<td>${destination.dateDepart}</td>
			<td>${destination.dateRetour}</td>
			<td>${destination.prixHT}</td>
			<td>${destination.nbrePlaces}</td>
		
			<td><form action="AfficherDatesVoyageServlet?id=${dates_voyages.id }" method="POST" accept-charset="UTF-8"> 

<button type="submit">Afficher les dates</button>
</form> 
		
		
		</tr>
		</c:forEach>
</table>		
<br>

<h3>Afficher les dates</h3>

	
	
-----------------------------	
<h2>Affichage des images</h2>
<form action="ImageFilter" method="POST">
<img src="images/birmanie_1.jpg" width="150" />
</form>

<%-- <table class="table">	<!-- class="table table-stripped" -->
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
</table> --%>











-----------------------------
<h3>Ajouter une date</h3>
<form action="AjouterDatesVoyageServlet?id2=${destination.id }" method="POST">		<!-- accept-charset="UTF-8" -->
<%-- <input name="id2" id="id2" size="20" value=${destination.id } hidden=""> --%>
Date départ	:		<input name="dateDepart" type="date" id="dateDepart" size="20" placeholder="Entrez la date de Depart">
<br>
Date retour	:		<input name="dateRetour" type="date" id="dateRetour" size="20" placeholder="Entrez la date de Retour">
<br>
Prix HT	:			<input name="prixHt" id="prixHt" size="20" placeholder="Entrez le prix HT">
<br>
Nombre de places :	<input name="nbrePlaces" id="nbrePlaces" size="20" placeholder="Entrez le nombre de places disponibles pour ce voyage">
<br>
<button type="submit">Ajouter une date</button>
</form>

<br>
-----------------------------
<br>
<a href="index.jsp">Retour à la page d'accueil</a><br>
<a href="AfficherDestinationServlet">Voir toutes les destinations</a>


</body>
</html>