package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Mesa;
import service.MesaService;

public class EditarMesa implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String pCodMesa = request.getParameter("codMesa");
		String pCodRestaurante = request.getParameter("codRestaurante");
		String pCapacidade = request.getParameter("capacidade");
		
		int codMesa = -1;
		int codRestaurante = -1;
		int capacidade = -1;
		
		try {
			codMesa = Integer.parseInt(pCodMesa);
			codRestaurante = Integer.parseInt(pCodRestaurante);
			capacidade = Integer.parseInt(pCapacidade);
		} catch (NumberFormatException e) {

		}
		
		//instanciar o javabean
		Mesa mesa = new Mesa();
		mesa.setCodMesa(codMesa);
		mesa.setCodRestaurante(codRestaurante);
		mesa.setCapacidade(capacidade);
			
		MesaService ms = new MesaService();
		RequestDispatcher view = null;
			
		mesa = ms.carregar(mesa.getCodMesa());
		request.setAttribute("mesa", mesa);
		view = request.getRequestDispatcher("AlterarMesa.jsp");
		view.forward(request, response);
	}
}
