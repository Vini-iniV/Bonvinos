<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<!-- Required meta tags -->
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

		<!-- Bootstrap CSS -->
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">
		<link rel="stylesheet" href="css/styleLogin.css">
		<title>Bonvinos</title>
		<style>
		h3{
		text-align: center;
		}
		</style>
	</head>
	
	<body>
		<!-- Barra superior com os menus de navegação -->
		<c:import url="MenuInicial.jsp"/>
		
		<img id="img" src="bonvinos.png">
		<h3>Email ou senha incorretos</h3>
	
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>
	
	<!-- Rodape -->
	<c:import url="rodape.jsp"/>
</html>