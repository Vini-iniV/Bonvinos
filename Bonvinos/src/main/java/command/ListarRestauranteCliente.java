package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Restaurante;
import service.RestauranteService;

public class ListarRestauranteCliente implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RestauranteService rs = new RestauranteService();
		
		ArrayList<Restaurante> listaRestaurante = rs.listarRestaurantes();
		
		request.setAttribute("listaRestaurante", listaRestaurante);
		
		request.getRequestDispatcher("mapa4.jsp").forward(request, response);

	}

}
