<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="pt-BR">
	<head>
		<!-- Required meta tags -->
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		
		<link rel="stylesheet" href="css/styleLogin.css">
		<!-- Bootstrap CSS -->
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">
	
	<style>
		h3{
			color: #ffffff;
		}
	</style>
		
	<title>Bonvinos</title>
	</head>	
	<body>
		<img alt="" src="logoNovo.png">
		<div id="main" class="container">
			<h3 class="page-header text-center">Login - Proprietários</h3>
			<form action="controller.do" method="post">
				<div class="row">
					<div class="form-group col-md-12 text-center">
						<label for="email">Email</label>
						<input type="email" class="form-control" name="email" id="email" required maxlength="100" placeholder="O mesmo digitado na tela de cadastro"/>
					</div>				
				</div>
				<div class="row">
					<div class="form-group col-md-12 text-center">
						<label for="senha">Senha</label>
						<input type="password" class="form-control" name="senha" id="senha" required maxlength="100" placeholder="**********"/>
					</div>				
				</div>
				
				<div class="row">
					<div class="form-group col-md-12 text-center">
						<button type="submit" class="btn btn-primary btn-lg btn-block" name="command" value="LoginProprietario">Login</button>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-12 text-center">
						<a class="dropdown-item" href="ProprietarioCadastro.jsp">Não possuo cadastro</a>
					</div>				
				</div>
				<div class="row">
					<div class="form-group col-md-12 text-center">
						<a class="dropdown-item" href="index.jsp">Sou cliente</a>
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