package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.mvc.logica.interfaces.ILogica;
//import br.com.caelum.pages.Pages;

public class PrimeiraLogica implements ILogica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("Executando a logica ...");
        
        System.out.println("Retornando o nome da página JSP ...");
        
        //return Pages.getFirstlogic();
        return "primeira-logica.jsp";
	}

}
