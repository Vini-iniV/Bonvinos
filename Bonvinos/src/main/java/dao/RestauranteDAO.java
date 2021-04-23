package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Restaurante;


public class RestauranteDAO {
	
	public int criar(Restaurante restaurante) {
		String sqlInsert = "INSERT INTO restaurante(nomeRestaurante, descricaoRestaurante, "
				+ "enderecoRuaRestaurante, enderecoNumeroRestaurante, enderecoCEPRestaurante"
				+ ", telefoneRestaurante, Proprietario_CNPJ) VALUES (?, ?, ?, ?, ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, restaurante.getNome());
			stm.setString(2, restaurante.getDescricao());
			stm.setString(3, restaurante.getEnderecoRua());
			stm.setString(4, restaurante.getEnderecoNumero());
			stm.setString(5, restaurante.getEnderecoCEP());
			stm.setString(6, restaurante.getFone());
			stm.setString(7, restaurante.getProprietarioCNPJ());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					restaurante.setCodRestaurante(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return restaurante.getCodRestaurante();
	}

	public void atualizar(Restaurante restaurante) {
		String sqlUpdate = "UPDATE restaurante SET nomeRestaurante=?, descricaoRestaurante=?, " + 
				"enderecoRuaRestaurante=?, enderecoNumeroRestaurante=?, enderecoCEPRestaurante=?" + 
				", telefoneRestaurante=?, Proprietario_CNPJ=? WHERE codRestaurante=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, restaurante.getNome());
			stm.setString(2, restaurante.getDescricao());
			stm.setString(3, restaurante.getEnderecoRua());
			stm.setString(4, restaurante.getEnderecoNumero());
			stm.setString(5, restaurante.getEnderecoCEP());
			stm.setString(6, restaurante.getFone());
			stm.setString(7, restaurante.getProprietarioCNPJ());
			stm.setInt(8, restaurante.getCodRestaurante());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int codRestaurante) {
		String sqlDelete = "DELETE FROM restaurante WHERE codRestaurante = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, codRestaurante);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Restaurante carregar(int codRestaurante) {
		Restaurante restaurante = new Restaurante();
		restaurante.setCodRestaurante(codRestaurante);
		String sqlSelect = "SELECT nomeRestaurante, descricaoRestaurante, enderecoRuaRestaurante, "
				+ "enderecoNumeroRestaurante, enderecoCEPRestaurante, telefoneRestaurante,"
				+ "Proprietario_CNPJ, latitude, longitude"
				+ " FROM restaurante WHERE restaurante.codRestaurante = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, restaurante.getCodRestaurante());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					restaurante.setNome(rs.getString("nomeRestaurante"));
					restaurante.setDescricao(rs.getString("descricaoRestaurante"));
					restaurante.setEnderecoRua(rs.getString("enderecoRuaRestaurante"));
					restaurante.setEnderecoNumero(rs.getString("enderecoNumeroRestaurante"));
					restaurante.setEnderecoCEP(rs.getString("enderecoCEPRestaurante"));
					restaurante.setFone(rs.getString("telefoneRestaurante"));
					restaurante.setProprietarioCNPJ(rs.getString("Proprietario_CNPJ"));
					restaurante.setLatitude(rs.getString("latitude"));
					restaurante.setLongitude(rs.getString("longitude"));
					
				} else {
					restaurante.setCodRestaurante(-1);
					restaurante.setNome(null);
					restaurante.setDescricao(null);
					restaurante.setEnderecoRua(null);
					restaurante.setEnderecoNumero(null);
					restaurante.setEnderecoCEP(null);
					restaurante.setFone(null);
					restaurante.setProprietarioCNPJ(null);
					restaurante.setLatitude(null);
					restaurante.setLongitude(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return restaurante;
	}
	
	public ArrayList<Restaurante> listarRestaurantes() {
		Restaurante restaurante;
		ArrayList<Restaurante> lista = new ArrayList<>();
		String sqlSelect = "SELECT codRestaurante, nomeRestaurante, descricaoRestaurante, enderecoRuaRestaurante, " + 
							"enderecoNumeroRestaurante, enderecoCEPRestaurante, telefoneRestaurante, " + 
							"Proprietario_CNPJ, latitude, longitude FROM restaurante";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					restaurante = new Restaurante();
					restaurante.setCodRestaurante(rs.getInt("codRestaurante"));
					restaurante.setNome(rs.getString("nomeRestaurante"));
					restaurante.setDescricao(rs.getString("descricaoRestaurante"));
					restaurante.setEnderecoRua(rs.getString("enderecoRuaRestaurante"));
					restaurante.setEnderecoNumero(rs.getString("enderecoNumeroRestaurante"));
					restaurante.setEnderecoCEP(rs.getString("enderecoCEPRestaurante"));
					restaurante.setFone(rs.getString("telefoneRestaurante"));
					restaurante.setProprietarioCNPJ(rs.getString("Proprietario_CNPJ"));
					restaurante.setLatitude(rs.getString("latitude"));
					restaurante.setLongitude(rs.getString("longitude"));
					lista.add(restaurante);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}

	public ArrayList<Restaurante> listarRestaurantes(String chave) {
		Restaurante restaurante;
		ArrayList<Restaurante> lista = new ArrayList<>();
		String sqlSelect = "SELECT codRestaurante, nomeRestaurante, descricaoRestaurante, enderecoRuaRestaurante, " + 
							"enderecoNumeroRestaurante, enderecoCEPRestaurante, telefoneRestaurante, " + 
							"Proprietario_CNPJ, latitude, longitude"
							+ "FROM restaurante WHERE nomeRestaurante like ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, "%" + chave + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					restaurante = new Restaurante();
					restaurante.setCodRestaurante(rs.getInt("codRestaurante"));
					restaurante.setNome(rs.getString("nomeRestaurante"));
					restaurante.setDescricao(rs.getString("descricaoRestaurante"));
					restaurante.setEnderecoRua(rs.getString("enderecoRuaRestaurante"));
					restaurante.setEnderecoNumero(rs.getString("enderecoNumeroRestaurante"));
					restaurante.setEnderecoCEP(rs.getString("enderecoCEPRestaurante"));
					restaurante.setFone(rs.getString("telefoneRestaurante"));
					restaurante.setProprietarioCNPJ(rs.getString("Proprietario_CNPJ"));
					restaurante.setLatitude(rs.getString("latitude"));
					restaurante.setLongitude(rs.getString("longitude"));
					lista.add(restaurante);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
	
	public void inserirLatLong(Restaurante restaurante) {
		String sqlUpdate = "UPDATE restaurante SET latitude = ?, longitude = ?" + 
				" WHERE codRestaurante=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, restaurante.getLatitude());
			stm.setString(2, restaurante.getLongitude());
			stm.setInt(3, restaurante.getCodRestaurante());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Restaurante comparaLatLongs(String lat, String Long) {
		Restaurante restaurante = new Restaurante();
		restaurante.setLatitude(lat);
		restaurante.setLongitude(Long);
		String sqlSelect = "SELECT codRestaurante, nomeRestaurante, descricaoRestaurante, enderecoRuaRestaurante, "
				+ "enderecoNumeroRestaurante, enderecoCEPRestaurante, telefoneRestaurante,"
				+ "Proprietario_CNPJ, latitude, longitude"
				+ " FROM restaurante WHERE restaurante.latitude = ? AND restaurante.longitude = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, restaurante.getLatitude());
			stm.setString(2, restaurante.getLongitude());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					restaurante.setCodRestaurante(rs.getInt("codRestaurante"));
					restaurante.setNome(rs.getString("nomeRestaurante"));
					restaurante.setDescricao(rs.getString("descricaoRestaurante"));
					restaurante.setEnderecoRua(rs.getString("enderecoRuaRestaurante"));
					restaurante.setEnderecoNumero(rs.getString("enderecoNumeroRestaurante"));
					restaurante.setEnderecoCEP(rs.getString("enderecoCEPRestaurante"));
					restaurante.setFone(rs.getString("telefoneRestaurante"));
					restaurante.setProprietarioCNPJ(rs.getString("Proprietario_CNPJ"));
					restaurante.setLatitude(rs.getString("latitude"));
					restaurante.setLongitude(rs.getString("longitude"));
					
				} else {
					restaurante.setCodRestaurante(-1);
					restaurante.setNome(null);
					restaurante.setDescricao(null);
					restaurante.setEnderecoRua(null);
					restaurante.setEnderecoNumero(null);
					restaurante.setEnderecoCEP(null);
					restaurante.setFone(null);
					restaurante.setProprietarioCNPJ(null);
					restaurante.setLatitude(null);
					restaurante.setLongitude(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return restaurante;
	}

}
