<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <!--     declaration de la taglib -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulaire stagiaire</title>
<link rel="stylesheet" href="./css/main.css" />
<link rel="stylesheet" href="./css/bootstrap.css" />
</head>

<body>

<section class="container">
		<h1 id="top">Formulaire d'inscription</h1>
		
		<form action="StagiaireServlet">
		<form action="SupprimerServlet">
		
		
		<div class="form-group row">
			<input type="hidden" name="id" value="${id}"/>
			<label for="nom"> Nom</label> <input id="nom" 
				class="form-control" placeholder="Saisir votre nom" type="text" 
				name="nom" value="${nom}" required/>
		</div>

		<div class="form-group row">
			<label for="prenom"> Prenom</label> <input id="prenom" 
				class="form-control" placeholder="Saisir votre prénom" type="text" 
				name="prenom" value="${prenom}" required/>
		</div>

		<div class="form-group row">
			<label for="age"> Age</label> <input id="age" 
				class="form-control" placeholder="Saisir votre age" type="number" 
				name="age" value="${age}"required/>
		</div>

	
		
			<div class="form-group row" >
				<div class="bas" >
					<button type="submit" name="ajouter" value="Ajouter"class="btn btn-primary">Ajouter</button>
				</div>
			</div>
	
		
		</form>
	</section>
	<section class ="container">
	<h4 id="top">Liste des stagiaires en base de données</h4>
	<table class="table">
		<thead class="thead">
			<tr>
				<th>ID</th>
				<th>Nom</th>
				<th>Prenom</th>
				<th>Age</th>
				<th>Supprimer</th>
			</tr>
		</thead>
		
		<tbody>
			<!--si le tableau n'est pas vide -->
			<c:if test="${! empty stagiaires}">
				<c:forEach items="${stagiaires}" var="x">
					<tr>
						<td><c:out value="${x.idStagiaire}"/></td>
						<td><c:out value="${x.nom}"/></td>
						<td><c:out value="${x.prenom}"/></td>
						<td><c:out value="${x.age}"/></td>
						<!-- passage de parametres par UML -->
						<td><a href="SupprimerServlet?id=${x.idStagiaire}">supprimer</a></td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	
	</section>
</body>
</html>