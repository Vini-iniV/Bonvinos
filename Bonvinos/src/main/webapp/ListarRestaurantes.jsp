<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="pt-BR">

        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            
            <title>Lista - Restaurantes Cadastrados</title>

            <link href="css/bootstrap.min.css" rel="stylesheet">
            <link href="css/style.css" rel="stylesheet">
			
			<style>
			html, body {
    			width: 100%;
    			background: #000000 !important;
    			margin: 0 auto;
			}
			h2, h3, h4, th{
				color: #ffffff !important;
			}
			td{
				color: #ff0000 !important;
			}
			</style>
        </head>

        <body>
            <!-- Barra superior com os menus de navegação -->
			<c:import url="MenuProprietario.jsp"/>
            <!-- Container Principal -->
            <div id="main" class="container">
                <form action="controller.do" method="post">
                    <div id="top" class="row">
                        <div class="col-md-3">
                            <h2>Restaurantes</h2>
                        </div>

                        <div class="col-md-6">
                            <div class="input-group h2">
                                <input name="data[search]" class="form-control" id="search" type="text" placeholder="Pesquisar Restaurante(deixe vazio para trazer todos)">
                                <span class="input-group-btn">
                <button class="btn btn-primary" type="submit" name="command" value="ListarRestaurante">
                    <span class="glyphicon glyphicon-search"></span>
                                </button>
                                </span>
                            </div>
                        </div>

                        <div class="col-md-3">
                            <a href="RestauranteCadastro.jsp" class="btn btn-primary pull-right h2">Novo Restaurante</a>
                        </div>
                    </div>
                    <!-- /#top -->
                </form>
                <hr />
                <c:if test="${not empty lista}">
                <div id="list" class="row">

                    <div class="table-responsive col-md-12">
                        <table class="table table-striped" cellspacing="0" cellpadding="0">
                            <thead>
                                <tr>
                                    <th>Código</th>
                                    <th>Nome</th>
                                    <th>Rua</th>
                                    <th>Número</th>
                                    <th>CEP</th>
                                    <th>Telefone</th>
                                    <th>Proprietário</th>
                                    <th>LatLong</th>
                                    <th class="actions">Ações</th>
                                </tr>
                            </thead>
                            <tbody>
          					<c:forEach var="restaurante" items="${lista }">
                                       <tr>
                                            <td>
                                               ${restaurante.codRestaurante }
                                            </td>
                                            <td>
                                                ${restaurante.nome }
                                            </td>
                                            <td>
                                                ${restaurante.enderecoRua }
                                            </td>
                                            <td>
                                                ${restaurante.enderecoNumero }
                                            </td>
                                            <td>
                                                ${restaurante.enderecoCEP }
                                            </td>
                                            <td>
                                                ${restaurante.fone }
                                            </td>
                                            <td>
                                                ${restaurante.proprietarioCNPJ }
                                            </td>
                                            <td>
                                                ${restaurante.latitude }, ${restaurante.longitude }
                                            </td>
                                            <td class="actions">
                                                <a class="btn btn-success btn-xs" href="controller.do?command=VisualizarRestaurante&codRestaurante=${restaurante.codRestaurante }">Visualizar</a>
                                                <a class="btn btn-warning btn-xs" href="controller.do?command=EditarRestaurante&codRestaurante=${restaurante.codRestaurante }">Editar</a>
                                            	<a class="btn btn-danger btn-xs"  href="controller.do?command=ExcluirRestaurante&codRestaurante=${restaurante.codRestaurante }">Excluir</a>
                                            	<a class="btn btn-success btn-xs" href="controller.do?command=MesasRestaurante&codRestaurante=${restaurante.codRestaurante }">Mesas</a>
                                            	<a class="btn btn-success btn-xs" href="controller.do?command=LatLongCadastro&codRestaurante=${restaurante.codRestaurante }">LatLong</a>
                                            	<a class="btn btn-success btn-xs"  href="controller.do?command=ListarReservasProprietario&codRestaurante=${restaurante.codRestaurante }">Reservas</a>
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
		<!-- Rodape -->
		<c:import url="rodape.jsp"/>
</html>