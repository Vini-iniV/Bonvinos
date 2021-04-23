<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="model.Restaurante" %>
<!DOCTYPE html>

<html lang="pt-BR">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<title>Bonvinos</title>
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">
	</head>
	
	<body> 
		<!-- Barra superior com os menus de navegação -->
		<c:import url="MenuProprietario.jsp"/>
		
		<!-- Container Principal -->
		<div id="main" class="container">
			<h3 class="page-header">Restaurante Cadastrado com Sucesso #${restaurante.codRestaurante}</h3>
			<div class="row">
				<div class="col-md-4">
					<strong>Nome</strong>		
					${restaurante.nome}
				</div>
				<div class="col-md-8">
					<strong>Descricao</strong>
					${restaurante.descricao}
				</div>
			</div>
			<div class="row">
				<div class="col-md-4">
					<strong>Endereço</strong>		
					${restaurante.enderecoRua}
				</div>
				<div class="col-md-4">
					<strong>Endereço/Número</strong>
					${restaurante.enderecoNumero}
				</div>
				<div class="col-md-4">
					<strong>Restaurante/CEP</strong>
					${restaurante.enderecoCEP}
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<strong>Telefone</strong>		
					${restaurante.fone}
				</div>
				<div class="col-md-6">
					<strong>Proprietário</strong>
					${restaurante.proprietarioCNPJ}
				</div>
			</div>
			<hr/>
			<div id="actions" class="row">
				<div class="col-md-12">
					<a href="RestauranteCadastro.jsp" class="btn btn-default">Voltar</a>
				</div>
			</div>
		</div>
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>