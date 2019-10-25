<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des destinations</title>
</head>
<body>
<h2>Recherche de destinations</h2>
<form action="AfficherDestinationServlet" method="POST">
<button type="submit">Voir la liste des destinations</button>
</form>
<form action="AfficherDatesVoyageServlet">
<button type="submit">Voir la liste des dates</button>
</form>

</body>
</html>