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

public class AlterarRestaurante implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String pCodRestaurante = request.getParameter("codRestaurante");
		String pNome = request.getParameter("nome");
		String pDescricao = request.getParameter("descricao");
		String pEnderecoRua = request.getParameter("enderecoRua");
		String pEnderecoNumero = request.getParameter("enderecoNumero");
		String pEnderecoCEP = request.getParameter("enderecoCEP");
		String pFone = request.getParameter("fone");
		String pProprietarioCNPJ = request.getParameter("CNPJ");
		
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
		
		
		RestauranteService rs = new RestauranteService();	
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		rs.atualizar(restaurante);
		ArrayList<Restaurante> lista = (ArrayList<Restaurante>)session.getAttribute("lista");
		int pos = busca(restaurante, lista);
		lista.remove(pos);
		lista.add(pos, restaurante);
		session.setAttribute("lista", lista);
		request.setAttribute("restaurante", restaurante);
		view = request.getRequestDispatcher("VisualizarRestaurante.jsp");

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
