<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
						<span class="sr-only">Menu de navegação superior</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>

					<a class="navbar-brand" href="ProprietarioLogado.jsp"><img src="logo.png" class="img-responsive" alt=""></a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav navbar-right">
						<li class="nav-item"><a href="ListarRestaurantes.jsp">Restaurantes</a></li>
						<li class="nav-item"><a href="RestauranteCadastro.jsp">Novo Restaurante</a></li>
						<li class="nav-item"><a href="AtualizaDadosProprietario.jsp">Atualizar Dados</a></li>
						<li class="nav-item"><a href="controller.do?command=LogoffProprietario">Logoff</a></li>
					</ul>
				</div>
			</div>
		</nav>