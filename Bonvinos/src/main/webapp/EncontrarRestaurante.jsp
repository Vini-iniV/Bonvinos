<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
  <head>
    <title>Bonvinos Geocode Service</title>
    	<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<title>Bonvinos</title>
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <style>
      /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
      #map {
		  width: 100%;
		  height: 550px;
      }
      /* Optional: Makes the sample page fill the window. */
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
        background: #000000 !important;
      }
      #floating-panel {
        position: absolute;
        top: 50px;
        left: 35%;
        z-index: 5;
        background-color: #fff;
        padding: 5px;
        border: 1px solid #999;
        text-align: center;
        font-family: 'Roboto','sans-serif';
        line-height: 30px;
        padding-left: 10px;
      }
    </style>
  </head>
<body>
   <!-- import do menu -->
   <c:import url="MenuProprietario.jsp"/>
   
   <div id="floating-panel">
     <input id="address" type="text" placeholder= "Insira o endereço do restaurante">
     <input id="submit" type="button" value="Encontrar Geocode Restaurante">
   </div>
   <div id="map"></div>

<script>
  var map;
  function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
      zoom: 12,
      center: {lat: -23.550, lng: -46.633}
    });
    var geocoder = new google.maps.Geocoder();
      document.getElementById('submit').addEventListener('click', function() {
      geocodeAddress(geocoder, map);
    });
  }
  
  function geocodeAddress(geocoder, resultsMap) {
    var address = document.getElementById('address').value;
    geocoder.geocode({'address': address}, function(results, status) {
      if (status === 'OK') {
        resultsMap.setCenter(results[0].geometry.location);
        var marker = new google.maps.Marker({
          map: resultsMap,
          position: results[0].geometry.location         
        });
        var latlng = results[0].geometry.location
        alert('LatLng do Endereco: ' + address + ' ' + latlng);
      } else {
        alert('Geocode falhou devido ao seguinte erro: ' + status);
      }
    });
  }
</script>

 <script async defer
 src="https://maps.googleapis.com/maps/api/js?key=INSERIR_KEY_AQUI&callback=initMap">
 </script>
   	
</body>

	<!-- Rodape -->
	<c:import url="rodape.jsp"/>
</html>