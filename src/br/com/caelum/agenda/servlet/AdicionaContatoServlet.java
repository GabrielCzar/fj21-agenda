package br.com.caelum.agenda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;
import br.com.caelum.mvc.logica.ListaContatosLogic;

@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
                        HttpServletResponse response)
                        throws IOException, ServletException {
        // busca o writer
        PrintWriter out = response.getWriter();
                        
        // buscando os parâmetros no request
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String email = request.getParameter("email");
        String dataEmTexto = request
                .getParameter("dataNascimento");
        Calendar dataNascimento = Calendar.getInstance();
        
        // fazendo a conversão da data
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy")
                    .parse(dataEmTexto);
            dataNascimento.setTime(date);
        } catch (ParseException e) {
            out.println("Erro de conversão da data");
            return; //para a execução do método
        }
        
        // monta um objeto contato
        Contato contato = new Contato();
        contato.setNome(nome);
        contato.setEndereco(endereco);
        contato.setEmail(email);
        contato.setDataNascimento(dataNascimento);
        
        // salva o contato
        ContatoDao dao = new ContatoDao();
        dao.adiciona(contato);
        
        // OLD
        //imprime o nome do contato que foi adicionado
        //out.println("<html>");
        //out.println("<body>");
        //out.println("Contato " + contato.getNome() +
        //        " adicionado com sucesso");
        //out.println("</body>");
        //out.println("</html>");
        
        RequestDispatcher rd = request.getRequestDispatcher(ListaContatosLogic.getListarContatosURL());
        
        rd.forward(request,response);
    }
}
