package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Mesa;

public class MesaDAO {

	public int criar(Mesa mesa) {
		String sqlInsert = "INSERT INTO mesa(capacidadeMesa, Restaurante_codRestaurante) "
				+ "VALUES (?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, mesa.getCapacidade());
			stm.setInt(2, mesa.getCodRestaurante());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					mesa.setCodMesa(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mesa.getCodMesa();
	}

	public void atualizar(Mesa mesa) {
		String sqlUpdate = "UPDATE mesa SET capacidadeMesa=?, Restaurante_codRestaurante=?"
				+ " WHERE codMesa=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, mesa.getCapacidade());
			stm.setInt(2, mesa.getCodRestaurante());
			stm.setInt(3, mesa.getCodMesa());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int codMesa) {
		String sqlDelete = "DELETE FROM mesa WHERE codMesa = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, codMesa);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Mesa carregar(int codMesa) {
		Mesa mesa = new Mesa();
		mesa.setCodMesa(codMesa);
		String sqlSelect = "SELECT capacidadeMesa, Restaurante_codRestaurante FROM mesa"
				+ " WHERE mesa.codMesa = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, mesa.getCodMesa());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					mesa.setCapacidade(rs.getInt("capacidadeMesa"));
					mesa.setCodRestaurante(rs.getInt("Restaurante_codRestaurante"));
					
				} else {
					mesa.setCodMesa(-1);
					mesa.setCapacidade(-1);
					mesa.setCodRestaurante(-1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return mesa;
	}
	
	public ArrayList<Mesa> listarMesas(int codRestaurante) {
		Mesa mesa;
		ArrayList<Mesa> listaMesa = new ArrayList<>();
		String sqlSelect = "SELECT codMesa, capacidadeMesa, Restaurante_codRestaurante FROM mesa "
				+ "WHERE mesa.Restaurante_codRestaurante=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setInt(1, codRestaurante);
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					mesa = new Mesa();
					mesa.setCodMesa(rs.getInt("codMesa"));
					mesa.setCapacidade(rs.getInt("capacidadeMesa"));
					mesa.setCodRestaurante(rs.getInt("Restaurante_codRestaurante"));
					listaMesa.add(mesa);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return listaMesa;
	}

	public ArrayList<Mesa> listarMesas(String chave, int codRestaurante) {
		Mesa mesa;
		ArrayList<Mesa> listaMesa = new ArrayList<>();
		String sqlSelect = "SELECT codMesa, capacidadeMesa, Restaurante_codRestaurante "
							+ "FROM mesa WHERE codMesa like ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, "%" + chave + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					mesa = new Mesa();
					mesa.setCodMesa(rs.getInt("codMesa"));
					mesa.setCapacidade(rs.getInt("capacidadeMesa"));
					mesa.setCodRestaurante(rs.getInt("Restaurante_codRestaurante"));
					listaMesa.add(mesa);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return listaMesa;
	}
	
	public ArrayList<Mesa> listarMesasDisponiveis(int codRestaurante) {
		Mesa mesa;
		ArrayList<Mesa> listaMesasDisponiveis = new ArrayList<>();
		String sqlSelect = "SELECT codMesa, capacidadeMesa, Restaurante_codRestaurante FROM mesa"
				+ " WHERE mesa.disponibilidade = ? AND mesa.Restaurante_codRestaurante=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setBoolean(1, true);
				stm.setInt(2, codRestaurante);
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					mesa = new Mesa();
					mesa.setCodMesa(rs.getInt("codMesa"));
					mesa.setCapacidade(rs.getInt("capacidadeMesa"));
					mesa.setCodRestaurante(rs.getInt("Restaurante_codRestaurante"));
					listaMesasDisponiveis.add(mesa);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return listaMesasDisponiveis;
	}
	
	public ArrayList<Mesa> listarMesasDisponiveis(String chave, int codRestaurante) {
		Mesa mesa;
		ArrayList<Mesa> listaMesasDisponiveis = new ArrayList<>();
		String sqlSelect = "SELECT codMesa, capacidadeMesa, Restaurante_codRestaurante "
							+ "FROM mesa WHERE codMesa like ? AND mesa.disponibilidade = ? "
							+ "AND mesa.Restaurante_codRestaurante=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, "%" + chave + "%");
			stm.setBoolean(2, true);
			stm.setInt(3, codRestaurante);
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					mesa = new Mesa();
					mesa.setCodMesa(rs.getInt("codMesa"));
					mesa.setCapacidade(rs.getInt("capacidadeMesa"));
					mesa.setCodRestaurante(rs.getInt("Restaurante_codRestaurante"));
					listaMesasDisponiveis.add(mesa);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return listaMesasDisponiveis;
	}
	
	public void atualizarDisponibilidade(Mesa mesa) {
		String sqlUpdate = "UPDATE mesa SET disponibilidade=? WHERE mesa.codMesa=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setBoolean(1, false);
			stm.setInt(2, mesa.getCodMesa());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void atualizarOcupacao(Mesa mesa) {
		String sqlUpdate = "UPDATE mesa SET disponibilidade=? WHERE mesa.codMesa=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setBoolean(1, true);
			stm.setInt(2, mesa.getCodMesa());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
