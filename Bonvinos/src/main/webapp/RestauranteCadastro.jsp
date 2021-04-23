<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="model.Restaurante" %>
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
		<c:import url="MenuProprietario.jsp"/>
		
		<img id="img" src="novoRestauranteC.png">
		
		<div id="main" class="container">
			<form action="controller.do" method="post">
			
				<input type="hidden" name="latitude" value="${restaurante.latitude }" />
				<input type="hidden" name="longitude" value="${restaurante.longitude }" />
				
				<div class="row">
					<div class="form-group col-md-12">
						<label for="nome">Nome</label>
						<input type="text" class="form-control" name="nome" id="nome" required maxlength="100" placeholder="Nome do Restaurante"/>
					</div>				
				</div>
				<div class="row">
					<div class="form-group col-md-4">
						<label for="email">Descrição</label>
						<input type="text" class="form-control" name="descricao" id="descricao" required maxlength="500" placeholder="Conte um pouco sobre seu negócio"/>
					</div>
					<div class="form-group col-md-4">
						<label for="celular">Telefone</label>
						<input type="tel" class="form-control" name="fone" id="fone" required maxlength="20" placeholder="(XX) XXXX-XXXX"/>
					</div>
					<div class="form-group col-md-4">
						<label for="CNPJ">CNPJ do Proprietário</label>
						<input type="text" class="form-control" name="CNPJ" id="CNPJ" required maxlength="18" placeholder="XX.XXX.XXX/XXXX-XX"/>
					</div>		
				</div>
				<div class="row">			
					<div class="form-group col-md-4">
						<label for="enderecoRua">Endereço/Rua</label>
						<input type="text" class="form-control" name="enderecoRua" id="enderecoRua" required maxlength="100" placeholder="Rua/Av XXX"/>
					</div>
					<div class="form-group col-md-4">
						<label for="enderecoNumero">Endereço/Número</label>
						<input type="text" class="form-control" name="enderecoNumero" id="enderecoNumero" required maxlength="100" placeholder="XX"/>
					</div>
					<div class="form-group col-md-4">
						<label for="enderecoCEP">Endereço/CEP</label>
						<input type="text" class="form-control" name="enderecoCEP" id="enderecoCEP" required maxlength="9" placeholder="XXXXX-XXX"/>
					</div>						
				</div>
				<h5>*Após o cadastro de seu restaurante, não se esqueça de cadastrar suas coordenadas</h5>
				<div id="actions" class="row">
					<div class="md-col-12">
						<button type="submit" class="btn btn-primary" name="command" value="ManterRestaurante">Cadastrar</button>
						<a href="RestauranteCadastro.jsp" class="btn btn-default">Limpar</a>
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