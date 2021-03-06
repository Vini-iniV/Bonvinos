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
import model.Restaurante;
import service.MesaService;
import service.ReservaService;

public class ExcluirReservaProprietario implements Command{
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String pCodReserva = request.getParameter("codReserva");
		String pCodMesa = request.getParameter("codMesa");
		String pCodRestaurante = request.getParameter("codRestaurante");
		
		int codReserva = -1;
		int codMesa = -1;
		int codRestaurante = -1;
		
		try {
			codReserva = Integer.parseInt(pCodReserva);
			codMesa = Integer.parseInt(pCodMesa);
			codRestaurante = Integer.parseInt(pCodRestaurante);
		} catch (NumberFormatException e) {

		}
		//Instancia o restaurante
		Restaurante restaurante = new Restaurante();
		restaurante.setCodRestaurante(codRestaurante);
		//Instancia a mesa
		Mesa mesa = new Mesa();
		mesa.setCodMesa(codMesa);
		
		//Instancia o service para atualizar o status de mesa ocupada
		MesaService ms = new MesaService();
		ms.atualizarOcupacao(mesa);
		
		//Apos liberar a mesa,
		//instancia o javabean
		Reserva reserva = new Reserva();
		reserva.setCodReserva(codReserva);
		
		ReservaService rs = new ReservaService();
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		rs.excluir(reserva.getCodReserva());
		ArrayList<Reserva> listaReserva = (ArrayList<Reserva>)session.getAttribute("listaReservaProprietario");
		listaReserva.remove(busca(reserva, listaReserva));
		session.setAttribute("listaReservaProprietario", listaReserva);
		session.setAttribute("restaurante", restaurante);
		view = request.getRequestDispatcher("ListarReservasProprietario.jsp");			
		
		view.forward(request, response);

	}

	public int busca(Reserva reserva, ArrayList<Reserva> listaReserva) {
		Reserva to;
		for(int i = 0; i < listaReserva.size(); i++){
			to = listaReserva.get(i);
			if(to.getCodReserva() == reserva.getCodReserva()){
				return i;
			}
		}
		return -1;
	}
}
