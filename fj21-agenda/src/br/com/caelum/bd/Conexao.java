package br.com.caelum.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private static final String USUARIO = "root";
	private static final String SENHA = "";
	private static final String URL = "jdbc:mysql://localhost:3306/agenda";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	
	//Conectar ao banco
	public static void abrir() throws Exception {
		//Registrar Driver
		Class.forName(DRIVER);
		//Capturar  a conexao
		Connection connection = DriverManager.getConnection(URL);
		
		System.out.println("Conectado!");
		
        connection.close();
	}
}
