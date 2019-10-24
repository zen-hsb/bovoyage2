<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modification de la destination ${destination.region}</title>
</head>
<body>
	<form action="ModifierDestinationServlet2" method="POST">
		<div>
			<label for="region">Region : </label> <input name="region"
				id="region" type="text" value="${destination.region}" />
		</div>
		<div>
			<label for="description">Description : </label><br>
			<textarea rows="6" cols="50" id="description" name="description">${destination.description}</textarea>
		</div>
		<div>
			<input type="hidden" name="id" id="id" value="${destination.id }">
		</div>
		<div>
			<input type="submit" value="Modifier la destination"
				href="AfficherDestinationServlet" />
		</div>
	</form>
</body>
</html>