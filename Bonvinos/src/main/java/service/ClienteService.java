package service;

import model.Cliente;
import dao.ClienteDAO;


public class ClienteService {
	ClienteDAO dao = new ClienteDAO();
	
	public String criar(Cliente cliente) {
		return dao.criar(cliente);
	}
	
	public void atualizar(Cliente cliente){
		dao.atualizar(cliente);
	}
	
	public void excluir(String CPF){
		dao.excluir(CPF);
	}
	
	public Cliente carregar(String CPF){
		return dao.carregar(CPF);
	}
}