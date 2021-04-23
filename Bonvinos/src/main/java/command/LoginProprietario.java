package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Login;
import service.LoginProprietarioService;

public class LoginProprietario implements Command{

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String pEmail = request.getParameter("email");
		String pSenha = request.getParameter("senha");
		
		Login loginProprietario = new Login();
		loginProprietario.setEmail(pEmail);
		loginProprietario.setSenha(pSenha);
		LoginProprietarioService ls = new LoginProprietarioService();
		
        String paginaDestino = null;
        
        try{
        	if(ls.checaDados(loginProprietario)) {
        		HttpSession session = request.getSession();
    			session.setAttribute("logado", loginProprietario);
    			System.out.println("Logou: "+ loginProprietario);
        		paginaDestino = "ProprietarioLogado.jsp";
        	} else {
        		System.out.println("Não logou: " + loginProprietario);
                paginaDestino = "SenhaIncorreta.jsp";
        	}
        } catch(Exception e) {
        	System.out.println(e);
        }
             
        RequestDispatcher dispatcher = request.getRequestDispatcher(paginaDestino);
        dispatcher.forward(request, response);
	}
}
