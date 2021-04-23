package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Restaurante;
import service.RestauranteService;

public class ListarRestaurante implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String chave = request.getParameter("data[search]");
		
		RestauranteService rs = new RestauranteService();
		ArrayList<Restaurante> lista = null;
		HttpSession session = request.getSession();

			if (chave != null && chave.length() > 0) {
				lista = rs.listarRestaurantes(chave);
			} else {
				lista = rs.listarRestaurantes();
			}
			session.setAttribute("lista", lista);
		

		RequestDispatcher dispatcher = request
		.getRequestDispatcher("ListarRestaurantes.jsp");
		dispatcher.forward(request, response);


	}
}
