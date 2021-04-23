package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Reserva;

public class ReservaDAO {
	
	public int criar(Reserva reserva) {
		String sqlInsert = "INSERT INTO reserva(Mesa_codMesa, Mesa_Restaurante_codRestaurante, Cliente_CPF) "
				+ "VALUES (?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, reserva.getCodMesaReservada());
			stm.setInt(2, reserva.getCodRestauranteReserva());
			stm.setInt(3, reserva.getClienteCPF());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					reserva.setCodReserva(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reserva.getCodReserva();
	}

	public void atualizar(Reserva reserva) {
		String sqlUpdate = "UPDATE reserva SET Mesa_codMesa=?, Mesa_Restaurante_codRestaurante=?"
				+ ", Cliente_CPF=? WHERE codReserva=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, reserva.getCodMesaReservada());
			stm.setInt(2, reserva.getCodRestauranteReserva());
			stm.setInt(3, reserva.getClienteCPF());
			stm.setInt(4, reserva.getCodReserva());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int codReserva) {
		String sqlDelete = "DELETE FROM reserva WHERE codReserva = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, codReserva);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Reserva carregar(int codReserva) {
		Reserva reserva = new Reserva();
		reserva.setCodReserva(codReserva);
		String sqlSelect = "SELECT Mesa_codMesa, Mesa_Restaurante_codRestaurante, Cliente_CPF"
				+ " WHERE reserva.codReserva = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, reserva.getCodReserva());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					reserva.setCodMesaReservada(rs.getInt("Mesa_codMesa"));
					reserva.setCodRestauranteReserva(rs.getInt("Mesa_Restaurante_codRestaurante"));
					reserva.setClienteCPF(rs.getInt("Cliente_CPF"));
				} else {
					reserva.setCodReserva(-1);
					reserva.setCodMesaReservada(-1);
					reserva.setCodRestauranteReserva(-1);
					reserva.setClienteCPF(-1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return reserva;
	}
	
	public ArrayList<Reserva> listarReservas() {
		Reserva reserva;
		ArrayList<Reserva> listaReserva = new ArrayList<>();
		String sqlSelect = "SELECT codReserva, Mesa_codMesa, Mesa_Restaurante_codRestaurante, Cliente_CPF FROM reserva";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					reserva = new Reserva();
					reserva.setCodReserva(rs.getInt("codReserva"));
					reserva.setCodMesaReservada(rs.getInt("Mesa_codMesa"));
					reserva.setCodRestauranteReserva(rs.getInt("Mesa_Restaurante_codRestaurante"));
					reserva.setClienteCPF(rs.getInt("Cliente_CPF"));
					listaReserva.add(reserva);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return listaReserva;
	}

	public ArrayList<Reserva> listarReservas(String chave) {
		Reserva reserva;
		ArrayList<Reserva> listaReserva = new ArrayList<>();
		String sqlSelect = "SELECT codReserva, Mesa_codMesa, Mesa_Restaurante_codRestaurante, Cliente_CPF "
							+ "FROM reserva WHERE codReserva like ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, "%" + chave + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					reserva = new Reserva();
					reserva.setCodReserva(rs.getInt("codReserva"));
					reserva.setCodMesaReservada(rs.getInt("Mesa_codMesa"));
					reserva.setCodRestauranteReserva(rs.getInt("Mesa_Restaurante_codRestaurante"));
					reserva.setClienteCPF(rs.getInt("Cliente_CPF"));
					listaReserva.add(reserva);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return listaReserva;
	}
	
	public ArrayList<Reserva> listarReservasProprietario(int codRestaurante) {
		Reserva reserva;
		ArrayList<Reserva> listaReserva = new ArrayList<>();
		String sqlSelect = "SELECT codReserva, Mesa_codMesa, Mesa_Restaurante_codRestaurante, Cliente_CPF "
				+ "FROM reserva WHERE reserva.Mesa_Restaurante_codRestaurante=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, codRestaurante);
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					reserva = new Reserva();
					reserva.setCodReserva(rs.getInt("codReserva"));
					reserva.setCodMesaReservada(rs.getInt("Mesa_codMesa"));
					reserva.setCodRestauranteReserva(rs.getInt("Mesa_Restaurante_codRestaurante"));
					reserva.setClienteCPF(rs.getInt("Cliente_CPF"));
					listaReserva.add(reserva);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return listaReserva;
	}

	public ArrayList<Reserva> listarReservasProprietario(String chave, int codRestaurante) {
		Reserva reserva;
		ArrayList<Reserva> listaReserva = new ArrayList<>();
		String sqlSelect = "SELECT codReserva, Mesa_codMesa, Mesa_Restaurante_codRestaurante, Cliente_CPF "
							+ "FROM reserva WHERE codReserva like ? AND Mesa_Restaurante_codRestaurante=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, "%" + chave + "%");
			stm.setInt(2, codRestaurante);
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					reserva = new Reserva();
					reserva.setCodReserva(rs.getInt("codReserva"));
					reserva.setCodMesaReservada(rs.getInt("Mesa_codMesa"));
					reserva.setCodRestauranteReserva(rs.getInt("Mesa_Restaurante_codRestaurante"));
					reserva.setClienteCPF(rs.getInt("Cliente_CPF"));
					listaReserva.add(reserva);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return listaReserva;
	}
}
