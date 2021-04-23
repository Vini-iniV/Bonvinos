package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import service.ClienteService;

public class AtualizaCliente implements Command{
	
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String pNome = request.getParameter("nome");
		String pFone = request.getParameter("fone");
		String pEmail = request.getParameter("email");
		String pSenha = request.getParameter("senha");
		String pCPF = request.getParameter("CPF");
		
		//instanciar o javabean
		Cliente cliente = new Cliente();
		cliente.setNome(pNome);
		cliente.setFone(pFone);
		cliente.setEmail(pEmail);
		cliente.setSenha(pSenha);
		cliente.setCPF(pCPF);
		
		//instanciar o service
		ClienteService cs = new ClienteService();
		cs.atualizar(cliente);
		cliente = cs.carregar(cliente.getCPF());
		
		//envia para o jsp
		request.setAttribute("cliente", cliente);
		
		RequestDispatcher view = request.getRequestDispatcher("ClienteAtualizado.jsp");
		view.forward(request, response);
	}
}
