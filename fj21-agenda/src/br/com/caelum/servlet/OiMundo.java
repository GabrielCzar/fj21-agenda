package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.ConnectionFactory;

@WebServlet(urlPatterns = {"/oi", "/ola"}, name = "HelloWorld")
public class OiMundo extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

	    out.println("<html>");
	    out.println("<head>");
	    out.println("<title>Primeira Servlet</title>");
	    out.println("</head>");
	    
	    out.println("<body>");
	    out.println("<h1>Oi mundo Servlet!</h1>");
	    out.println("</body>");
	    out.println("</html>");
	    
	    Connection connection = new ConnectionFactory().getConnection();
		System.out.println("Conexão aberta!");
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    
	}
}
