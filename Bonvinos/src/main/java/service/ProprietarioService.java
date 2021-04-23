package service;

import model.Proprietario;
import dao.ProprietarioDAO;


public class ProprietarioService {
	ProprietarioDAO dao = new ProprietarioDAO();
	
	public String criar(Proprietario proprietario) {
		return dao.criar(proprietario);
	}
	
	public void atualizar(Proprietario proprietario){
		dao.atualizar(proprietario);
	}
	
	public void excluir(String CNPJ){
		dao.excluir(CNPJ);
	}
	
	public Proprietario carregar(String CNPJ){
		return dao.carregar(CNPJ);
	}
	
	public Proprietario login(String email, String senha) {
		return dao.login(email, senha);
	}

}
