<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="model.Cliente" %>

<!doctype html>
<html lang="pt-BR">
	<head>
		<!-- Required meta tags -->
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

		<link rel="stylesheet" href="css/styleCriarEditar.css">
		<!-- Bootstrap CSS -->
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">

	<title>Bonvinos</title>
	</head>	
	<body>
	
		<!-- Barra superior com os menus de navegação -->
		<c:import url="MenuCliente.jsp"/>
		
		<img id="img" src="AtualizaDadosClienteC.png">
		
		<div id="main" class="container">
			<form action="controller.do" method="post">
				<div class="row">
					<div class="form-group col-md-12">
						<label for="nome">Nome</label>
						<input type="text" class="form-control" name="nome" id="nome" required maxlength="100" placeholder="Nome Completo" value=${cliente.nome }/>
					</div>				
				</div>
				<div class="row">
					<div class="form-group col-md-3">
						<label for="email">Email</label>
						<input type="email" class="form-control" name="email" id="email" required maxlength="100" placeholder="qualquer@dominio.com" value=${cliente.email }/>
					</div>				
					<div class="form-group col-md-3">
						<label for="senha">Senha</label>
						<input type="password" class="form-control" name="senha" id="senha" required maxlength="100" placeholder="Usada para logar" value=${cliente.senha }/>
					</div>
					<div class="form-group col-md-3">
						<label for="CPF">CPF</label>
						<input type="text" class="form-control" name="CPF" id="CPF" required maxlength="14" placeholder="XXX.XXX.XXX-XX" value=${cliente.cpf }/>
					</div>
					<div class="form-group col-md-3">
						<label for="celular">Celular</label>
						<input type="tel" class="form-control" name="fone" id="fone" required maxlength="20" placeholder="(XX) XXXX-XXXX" value=${cliente.fone }/>
					</div>					
				</div>
				<div id="actions" class="row">
					<div class="md-col-12">
						<button type="submit" class="btn btn-primary" name="command" value="AtualizaCliente">Atualizar</button>
						<a href="AtualizaDadosCliente.jsp" class="btn btn-default">Limpar</a>
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