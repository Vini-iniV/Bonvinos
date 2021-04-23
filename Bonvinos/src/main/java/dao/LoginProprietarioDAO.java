package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Login;

public class LoginProprietarioDAO {
	
	public boolean login(Login login) {
		boolean status = false;
		
		String sqlCheck = "SELECT emailProprietario, senhaProprietario FROM proprietario WHERE emailProprietario=? AND senhaProprietario=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlCheck);) {
			stm.setString(1, login.getEmail());
			stm.setString(2, login.getSenha());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					return status = true;
				} else {
					return status = false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return status;
	}
}
