package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Proprietario;
import service.ProprietarioService;

public class AtualizaProprietario implements Command{
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String pNome = request.getParameter("nome");
		String pFone = request.getParameter("fone");
		String pEmail = request.getParameter("email");
		String pSenha = request.getParameter("senha");
		String pCNPJ = request.getParameter("CNPJ");
		
		//instanciar o javabean
		Proprietario proprietario = new Proprietario();
		proprietario.setNome(pNome);
		proprietario.setFone(pFone);
		proprietario.setEmail(pEmail);
		proprietario.setSenha(pSenha);
		proprietario.setCNPJ(pCNPJ);
		
		//instanciar o service
		ProprietarioService ps = new ProprietarioService();
		ps.atualizar(proprietario);
		proprietario = ps.carregar(proprietario.getCNPJ());
		
		//envia para o jsp
		request.setAttribute("proprietario", proprietario);
		
		RequestDispatcher view = request.getRequestDispatcher("ProprietarioAtualizado.jsp");
		view.forward(request, response);
	}
}
