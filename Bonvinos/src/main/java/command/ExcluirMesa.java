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

public class ExcluirMesa implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String pCodMesa = request.getParameter("codMesa");
		
		int codMesa = -1;
		
		try {
			codMesa = Integer.parseInt(pCodMesa);
		} catch (NumberFormatException e) {

		}
		
		//instanciar o javabean
		Mesa mesa = new Mesa();
		mesa.setCodMesa(codMesa);
		
		MesaService ms = new MesaService();
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		ms.excluir(mesa.getCodMesa());
		ArrayList<Mesa> listaMesa = (ArrayList<Mesa>)session.getAttribute("listaMesa");
		listaMesa.remove(busca(mesa, listaMesa));
		session.setAttribute("listaMesa", listaMesa);
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
