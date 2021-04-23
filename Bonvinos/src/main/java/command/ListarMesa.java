package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Mesa;
import model.Restaurante;
import service.MesaService;

public class ListarMesa implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String pCodRestaurante = request.getParameter("codRestaurante");
		String chave = request.getParameter("data[search]");
		
		int codRestaurante = -1;
		try {
			codRestaurante = Integer.parseInt(pCodRestaurante);
		}catch(NumberFormatException e) {
			
		}
		
		Restaurante restaurante = new Restaurante();
		restaurante.setCodRestaurante(codRestaurante);
		
		MesaService ms = new MesaService();
		ArrayList<Mesa> listaMesa = null;
		HttpSession session = request.getSession();

		if (chave != null && chave.length() > 0) {
			listaMesa = ms.listarMesas(chave, codRestaurante);
		} else {
			listaMesa = ms.listarMesas(codRestaurante);
		}
		
		session.setAttribute("listaMesa", listaMesa);
		session.setAttribute("restaurante", restaurante);
		

		RequestDispatcher dispatcher = request
		.getRequestDispatcher("MesasRestaurante.jsp");
		dispatcher.forward(request, response);
	}

}
