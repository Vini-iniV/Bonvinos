<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="model.Cliente" %>
<!DOCTYPE html>

<html lang="pt-BR">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<link rel="stylesheet" href="css/styleCriarEditar.css">
		<title>Bonvinos</title>
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">
	
		<style>
		strong{
		color: #ffffff;
		}
		</style>
	</head>
	
	<body>
		
		<img id="img" src="ClienteCriado.png">
		
		<!-- Container Principal -->
		<div id="main" class="container">
			<h3 class="page-header">Cliente Cadastrado com Sucesso #${cliente.CPF}</h3>
			<div class="row">
				<div class="col-md-4">
					<strong>Nome: ${cliente.nome}</strong>
				</div>
				<div class="col-md-4">
					<strong>Celular: ${cliente.fone}</strong>
				</div>
				<div class="col-md-4">
					<strong>Email: ${cliente.email}</strong>
				</div>
			</div>
			<div id="actions" class="row">
				<div class="col-md-12">
					<a href="index.jsp" class="btn btn-default">Logar</a>
					<a href="ClienteCadastro.jsp" class="btn btn-default">Voltar</a>
				</div>
			</div>
		</div>
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>
	
	<!-- Rodape -->
	<c:import url="rodape.jsp"/>
</html>