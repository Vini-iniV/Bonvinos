package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Mesa;
import model.Reserva;
import service.MesaService;
import service.ReservaService;

public class ManterReserva implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pCodRestaurante = request.getParameter("codRestaurante");
		String pCodMesa = request.getParameter("codMesa");
		String pCPF = request.getParameter("cpf");
		
		int codRestaurante = -1;
		int codMesa = -1;
		int cpf = -1;
		
		try {
			codRestaurante = Integer.parseInt(pCodRestaurante);
			codMesa = Integer.parseInt(pCodMesa);
			cpf = Integer.parseInt(pCPF);
		} catch (NumberFormatException e) {

		}
		
		//instanciar o javabean
		Reserva reserva = new Reserva();
		reserva.setCodMesaReservada(codMesa);
		reserva.setCodRestauranteReserva(codRestaurante);
		reserva.setClienteCPF(cpf);
		
		//instanciar o javabean/mesa
		Mesa mesa = new Mesa();
		mesa.setCodMesa(codMesa);
		
		//instanciar o service
		ReservaService rs = new ReservaService();
		rs.criar(reserva);
		
		//Atualizar mesa para ocupada
		MesaService ms = new MesaService();
		ms.atualizarDisponibilidade(mesa);
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		ArrayList<Reserva> listaReserva = new ArrayList<>();
		listaReserva.add(reserva);
		session.setAttribute("listaReserva", listaReserva);
		view = request.getRequestDispatcher("ListarReservasCliente.jsp");
		
		view.forward(request, response);
	}

}
