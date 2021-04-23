package service;

import dao.LoginClienteDAO;
import model.Login;

public class LoginClienteService {
	private LoginClienteDAO dao= new LoginClienteDAO();
	
	public boolean checaDados(Login login) {
		return dao.login(login);
	}
}

