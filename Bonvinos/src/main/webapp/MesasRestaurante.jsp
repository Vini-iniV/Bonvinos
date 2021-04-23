<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="model.Mesa" %>

<!doctype html>
<html lang="pt-BR">
	<head>
		<!-- Required meta tags -->
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		
		<!-- Bootstrap CSS -->
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">
		
		<title>Bonvinos</title>
		
		<style>
			html, body {
    			width: 100%;
    			background: #000000 !important;
    			margin: 0 auto;
			}
			h2, h3, h4, th, label{
				color: #ffffff !important;
			}
			td{
				color: #ff0000 !important;
			}
		</style>
	</head>
	
	<!-- Barra superior com os menus de navegação -->
	<c:import url="MenuProprietario.jsp"/>
	<!-- Container principal -->
	<div id="main" class="container">
    	<form action="controller.do" method="post">
    		
			<input type="hidden" name="codRestaurante" value="${restaurante.codRestaurante }" />	
        	
        	<div id="top" class="row">
            	<div class="col-md-3">
                	<h3>Mesas - Restaurante #${restaurante.codRestaurante }</h3>
                        </div>

                        <div class="col-md-6">
                            <div class="input-group h2">
                                <input name="data[search]" class="form-control" id="search" type="text" placeholder="Pesquisar Mesa(deixe vazio para trazer todos)">
                                <span class="input-group-btn">
                				<button class="btn btn-primary" type="submit" name="command" value="ListarMesa">
                    			<span class="glyphicon glyphicon-search"></span>
                                </button>
                                </span>
                            </div>
                        </div>

                        <div class="col-md-3">
                            <a href="controller.do?command=FormularioMesa&codRestaurante=${restaurante.codRestaurante }" class="btn btn-primary pull-right h2">Nova Mesa</a>
                        </div>
                    </div>
                    <!-- /#top -->
                </form>
                <hr />
                <c:if test="${not empty listaMesa}">
                <div id="list" class="row">

                    <div class="table-responsive col-md-12">
                        <table class="table table-striped" cellspacing="0" cellpadding="0">
                            <thead>
                                <tr>
                                    <th>Código</th>
                                    <th>Capacidade</th>
                                    <th>Restaurante</th>
                                    <th class="actions">Ações</th>
                                </tr>
                            </thead>
                            <tbody>
          					<c:forEach var="mesa" items="${listaMesa }">
                                       <tr>
                                            <td>
                                               ${mesa.codMesa }
                                            </td>
                                            <td>
                                                ${mesa.capacidade }
                                            </td>
                                            <td>
                                                ${mesa.codRestaurante }
                                            </td>
                                            <td class="actions">
                                            	<a class="btn btn-danger btn-xs" href="controller.do?command=ExcluirMesa&codMesa=${mesa.codMesa }">Excluir</button>
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
            <!-- /#main -->
            <script src="js/jquery.min.js"></script>
            <script src="js/bootstrap.min.js"></script>
        </body>
</html>