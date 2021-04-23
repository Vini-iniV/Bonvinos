package service;

import java.util.ArrayList;

import dao.ReservaDAO;
import model.Reserva;

public class ReservaService {

	ReservaDAO dao = new ReservaDAO();
	
	public int criar(Reserva reserva) {
		return dao.criar(reserva);
	}
	
	public void atualizar(Reserva reserva) {
		dao.atualizar(reserva);
	}
	
	public void excluir(int codReserva) {
		dao.excluir(codReserva);
	}
	
	public Reserva carregar(int codReserva) {
		return dao.carregar(codReserva);
	}
	
	public ArrayList<Reserva> listarReservas(){
		return dao.listarReservas();
	}
	
	public ArrayList<Reserva> listarReservas(String chave){
		return dao.listarReservas(chave);
	}
	
	public ArrayList<Reserva> listarReservasProprietario(int codRestaurante){
		return dao.listarReservasProprietario(codRestaurante);
	}
	
	public ArrayList<Reserva> listarReservasProprietario(String chave, int codRestaurante){
		return dao.listarReservasProprietario(chave, codRestaurante);
	}
}
