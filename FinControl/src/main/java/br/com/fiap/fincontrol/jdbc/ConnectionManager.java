package br.com.fiap.fincontrol.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {
	 
	private static ConnectionManager instance;
	
	private ConnectionManager() {}
	
	public static ConnectionManager getInstance() {
		if(instance == null) {
			instance = new ConnectionManager();
		}
		return instance;
	}
	
	public Connection getConnetion() {
		Connection conexao = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexao = DriverManager.getConnection(
					"jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", 
					"RM99337", 
					"170305");
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return conexao;
	}
}

