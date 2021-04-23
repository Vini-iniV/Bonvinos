<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="model.Restaurante" %>
<%@page import="service.RestauranteService" %>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<title>Bonvinos</title>
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">
	</head>
	
	<style>
		body{
			background: #000000;
		}
		button{
			color: #000000;
		}
		h4{
			text-align: center;
			color: #ffffff;
		}
	</style>
	
	<body>
	
		<!-- import do menu -->
		<c:import url="MenuCliente.jsp" />
		<h4>
			Precisamos de sua autorização para usarmos sua localização <button onclick="getLocation()">Autorizar</button>
		</h4>
	
		<div id="mapholder"></div>
		<script src="http://maps.google.com/maps/api/js?sensor=false"></script>
		<script>
			var x = document.getElementById("demo");
			
			//Pega a localização do usuario
			function getLocation() {
	  			if(navigator.geolocation) {
	    			navigator.geolocation.getCurrentPosition(novaFuncao,showError);
	    		}
	  			else{x.innerHTML = "Geolocalização não suportada";}
	  		}
	
			function novaFuncao(position) {
				//Faz a conversão da localizaçao para latlong
				lat=position.coords.latitude;
				lon=position.coords.longitude;
				latlon=new google.maps.LatLng(lat, lon)
				
				//Configuraçoes do mapa
				var myOptions={
					center:latlon,zoom:12,
					mapTypeId:google.maps.MapTypeId.ROADMAP,
					mapTypeControl:false,
					navigationControlOptions:{style:google.maps.NavigationControlStyle.SMALL}
				};
				
				//Tamanho do mapa
				mapholder=document.getElementById('mapholder')
				mapholder.style.height='520px';
				mapholder.style.width= '1366px';
				
				//Instancia o mapa
				var map = new google.maps.Map(document.getElementById("mapholder"), myOptions);
				
				//Cria o marcador na localizacao do usuario
				var usuarioMarcador = new google.maps.Marker({
					position:latlon,
					map:map,
					title: 'Você está aqui!'
				});
				
				//Pega a imagem personalizada para adicionar ao marcador
				var iconBase = 'http://maps.google.com/mapfiles/kml/pal2/icon32.png';
				
				//Cria o marcador personalizado dos restaurantes
				<c:forEach var="restaurante" items="${listaRestaurante }">
					var restaurante = {
						lat: ${restaurante.latitude}, 
						lng: ${restaurante.longitude}
					};
					
					var marker = new google.maps.Marker({
						position:restaurante,
						icon:iconBase,
						map:map,
						title: 'Clique para saber mais'
					});
					
					marker.addListener('click', function() { 
						onMarkerClick.call(marker);
					});
					
					function onMarkerClick() {
			            //go to the url
			            window.location.href = 'http://localhost:8080/PIMesa/controller.do?command=ReservarMesa&latitude=${restaurante.latitude }&longitude=${restaurante.longitude }';
			        };
				</c:forEach>
			}
	 		
			//Caso ocorra algum erro, exibe
			function showError(error) {
	  			switch(error.code) {
				    case error.PERMISSION_DENIED:
				      x.innerHTML="Usuário rejeitou a solicitação de geolocalização."
				      break;
				    case error.POSITION_UNAVAILABLE:
				      x.innerHTML="Localização indisponível."
				      break;
				    case error.TIMEOUT:
				      x.innerHTML="O tempo da requisição expirou."
				      break;
				    case error.UNKNOWN_ERROR:
				      x.innerHTML="Algum erro desconhecido aconteceu."
				      break;
			    }
			  }
	
		</script>
	
		<script async defer
			src="https://maps.googleapis.com/maps/api/js?key=INSERIR_KEY_AQUI&callback=initMap">
	 	</script>
	
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>
	<!-- Rodape -->
	<c:import url="rodape.jsp"/>
</html>