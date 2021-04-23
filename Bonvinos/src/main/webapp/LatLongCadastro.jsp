<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-BR">

	<head>
    	<meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Bonvinos - Cadastro LatLong</title>
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
			
			<h3 class="page-header">Cadastrar LatLong - Restaurante #${restaurante.codRestaurante }</h3>
			<form action="controller.do" method="post">
				
				<input type="hidden" name="codRestaurante" value="${restaurante.codRestaurante }" />
				<input type="hidden" name="nomeRestaurante" value="${restaurante.nome }" />
				<input type="hidden" name="descricaoRestaurante" value="${restaurante.descricao }" />
				<input type="hidden" name="enderecoRuaRestaurante" value="${restaurante.enderecoRua }" />
				<input type="hidden" name="enderecoNumeroRestaurante" value="${restaurante.enderecoNumero }" />
				<input type="hidden" name="enderecoCEPRestaurante" value="${restaurante.enderecoCEP }" />
				<input type="hidden" name="telefoneRestaurante" value="${restaurante.fone }" />
				<input type="hidden" name="ProprietarioCNPJ" value="${restaurante.proprietarioCNPJ }" />
				
				<div class="row">			
					<div class="form-group col-md-6 text-center">
						<label for="latitude">Latitude</label>
						<input type="text" class="form-control" name="latitude" id="latitude" required maxlength="100" placeholder="Insira a latitude" value=${restaurante.latitude } />
					</div>
					<div class="form-group col-md-6 text-center">
						<label for="longitude">Longitude</label>
						<input type="text" class="form-control" name="longitude" id="longitude" required maxlength="100" placeholder="Insira a longitude" value=${restaurante.longitude } />
					</div>					
				</div>
				<hr/>
				<div id="actions" class="row">
					<div class="form-group col-md-12 text-center">
						<button type="submit" class="btn btn-primary" name="command" value="ManterLatLong">Atualizar LatLong</button>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-12 text-center">
						<a class="dropdown-item" href="EncontrarRestaurante.jsp">Descobrir latitude e longitude</a>
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