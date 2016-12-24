package br.com.caelum.mvc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.mvc.logica.interfaces.ILogica;

@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private static final String caelumlogica = "br.com.caelum.mvc.logica.";
	private static final String parLogica = "logica";
	
	protected void service(HttpServletRequest request,
            HttpServletResponse response) 
            throws ServletException, IOException {

        String parametro = request.getParameter(parLogica);
        String nomeDaClasse = caelumlogica + parametro;

        try {
            Class classe = Class.forName(nomeDaClasse);

            ILogica logica = (ILogica) classe.newInstance();
            String pagina = logica.executa(request, response);

  request.getRequestDispatcher(pagina).forward(request, response);

        } catch (Exception e) {
            throw new ServletException(
              "A lógica de negócios causou uma exceção", e);
        }
    }


        
}
