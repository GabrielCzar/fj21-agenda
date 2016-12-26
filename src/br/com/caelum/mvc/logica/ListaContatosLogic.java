package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;
import br.com.caelum.mvc.logica.interfaces.ILogica;
//import br.com.caelum.pages.Pages;

public class ListaContatosLogic implements ILogica {

	private static final String listaContatosLogicURL = "mvc?logica=ListaContatosLogic";
	
	public static String getListarContatosURL(){
		return listaContatosLogicURL;
	}
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
	        throws Exception {

		Connection connection = (Connection) req
                .getAttribute("conexao");
		
		List<Contato> contatos = new ContatoDao(connection).getLista();
	    
	    req.setAttribute("contatos", contatos);
	    
	    //return Pages.getListarcontatos();
	    return "WEB-INF/jsp/listar-contatos.jsp";
	}
}
