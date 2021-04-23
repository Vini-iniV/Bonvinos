package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Mesa;
import service.MesaService;

public class ManterMesa implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pCodRestaurante = request.getParameter("codRestaurante");
		String pCapacidade = request.getParameter("capacidade");
		
		int codRestaurante = -1;
		int capacidade = -1;
		
		try {
			codRestaurante = Integer.parseInt(pCodRestaurante);
			capacidade = Integer.parseInt(pCapacidade);
		} catch (NumberFormatException e) {

		}
		
		//instanciar o javabean
		Mesa mesa = new Mesa();
		mesa.setCodRestaurante(codRestaurante);
		mesa.setCapacidade(capacidade);
		
		//instanciar o service
		MesaService ms = new MesaService();
		ms.criar(mesa);
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		ArrayList<Mesa> listaMesa = new ArrayList<>();
		listaMesa.add(mesa);
		session.setAttribute("listaMesa", listaMesa);
		view = request.getRequestDispatcher("ListarRestaurantes.jsp");
		
		view.forward(request, response);
	}

}
