<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="model.Restaurante" %>
<!DOCTYPE html>
<html lang="pt-BR">

        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Bonvinos - Nova Mesa</title>
			
			<link rel="stylesheet" href="css/styleLogin.css">
            <link href="css/bootstrap.min.css" rel="stylesheet">
            <link href="css/style.css" rel="stylesheet">

		<style>
		h3{
			color: #ffffff;
			text-align: center;
		}
		</style>
        </head>
		<body>
			<!-- Barra superior com os menus de navegação -->
			<c:import url="MenuProprietario.jsp"/>
			
			<div id="main" class="container">
				<h3 class="page-header">Nova Mesa - Restaurante #${restaurante.codRestaurante }</h3>
				<form action="controller.do" method="post">
				
					<input type="hidden" name="codRestaurante" value="${restaurante.codRestaurante }" />
					
					<div class="row">
						<div class="form-group col-md-12 text-center">
							<label for="capacidade">Capacidade</label>
							<input type="text" class="form-control" name="capacidade" id="capacidade" required maxlength="100" placeholder="Quantidade de pessoas suportada pela mesa"/>
						</div>			
					</div>
					<div id="actions" class="row">
						<div class="md-col-12 text-center">
							<button type="submit" class="btn btn-primary" name="command" value="ManterMesa">Cadastrar</button>
							<a href="ListarRestaurantes.jsp" class="btn btn-default">Voltar</a>
						</div>
					</div>
				</form>
			</div>
			<script src="js/jquery.min.js"></script>
            <script src="js/bootstrap.min.js"></script>
		</body>
		<!-- Rodape -->
		<c:import url="rodape.jsp"/>
</html>