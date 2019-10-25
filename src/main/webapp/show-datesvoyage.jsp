<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des dates pour ${destination.region}</title>
</head>
<body>
<h2>Créer de nouvelles dates de voyage pour la destination ${destination.region } :</h2>

<form id="form_1" action="AjouterDatesVoyageServlet?id=${destination.id}" method="GET" accept-charset="UTF-8">

<input name="id2" id="id2" size="20" value=${destination.id } hidden="">
Date de départ<input type="date" name="dateDepart" id="dateDepart" size="20" required></br>
Date de retour<input type="date" name="dateRetour" id="dateRetour" size="20" required></br>
Prix HT<input type="text" name="prixHT"  min="0" id="prixHT" class="champ_non_vide" size="20" placeholder="prix Hors Taxe" required></br>
Nombre de places Dispo<input type="number" name="nbPlaces" id="nbPlaces" class="champ_non_vide" size="20" required></br>
<button type="submit">Créer les dates</button>

</form>

<h2>Dates pour la destination ${destination.region } :</h2>
<table>
<c:forEach items="${datesvoyages}" var="datesvoyages">
		<tr><td>Date n°${datesvoyages.id }</td></tr>
		<tr><td>Date de départ:${datesvoyages.dateAller}</td></tr>
		<tr><td>Date de retour:${datesvoyages.dateRetour}</td></tr>
		<tr><td>Prix hors taxes:${datesvoyages.prixHT}</td></tr>
		<tr><td>Nombre de places dispo:${datesvoyages.nbrePlaces}</td></tr>
		<tr><td><a href="SupprimerDatesVoyageServlet?id1=${datesvoyages.id}&id2=${destination.id}">Supprimer cette date</a></td></tr>
		<tr><td><a href="ModifierDatesVoyageServlet1?id1=${datesvoyages.id}&id2=${destination.id}">Modifier cette date</a></td></tr>
		</c:forEach>
</table>
</body>
</html>