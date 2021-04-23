<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="model.Mesa" %>
<!doctype html>
<html lang="pt-BR">
	<head>
		<!-- Required meta tags -->
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

		<!-- Bootstrap CSS -->
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">

	<title>Bonvinos</title>
	</head>	
	<body>
		<!-- Barra superior com os menus de navegação -->
		<c:import url="MenuProprietario.jsp"/>
		
		<div id="main" class="container">
			<h3 class="page-header">Editar Mesa #${mesa.codMesa }</h3>
			<form action="controller.do" method="post">
				
				<input type="hidden" name="codRestaurante" value="${mesa.codRestaurante }" />
				<input type="hidden" name="codMesa" value="${mesa.codMesa }" />
				
				<div class="row">
					<div class="form-group col-md-12">
						<label for="capacidade">Capacidade</label>
						<input type="text" class="form-control" name="capacidade" id="capacidade" required maxlength="100" placeholder="Quantidade de pessoas suportada pela mesa" value=${mesa.capacidade }/>
					</div>			
				</div>
				<div id="actions" class="row">
					<div class="md-col-12">
						<button type="submit" class="btn btn-primary" name="command" value="AlterarMesa">Salvar</button>
						<a href="ListarMesas.jsp" class="btn btn-default">Cancelar</a>
					</div>
				</div>
			</form>
		</div>
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>