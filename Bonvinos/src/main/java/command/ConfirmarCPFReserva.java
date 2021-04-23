package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Mesa;
import service.MesaService;

public class ConfirmarCPFReserva implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pCodMesa = request.getParameter("codMesa");
		String pCodRestaurante = request.getParameter("codRestaurante");
		
		int codRestaurante = -1;
		int codMesa = -1;
		
		try {
			codRestaurante = Integer.parseInt(pCodRestaurante);
			codMesa = Integer.parseInt(pCodMesa);
		} catch (NumberFormatException e) {

		}
		//instanciar o javabean
		Mesa mesa = new Mesa();
		mesa.setCodMesa(codMesa);
		mesa.setCodRestaurante(codRestaurante);
	
		MesaService ms = new MesaService();
		RequestDispatcher view = null;
		
		mesa = ms.carregar(mesa.getCodMesa());
		request.getSession().setAttribute("mesa", mesa);
		
		view = request.getRequestDispatcher("ConfirmaCPFReserva.jsp");
		view.forward(request, response);
	}

}
