<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des destinations disponibles</title>
</head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css">
<body>
	<header class="container">
		<div class="container">
			<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
				<a class="navbar-brand" href="#">Navbar</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarTogglerDemo03"
					aria-controls="navbarTogglerDemo03" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>


				<div class="collapse navbar-collapse" id="navbarTogglerDemo03">
					<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
						<li class="nav-item"><a class="nav-link" href="index.jsp">Accueil
								<span class="sr-only">(current)</span>
						</a></li>
						<li class="nav-item active"><a class="nav-link"
							href="AfficherDestinationServlet">Liste des destinations</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Créer
								une destination</a></li>
					</ul>
				</div>
			</nav>
		</div>
	</header>
	<h1>Liste des destinations</h1>
	<div class="container">
		<div class="card-group">
			<c:forEach items="${destinations}" var="destination">
				<div class="card">
					<div id="carouselExampleSlidesOnly" class="carousel slide"
						data-ride="carousel">
						<div class="carousel-inner">
							<div class="carousel-item active">
								<img class="card-img-top" src="images/Papeete1.jpg"
									alt="First slide">
							</div>
							<div class="carousel-item">
								<img class="card-img-top" src="images/Papeete2.jpg"
									alt="Second slide">
							</div>
							<div class="carousel-item">
								<img class="card-img-top" src="images/Papeete3.jpg"
									alt="Third slide">
							</div>
						</div>
					</div>
					<!-- On peut mettre dans le card un carousel pour nos images -->
					<div class="card-body">
						<h5 class="card-title">${destination.region}</h5>
						<p class="card-text">${destination.description}</p>
						<p class="card-text">
							<small class="text-muted"><a
								href="ModifierDestinationServlet1?id=${destination.id}">Modifier
									la destination</a></small></br>
							<small class="text-muted"><a
								href="SupprimerDestinationServlet?id=${destination.id}">Supprimer
									la destination</a></small></br>
							<small class="text-muted"><a
								href="AfficherDatesVoyageServlet?id=${destination.id}">Afficher
									les dates de voyage</a></small>		
						</p>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
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
				<input type="submit" value="Créer une destination"
					formaction="AjouterDestinationServlet" />
			</div>
		</form>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
</html>