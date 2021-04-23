package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Proprietario;


public class ProprietarioDAO {
	public Proprietario login(String email, String senha) {
		Proprietario proprietario = new Proprietario();
		String sqlCheck = "SELECT emailProprietario, senhaProprietario FROM proprietario "
				+ "WHERE emailProprietario=? AND senhaProprietario=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlCheck);) {
			stm.setString(1, proprietario.getEmail());
			stm.setString(2, proprietario.getSenha());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					proprietario.setEmail(rs.getString("emailProprietario"));
					proprietario.setSenha(rs.getString("senhaProprietario"));
				} else {
					proprietario.setEmail("erro");
					proprietario.setSenha("erro");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return proprietario;
	}
	public String criar(Proprietario proprietario) {
		String sqlInsert = "INSERT INTO proprietario(CNPJ, nomeProprietario, telefoneProprietario, "
				+ "emailProprietario, senhaProprietario) VALUES (?, ?, ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, proprietario.getCNPJ());
			stm.setString(2, proprietario.getNome());
			stm.setString(3, proprietario.getFone());
			stm.setString(4, proprietario.getEmail());
			stm.setString(5, proprietario.getSenha());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return proprietario.getCNPJ();
	}

	public void atualizar(Proprietario proprietario) {
		String sqlUpdate = "UPDATE proprietario SET nomeProprietario=?, telefoneProprietario=?, "
				+ "emailProprietario=?, senhaProprietario=? WHERE CNPJ=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, proprietario.getNome());
			stm.setString(2, proprietario.getFone());
			stm.setString(3, proprietario.getEmail());
			stm.setString(4, proprietario.getSenha());
			stm.setString(5, proprietario.getCNPJ());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(String CNPJ) {
		String sqlDelete = "DELETE FROM proprietario WHERE CNPJ = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setString(1, CNPJ);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Proprietario carregar(String CNPJ) {
		Proprietario proprietario = new Proprietario();
		proprietario.setCNPJ(CNPJ);
		String sqlSelect = "SELECT nomeProprietario, telefoneProprietario, emailProprietario, "
				+ "senhaProprietario FROM proprietario WHERE proprietario.CNPJ = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, proprietario.getCNPJ());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					proprietario.setNome(rs.getString("nomeProprietario"));
					proprietario.setFone(rs.getString("telefoneProprietario"));
					proprietario.setEmail(rs.getString("emailProprietario"));
					proprietario.setSenha(rs.getString("senhaProprietario"));
				} else {
					proprietario.setCNPJ(null);
					proprietario.setNome(null);
					proprietario.setFone(null);
					proprietario.setEmail(null);
					proprietario.setSenha(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return proprietario;
	}

}

