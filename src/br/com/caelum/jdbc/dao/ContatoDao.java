package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.modelo.Contato;

public class ContatoDao {
	
	private Connection connection;
	
	public ContatoDao(Connection connection) {
		this.connection = connection;
	}
	
	public void adiciona(Contato contato){
		String sql = "insert into contato (nome,email,endereco,dataNascimento) values (?,?,?,?)";
		
		try {
	        // prepared statement para inserção
	        PreparedStatement stmt = connection.prepareStatement(sql);

	        // seta os valores

	        stmt.setString(1,contato.getNome());
	        stmt.setString(2,contato.getEmail());
	        stmt.setString(3,contato.getEndereco());
	        stmt.setDate(4, new Date(
	                contato.getDataNascimento().getTimeInMillis()));

	        // executa
	        stmt.execute();
	        stmt.close();
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}

	public List<Contato> getLista() {
		try{
			PreparedStatement stmt = connection.prepareStatement("select * from contato");
	
			// executa um select
			ResultSet rs = stmt.executeQuery();
	
			// itera no ResultSet
			
			ArrayList<Contato> contatos = new ArrayList<>();
			while (rs.next()) {
				Long id = rs.getLong("id");
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				String endereco = rs.getString("endereco");
				//Criando data atraves do calendar
				Calendar dataNascimento = Calendar.getInstance(); 
				dataNascimento.setTime(rs.getDate("dataNascimento"));
				
				contatos.add(new Contato(id, nome, email, endereco, dataNascimento));
			}
			rs.close();
			stmt.close();
			return contatos;
		}catch (Exception e){ 
			throw new RuntimeException(e);
		}
	}

	public void altera(Contato contato) {
	     String sql = "update contatos set nome=?, email=?, endereco=?, dataNascimento=? where id=?";
	     try {
	         PreparedStatement stmt = connection.prepareStatement(sql);
	         stmt.setString(1, contato.getNome());
	         stmt.setString(2, contato.getEmail());
	         stmt.setString(3, contato.getEndereco());
	         stmt.setDate(4, new Date(contato.getDataNascimento()
	                 .getTimeInMillis()));
	         stmt.setLong(5, contato.getId());
	         stmt.execute();
	         stmt.close();
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }
	
	public void delete(Contato contato) {
		try {
	         PreparedStatement stmt = connection.prepareStatement("delete from contato where id=?");
	         stmt.setLong(1, contato.getId());
	         stmt.execute();
	         stmt.close();
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	}

}
