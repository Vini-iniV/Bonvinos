package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Reserva;
import service.ReservaService;

public class ListarReservas implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String chave = request.getParameter("data[search]");
		
		ReservaService rs = new ReservaService();
		ArrayList<Reserva> listaReserva = null;
		HttpSession session = request.getSession();

			if (chave != null && chave.length() > 0) {
				listaReserva = rs.listarReservas(chave);
			} else {
				listaReserva = rs.listarReservas();
			}
			session.setAttribute("listaReserva", listaReserva);
		

		RequestDispatcher dispatcher = request
		.getRequestDispatcher("ListarReservasCliente.jsp");
		dispatcher.forward(request, response);
	}

}
