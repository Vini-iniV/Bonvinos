package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Cliente;


public class ClienteDAO {
	public String criar(Cliente cliente) {
		String sqlInsert = "INSERT INTO cliente(CPF, nomeCliente, telefoneCliente, emailCliente, senhaCliente) "
				+ "VALUES (?, ?, ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, cliente.getCPF());
			stm.setString(2, cliente.getNome());
			stm.setString(3, cliente.getFone());
			stm.setString(4, cliente.getEmail());
			stm.setString(5, cliente.getSenha());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cliente.getCPF();
	}

	public void atualizar(Cliente cliente) {
		String sqlUpdate = "UPDATE cliente SET nomeCliente=?, telefoneCliente=?, emailCliente=?, senhaCliente=? "
				+ "WHERE CPF=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, cliente.getNome());
			stm.setString(2, cliente.getFone());
			stm.setString(3, cliente.getEmail());
			stm.setString(4, cliente.getSenha());
			stm.setString(5, cliente.getCPF());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(String CPF) {
		String sqlDelete = "DELETE FROM cliente WHERE CPF = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setString(1, CPF);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Cliente carregar(String CPF) {
		Cliente cliente = new Cliente();
		cliente.setCPF(CPF);
		String sqlSelect = "SELECT nomeCliente, telefoneCliente, emailCliente, senhaCliente "
				+ "FROM cliente WHERE cliente.CPF = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, cliente.getCPF());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					cliente.setNome(rs.getString("nomeCliente"));
					cliente.setFone(rs.getString("telefoneCliente"));
					cliente.setEmail(rs.getString("emailCliente"));
					cliente.setSenha(rs.getString("senhaCliente"));
				} else {
					cliente.setCPF(null);
					cliente.setNome(null);
					cliente.setFone(null);
					cliente.setEmail(null);
					cliente.setSenha(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return cliente;
	}

}
