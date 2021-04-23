package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Restaurante;
import service.RestauranteService;

public class EditarRestaurante implements Command {

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
			
		restaurante = rs.carregar(restaurante.getCodRestaurante());
		request.setAttribute("restaurante", restaurante);
		view = request.getRequestDispatcher("AlterarRestaurante.jsp");
		view.forward(request, response);
	}

}
