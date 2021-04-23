package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Login;
import service.LoginClienteService;

public class LoginCliente implements Command{

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String pEmail = request.getParameter("email");
		String pSenha = request.getParameter("senha");
		
		Login loginCliente = new Login();
		loginCliente.setEmail(pEmail);
		loginCliente.setSenha(pSenha);
		LoginClienteService ls = new LoginClienteService();
		
        String paginaDestino = null;
        
        try{
        	if(ls.checaDados(loginCliente)) {
        		HttpSession session = request.getSession();
    			session.setAttribute("logado", loginCliente);
    			System.out.println("Logou: "+ loginCliente);
        		paginaDestino = "ClienteLogado.jsp";
        	} else {
        		System.out.println("Não logou: " + loginCliente);
                paginaDestino = "SenhaIncorreta.jsp";
        	}
        } catch(Exception e) {
        	System.out.println(e);
        }
             
        RequestDispatcher dispatcher = request.getRequestDispatcher(paginaDestino);
        dispatcher.forward(request, response);
	}
}
