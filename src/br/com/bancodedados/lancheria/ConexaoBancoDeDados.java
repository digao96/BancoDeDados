package br.com.bancodedados.lancheria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBancoDeDados {

	private static final String USERNAME = "root";
	private static final String PASSWORD = "digocs123";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/lancheria";
	
	public static Connection conexao() throws SQLException, ClassNotFoundException {
			//Class.forName("com.mysql.jdbc.Driver");
			Connection conectar = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			return conectar;
	}
	
}
