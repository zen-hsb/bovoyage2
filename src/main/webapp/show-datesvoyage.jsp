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
<h1>Liste des dates de voyage pour ${destination.region}</h1>
<table>

<c:forEach items="${datesvoyages}" var="datesvoyages">
<tr>
<input type="hidden" name="id" id="id" value="${datesvoyages.id }">
<td>Date aller : ${datesvoyages.dateAller}</td>
<td>Date retour : ${datesvoyages.dateRetour}</td>
<td><a href="SupprimerDatesVoyageServlet?id=${destination.id}&id2=${datesvoyages.id}">(X)</a></td>
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