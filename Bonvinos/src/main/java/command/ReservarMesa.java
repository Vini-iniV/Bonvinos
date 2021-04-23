package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Restaurante;
import service.RestauranteService;

public class ReservarMesa implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pLatitude = request.getParameter("latitude");
		String pLongitude = request.getParameter("longitude");
		
		Restaurante restaurante = new Restaurante();
		restaurante.setLatitude(pLatitude);
		restaurante.setLongitude(pLongitude);
		
		RestauranteService rs = new RestauranteService();
		restaurante = rs.comparaLatLongs(restaurante.getLatitude(), restaurante.getLongitude());
		
		RequestDispatcher view = null;
		
		request.setAttribute("restaurante", restaurante);
		
		view = request.getRequestDispatcher("ReservarMesas.jsp");
		view.forward(request, response);

	}
}
