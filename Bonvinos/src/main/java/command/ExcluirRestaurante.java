package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Restaurante;
import service.RestauranteService;

public class ExcluirRestaurante implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String pCodRestaurante = request.getParameter("codRestaurante");
		
		int codRestaurante = -1;
		
		try {
			codRestaurante = Integer.parseInt(pCodRestaurante);
		} catch (NumberFormatException e) {

		}
		
		//instanciar o javabean
		Restaurante restaurante = new Restaurante();
		restaurante.setCodRestaurante(codRestaurante);
		
		RestauranteService rs = new RestauranteService();
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		rs.excluir(restaurante.getCodRestaurante());
		ArrayList<Restaurante> lista = (ArrayList<Restaurante>)session.getAttribute("lista");
		lista.remove(busca(restaurante, lista));
		session.setAttribute("lista", lista);
		view = request.getRequestDispatcher("ListarRestaurantes.jsp");			
		
		view.forward(request, response);

	}

	public int busca(Restaurante restaurante, ArrayList<Restaurante> lista) {
		Restaurante to;
		for(int i = 0; i < lista.size(); i++){
			to = lista.get(i);
			if(to.getCodRestaurante() == restaurante.getCodRestaurante()){
				return i;
			}
		}
		return -1;
	}
}
