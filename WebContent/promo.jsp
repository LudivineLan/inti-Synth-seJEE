<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!--     declaration de la taglib -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Promo</title>
<link rel="stylesheet" href="./css/main.css" />
<link rel="stylesheet" href="./css/bootstrap.css" />
</head>
<body>

<section class="container">
		<h1 id="top">Promo</h1>
		
		<form action="PromoServlet">
		<form action="SupprimerPromo">
		
		
		<div class="form-group row">
			<input type="hidden" name="id" value="${id}"/>
			<label for="nomPromo"> Nom Promo</label> <input id="nomPromo" 
				class="form-control" placeholder="Saisir le nom de votre promo" type="text" 
				name="nomPromo" value="${nomPromo}" required/>
		</div>


		<div class="form-group row">
			<label for="effectif"> Effectif</label> <input id="effectif" 
				class="form-control" placeholder="Saisir l'effectif de votre promo" type="number" 
				name="effectif" value="${effectif}"required/>
		</div>

		
			<div class="form-group row" >
				<div class="bas" >
					<button type="submit" name="ajouter" value="Ajouter"class="btn btn-primary">Ajouter</button>
				</div>
			</div>
	
		
		</form>
	</section>
	<section class ="container">
	<h4 id="top">Liste des promos en base de données</h4>
	<table class="table">
		<thead class="thead">
			<tr>
				<th>ID Promo</th>
				<th>Nom de la Promo</th>
				<th>Effectif</th>
				<th>Supprimer</th>
			</tr>
		</thead>
		
		<tbody>
			<!--si le tableau n'est pas vide -->
			<c:if test="${! empty promos}">
				<c:forEach items="${promos}" var="x">
					<tr>
						<td><c:out value="${x.idPromo}"/></td>
						<td><c:out value="${x.nomPromo}"/></td>
						<td><c:out value="${x.effectif}"/></td>
						<!-- passage de parametres par UML -->
						<td><a href="SupprimerPromo?id=${x.idPromo}">supprimer</a></td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	
	</section>

</body>
</html>