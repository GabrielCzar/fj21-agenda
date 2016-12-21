package br.com.caelum.mvc.logica;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class ListaContatosLogic implements ILogica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
	        throws Exception {

	      // Monta a lista de contatos
		  ContatoDao contatoDao = new ContatoDao();
	      List<Contato> contatos = contatoDao.getLista();

	      // Guarda a lista no request
	      req.setAttribute("contatos", contatos);
	  
	      return "lista-contatos.jsp";
	}
}
