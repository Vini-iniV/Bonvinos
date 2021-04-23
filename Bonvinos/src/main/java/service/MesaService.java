package service;

import java.util.ArrayList;

import dao.MesaDAO;
import model.Mesa;

public class MesaService {

	MesaDAO dao = new MesaDAO();
	
	public int criar(Mesa mesa) {
		return dao.criar(mesa);
	}
	
	public void atualizar(Mesa mesa) {
		dao.atualizar(mesa);
	}
	
	public void excluir(int codMesa) {
		dao.excluir(codMesa);
	}
	
	public Mesa carregar(int codMesa) {
		return dao.carregar(codMesa);
	}
	
	public ArrayList<Mesa> listarMesas(int codRestaurante){
		return dao.listarMesas(codRestaurante);
	}
	
	public ArrayList<Mesa> listarMesas(String chave, int codRestaurante){
		return dao.listarMesas(chave, codRestaurante);
	}
	
	public ArrayList<Mesa> listarMesasDisponiveis( int codRestaurante){
		return dao.listarMesasDisponiveis(codRestaurante);
	}
	
	public ArrayList<Mesa> listarMesasDisponiveis(String chave, int codRestaurante){
		return dao.listarMesasDisponiveis(chave, codRestaurante);
	}
	
	public void atualizarDisponibilidade(Mesa mesa) {
		dao.atualizarDisponibilidade(mesa);
	}
	
	public void atualizarOcupacao(Mesa mesa) {
		dao.atualizarOcupacao(mesa);
	}
}
