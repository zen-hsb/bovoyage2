<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form
		action="ModifierDatesVoyageServlet2?id1=${datesvoyages.id}&id2=${destination.id}"
		method="GET" accept-charset="UTF-8">
		<input name="id2" id="id2" size="20" value=${destination.id
			} hidden=""> <input name="id1" id="id1" size="20"
			value=${datesvoyages.id } hidden="">
		<div>
			<label for="dateDepart">Date de depart : </label> <input
				name="dateDepart" id="dateDepart" type="date"/>
		</div>
		<div>
			<label for="dateRetour">Date de retour : </label> <input
				name="dateRetour" id="dateDepart" type="date"/>
		</div>
		<div>
			<label for="prixHT">Prix HT : </label> <input name="prixHT"
				id="prixHT" type="text"/>
		</div>
		<div>
			<label for="nbPlaces">Nombres de places : </label> <input type="number"
			name="nbPlaces" id="nbPlaces" class="champ_non_vide" size="20"
			required/>
		</div>
		<div>
			<input type="submit" value="Modifier la destination" />
		</div>
	</form>
</body>
</html>