package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.bd.ContatoDao;

@WebServlet("/contatos")
public class mostrarContatosServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

	    out.println("<html>");
	    out.println("<head>");
	    out.println("<title>Primeira Servlet</title>");
	    out.println("</head>");
	    
	    out.println("<body>");
	    
	    ContatoDao contato = new ContatoDao();
	    List<String> lista = contato.readAll();
	    for (String nome : lista) {
	    	out.println("<h1>");
	    	out.println(nome);
	    	out.println("</h1><br />");
		}
	    
	    
	    out.println("</body>");
	    out.println("</html>");
	}
}
