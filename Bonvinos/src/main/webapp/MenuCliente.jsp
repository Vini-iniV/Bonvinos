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

				<a class="navbar-brand" href="ClienteLogado.jsp"><img src="logo.png" class="img-responsive" alt=""></a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li class="nav-item"><a href="AtualizaDadosCliente.jsp">Atualizar Dados</a></li>
					<li class="nav-item"><a href="controller.do?command=ListarRestauranteCliente">Restaurantes disponíveis</a></li>
					<li class="nav-item"><a href="controller.do?command=ListarReservas">Reservas</a></li>
					<li class="nav-item"><a href="controller.do?command=LogoffCliente">Logoff</a></li>
				</ul>
			</div>
		</div>
	</nav>