<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des destinations</title>
</head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<body>

<h2>Recherche de destinations</h2>
<form action="AfficherDestinationServlet" method="POST">
<button type="submit">Voir la liste des destinations</button>
</form>
<form action="DateServlet">
<button type="submit">Voir la liste des dates</button>
</form>
</body>
</html>