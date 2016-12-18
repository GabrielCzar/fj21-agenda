package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import br.com.caelum.jbdc.Contato;

@WebServlet("/adicionaContato")
public class adicionaContatoServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			
			PrintWriter out = response.getWriter();
         
	        // pegando os parâmetros do request
	        String nome = request.getParameter("nome");
	        String endereco = request.getParameter("endereco");
	        String email = request.getParameter("email");
	        String dataEmTexto = request.getParameter("dataNascimento");
	        Calendar dataNascimento = null;
	        
	        // fazendo a conversão da data
	        try {
	        	Date date;
				date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto); 
	            dataNascimento = Calendar.getInstance();
	            dataNascimento.setTime(date);
	        } catch (ParseException e) {
	            out.println("Erro de conversão da data");
	            return; //para a execução do método
	        }catch (java.text.ParseException e) {
				e.printStackTrace();
			}
	        
	        // monta um objeto contato
	        Contato contato = new Contato();
	        contato.setNome(nome);
	        contato.setEndereco(endereco);
	        contato.setEmail(email);
	        contato.setDataNascimento(dataNascimento);
	        
	        // salva o contato 
	        //?? ContatoDao......
	        
	        // imprime o nome do contato que foi adicionado
	        out.println("<html>");
	        out.println("<body>");
	        out.println("Contato " + contato.getNome() + 
	                " adicionado com sucesso");    
	        out.println("</body>");
	        out.println("</html>");
	 }
}
