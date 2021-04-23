package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Restaurante;
import service.RestauranteService;

public class LatLongCadastro implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String pCodRestaurante = request.getParameter("codRestaurante");
		
		int codRestaurante = -1;
		
		try {
			codRestaurante = Integer.parseInt(pCodRestaurante);
		} catch (NumberFormatException e) {

		}
		
		//instanciar o javabean
		Restaurante restaurante = new Restaurante();
		restaurante.setCodRestaurante(codRestaurante);
		
		RestauranteService rs = new RestauranteService();
		RequestDispatcher view = null;
			
		restaurante = rs.carregar(restaurante.getCodRestaurante());
		request.setAttribute("restaurante", restaurante);
		view = request.getRequestDispatcher("LatLongCadastro.jsp");
		view.forward(request, response);
	}	
}
