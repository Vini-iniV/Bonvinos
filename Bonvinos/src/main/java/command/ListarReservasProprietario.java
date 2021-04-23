package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Reserva;
import model.Restaurante;
import service.ReservaService;

public class ListarReservasProprietario implements Command{
	
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String pCodRestaurante = request.getParameter("codRestaurante");
		String chave = request.getParameter("data[search]");
		
		int codRestaurante = -1;
		
		try {
			codRestaurante = Integer.parseInt(pCodRestaurante);
		} catch(NumberFormatException e) {
			
		}
		
		Restaurante restaurante = new Restaurante();
		restaurante.setCodRestaurante(codRestaurante);
		
		ReservaService rs = new ReservaService();
		ArrayList<Reserva> listaReservaProprietario = null;
		HttpSession session = request.getSession();

		if (chave != null && chave.length() > 0) {
			listaReservaProprietario = rs.listarReservasProprietario(chave, codRestaurante);
		} else {
			listaReservaProprietario = rs.listarReservasProprietario(codRestaurante);
		}
		session.setAttribute("listaReservaProprietario", listaReservaProprietario);
		session.setAttribute("restaurante", restaurante);
		

		RequestDispatcher dispatcher = request
		.getRequestDispatcher("ListarReservasProprietario.jsp");
		dispatcher.forward(request, response);
	}
}
