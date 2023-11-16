package br.com.fiap.fincontrol.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
	
	public static Connection obterConexao() {
		Connection conexao = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexao = DriverManager.getConnection(
					"jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", 
					"RM99337", 
					"170305");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conexao;
	}
}
