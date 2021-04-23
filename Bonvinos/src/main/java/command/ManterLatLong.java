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

public class ManterLatLong implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String pCodRestaurante = request.getParameter("codRestaurante");
		String pNome = request.getParameter("nomeRestaurante");
		String pDescricao = request.getParameter("descricaoRestaurante");
		String pEnderecoRua = request.getParameter("enderecoRuaRestaurante");
		String pEnderecoNumero = request.getParameter("enderecoNumeroRestaurante");
		String pEnderecoCEP = request.getParameter("enderecoCEPRestaurante");
		String pFone = request.getParameter("telefoneRestaurante");
		String pProprietarioCNPJ = request.getParameter("ProprietarioCNPJ");
		
		String pLatitude = request.getParameter("latitude");
		String pLongitude = request.getParameter("longitude");
		
		int codRestaurante = -1;
		
		try {
			codRestaurante = Integer.parseInt(pCodRestaurante);
		} catch (NumberFormatException e) {

		}
		
		//instanciar o javabean
		Restaurante restaurante = new Restaurante();
		
		restaurante.setCodRestaurante(codRestaurante);
		restaurante.setNome(pNome);
		restaurante.setDescricao(pDescricao);
		restaurante.setEnderecoRua(pEnderecoRua);
		restaurante.setEnderecoNumero(pEnderecoNumero);
		restaurante.setEnderecoCEP(pEnderecoCEP);
		restaurante.setFone(pFone);
		restaurante.setProprietarioCNPJ(pProprietarioCNPJ);
		
		restaurante.setLatitude(pLatitude);
		restaurante.setLongitude(pLongitude);
		
		//instanciar o service
		RestauranteService rs = new RestauranteService();
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		rs.inserirLatLong(restaurante);
		ArrayList<Restaurante> lista = (ArrayList<Restaurante>)session.getAttribute("lista");
		int pos = busca(restaurante, lista);
		lista.remove(pos);
		lista.add(pos, restaurante);
		session.setAttribute("lista", lista);
		request.setAttribute("restaurante", restaurante);
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
