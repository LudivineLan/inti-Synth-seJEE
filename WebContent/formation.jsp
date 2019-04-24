<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!--     declaration de la taglib -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulaire d'inscription</title>
<link rel="stylesheet" href="./css/main.css" />
<link rel="stylesheet" href="./css/bootstrap.css" />
</head>
<body>

<section class="container">
		<h1 id="top">Formation</h1>
		
		<form action="FormationServlet">
		<form action="SupprimerFormation">
		
		
		<div class="form-group row">
			<input type="hidden" name="idFormation" value="${id}"/>
			<label for="nomFormation">Nom</label> <input id="nomFormation" 
				class="form-control" placeholder="Saisir votre formation" type="text" 
				name="nomFormation" value="${nomFormation}" required/>
		</div>

	
			<div class="form-group row" >
				<div class="bas" >
					<button type="submit" name="ajouter" value="Ajouter"class="btn btn-primary">Ajouter</button>
				</div>
			</div>
	
		</form>
	</section>
	
	<section class ="container">
	<h4 id="top">Liste des formations en base de données</h4>
	<table class="table">
		<thead class="thead">
			<tr>
				<th>Id Formation</th>
				<th>Nom Formation</th>
				<th>Supprimer</th>
			</tr>
		</thead>
		
		<tbody>
			<!--si le tableau n'est pas vide -->
			<c:if test="${! empty formations}">
				<c:forEach items="${formations}" var="x">
					<tr>
						<td><c:out value="${x.idFormation}"/></td>
						<td><c:out value="${x.nomFormation}"/></td>
						<!-- passage de parametres par UML -->
						<td><a href="SupprimerFormation?id=${x.idFormation}">supprimer</a></td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	
	</section>

</body>
</html>