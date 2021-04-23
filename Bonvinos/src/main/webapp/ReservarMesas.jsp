<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="model.Mesa" %>
<%@page import="model.Restaurante" %>

<!DOCTYPE html>
	<html lang="pt-BR">

        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            
            <title>Bonvinos - Reservas</title>

            <link href="css/bootstrap.min.css" rel="stylesheet">
            <link href="css/style.css" rel="stylesheet">
			
			<style>
			
			html, body {
    			width: 100%;
    			background: #000000 !important;
    			margin: 0 auto;
			}
			h3, h4, th{
				color: #ffffff !important;
			}
			td{
				color: #ff0000 !important;
			}
			</style>
        </head>

        <body>
            <!-- Barra superior com os menus de navegação -->
			<c:import url="MenuCliente.jsp"/>
			<!-- Container principal -->
			<div id="main" class="container">
				<form action="controller.do" method="post">
				
					<input type="hidden" name="nomeRestaurante" value="${restaurante.nome }" />
					<input type="hidden" name="descricaoRestaurante" value="${restaurante.descricao }" />
					<input type="hidden" name="codRestaurante" value="${restaurante.codRestaurante }" />
		        	<div id="top" class="row">
		           		<div class="col-md-4">
		               		<h3>Restaurante ${restaurante.nome }</h3>
		       	    	</div>
		            	<div class="col-md-6">
                            <div class="input-group h2">
                                <input name="data[search]" class="form-control" id="search" type="text" placeholder="Pesquisar Mesa(deixe vazio para trazer todos)">
                                <span class="input-group-btn">
                				<button class="btn btn-primary" type="submit" name="command" value="ListarMesasDisponiveis">
                    			<span class="glyphicon glyphicon-search"></span>
                                </button>
                                </span>
                            </div>
                        </div>
		        	</div>
		        </form>
		        <div id="top" class="row">
		            <div class="col-md-12">
		              	<h4>${restaurante.descricao }</h4>
		            </div>
	            </div>
	            <div id="top" class="row">
		            <div class="col-md-12">
		              	<h4>Mesas Disponíveis</h4>
		            </div>
	            </div>
		        <c:if test="${not empty listaMesasDisponiveis}">
		        	<div id="list" class="row">
		
		            	<div class="table-responsive col-md-12">
		                	<table class="table table-striped" cellspacing="0" cellpadding="0">
		                    	<thead>
		                        	<tr>
		                            	<th>Mesa</th>
		                                <th>Capacidade</th>
		                                <th class="actions">Ações</th>
		                            </tr>
		                        </thead>
		                        <tbody>
		          					<c:forEach var="mesa" items="${listaMesasDisponiveis }">
		                            	<tr>
		                    	            <td>
		                  	                  ${mesa.codMesa }
		                                    </td>
		                                    <td>
		                                      ${mesa.capacidade }
		                                    </td>
		                                    <td class="actions">
		                          	        	<a class="btn btn-success btn-xs" href="controller.do?command=ConfirmarCPFReserva&codMesa=${mesa.codMesa }&codRestaurante=${mesa.codRestaurante }">Reservar</button>
		                                    </td>
		                                </tr>
		                            </c:forEach>
		                        </tbody>
		                    </table>
		                </div>
		            </div>
		            <!-- /#list -->
		
		            <div id="bottom" class="row">
		                <div class="col-md-12">
		                    <!-- paginação ainda não foi implementada -->
		                    <ul class="pagination">
		                        <li class="disabled"><a>&lt; Anterior</a>
		                        </li>
		                        <li class="disabled"><a>1</a>
		                        </li>
		                        <li><a href="#">2</a>
		                        </li>
		                        <li><a href="#">3</a>
		                        </li>
		                        <li class="next"><a href="#" rel="next">Próximo &gt;</a>
		                        </li>
		                    </ul>
		                    <!-- /.pagination -->
		                </div>
		            </div>
		        </c:if>
		        <!-- /#bottom -->
		    </div>
			<script src="js/jquery.min.js"></script>
    		<script src="js/bootstrap.min.js"></script>
    	</body>
		<!-- Rodape -->
		<c:import url="rodape.jsp"/>
	</html>