<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="pt-BR">
	<head>
		<!-- Required meta tags -->
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		
		<!-- Bootstrap CSS -->
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">
		
		<link rel="stylesheet" href="css/styleLogin.css">
		<style>
		h3{
		text-align: center;
		}
		</style>
		<title>Bonvinos</title>
	</head>	
	<body>
		<!-- Barra superior com os menus de navegação -->
		<c:import url="MenuCliente.jsp"/>

		<img id="img" src="bonvinos.png">
		
	    <div id="main" class="container">
	        <h3>Bem vindo, por favor selecione uma opção no menu acima</h3>
	    </div>
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>
	<!-- Rodape -->
	<c:import url="rodape.jsp"/>
</html>