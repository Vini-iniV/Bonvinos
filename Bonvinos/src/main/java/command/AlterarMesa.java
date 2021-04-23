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

public class AlterarMesa implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String pCodRestaurante = request.getParameter("codRestaurante");
		String pCodMesa = request.getParameter("codMesa");
		String pCapacidade = request.getParameter("capacidade");
		
		int codRestaurante = -1;
		int codMesa = -1;
		int capacidade = -1;
		
		try {
			codRestaurante = Integer.parseInt(pCodRestaurante);
			codMesa = Integer.parseInt(pCodMesa);
			capacidade = Integer.parseInt(pCapacidade);
		} catch (NumberFormatException e) {

		}
		
		//instanciar o javabean
		Mesa mesa = new Mesa();
		mesa.setCodRestaurante(codRestaurante);
		mesa.setCodMesa(codMesa);
		mesa.setCapacidade(capacidade);
		
		
		MesaService ms = new MesaService();	
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		ms.atualizar(mesa);
		ArrayList<Mesa> listaMesa = (ArrayList<Mesa>)session.getAttribute("listaMesa");
		int pos = busca(mesa, listaMesa);
		listaMesa.remove(pos);
		listaMesa.add(pos, mesa);
		session.setAttribute("listaMesa", listaMesa);
		request.setAttribute("mesa", mesa);
		view = request.getRequestDispatcher("MesasRestaurante.jsp");

		view.forward(request, response);

	}

	public int busca(Mesa mesa, ArrayList<Mesa> listaMesa) {
		Mesa to;
		for(int i = 0; i < listaMesa.size(); i++){
			to = listaMesa.get(i);
			if(to.getCodMesa() == mesa.getCodMesa()){
				return i;
			}
		}
		return -1;
	}

}
