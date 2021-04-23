<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="pt-BR">

        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Bonvinos - Visualizar Restaurante</title>

            <link href="css/bootstrap.min.css" rel="stylesheet">
            <link href="css/style.css" rel="stylesheet">
            
            <style>
			html, body {
    			width: 100%;
    			background: #000000 !important;
    			margin: 0 auto;
			}
			h2, h3, h4, strong, div{
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
                    <h3 class="page-header">Visualizar Restaurante #${restaurante.codRestaurante }</h3>
                    <div class="row">
						<div class="col-md-4">
							<strong>Nome:</strong>		
							${restaurante.nome}
						</div>
						<div class="col-md-4">
							<strong>Descricao:</strong>
							${restaurante.descricao}
						</div>
						<div class="col-md-4">
							<strong>Telefone:</strong>		
							${restaurante.fone}
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<strong>Endereço:</strong>		
							${restaurante.enderecoRua}
						</div>
						<div class="col-md-4">
							<strong>Número:</strong>
							${restaurante.enderecoNumero}
						</div>
						<div class="col-md-4">
							<strong>CEP:</strong>
							${restaurante.enderecoCEP}
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<strong>Proprietário</strong>
							${restaurante.proprietarioCNPJ}
						</div>
					</div>
                    <hr />
                    <div id="actions" class="row">
                        <div class="col-md-12">
                            <a href="controller.do?command=EditarRestaurante&codRestaurante=${restaurante.codRestaurante }" class="btn btn-primary">Editar</a>
                            <a class="btn btn-danger"  href="controller.do?command=ExcluirRestaurante&codRestaurante=${restaurante.codRestaurante }">Excluir</a>
                            <a href="ListarRestaurantes.jsp" class="btn btn-default">Voltar</a>
                        </div>
                    </div>
                </div>
                <script src="js/jquery.min.js"></script>
                <script src="js/bootstrap.min.js"></script>
        </body>

        </html>