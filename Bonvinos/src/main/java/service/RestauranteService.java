package service;

import model.Restaurante;

import java.util.ArrayList;

import dao.RestauranteDAO;


public class RestauranteService {
	RestauranteDAO dao = new RestauranteDAO();
	
	public int criar(Restaurante restaurante) {
		return dao.criar(restaurante);
	}
	
	public void atualizar(Restaurante restaurante){
		dao.atualizar(restaurante);
	}
	
	public void excluir(int codRestaurante){
		dao.excluir(codRestaurante);
	}
	
	public Restaurante carregar(int codRestaurante){
		return dao.carregar(codRestaurante);
	}
	
	public ArrayList<Restaurante> listarRestaurantes(){
		return dao.listarRestaurantes();
	}
	
	public ArrayList<Restaurante> listarRestaurantes(String chave){
		return dao.listarRestaurantes(chave);
	}
	
	public void inserirLatLong(Restaurante restaurante) {
		dao.inserirLatLong(restaurante);
	}
	
	public Restaurante comparaLatLongs(String lat, String Long) {
		return dao.comparaLatLongs(lat, Long);
	}
		
}

