package service;

import dao.LoginProprietarioDAO;
import model.Login;

public class LoginProprietarioService {
	private LoginProprietarioDAO dao= new LoginProprietarioDAO();
	
	public boolean checaDados(Login login) {
		return dao.login(login);
	}
}

