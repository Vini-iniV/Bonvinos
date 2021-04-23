package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Login;
import service.LoginProprietarioService;

public class LogoffProprietario implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		Login login = (Login) session.getAttribute("logado");
		LoginProprietarioService ls = new LoginProprietarioService();
		
		if(ls.checaDados(login)) {
			session.setAttribute("logado", null);
			System.out.println("Logoff feito com sucesso");
		}
		response.sendRedirect("loginProprietario.jsp");
	}
}	

