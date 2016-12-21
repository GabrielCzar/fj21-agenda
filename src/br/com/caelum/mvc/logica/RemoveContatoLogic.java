package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;
import br.com.caelum.mvc.logica.interfaces.ILogica;

public class RemoveContatoLogic implements ILogica {
	
	private static final String parId = "id";
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		long id = Long.parseLong(req.getParameter(parId));

	    Contato contato = new Contato();
	    contato.setId(id);

	    ContatoDao dao = new ContatoDao();
	    dao.delete(contato);

	    System.out.println("Excluindo contato...");

	    return ListaContatosLogic.getListarContatosURL();
	    
	}

}
