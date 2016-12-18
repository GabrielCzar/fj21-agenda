package br.com.caelum.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.jbdc.Contato;
import javafx.collections.ArrayChangeListener;


public class ContatoDao{
	
	public boolean create(Contato object) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public Contato read(Contato objectName, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public boolean update(Contato object) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public void delete(Contato object) {
		// TODO Auto-generated method stub
		
	}

	
	public List<String> readAll() {
//		StringBuilder sql = new StringBuilder();
//		sql.append("SELECT nome FROM Contato");
//		
//        try {
//			Connection connection = Conexao.abrir();
//	        PreparedStatement comando = connection.prepareStatement(sql.toString());
//	        ResultSet resultado = comando.executeQuery();
//	        ArrayList<String> lista = new ArrayList<>();
//	        
//	        while (resultado.next()) lista.add(resultado.getString("nome"));
//	        
//	        return lista;
//	        
//		} catch (Exception e) {
//			System.out.println("Nao foi possivel conectar ao BD!");
//			e.printStackTrace();
//		}
//        
		return null;
	}

	
	public void delete(Contato objectName, Long id) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
