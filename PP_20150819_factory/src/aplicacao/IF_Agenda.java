package aplicacao;

import java.util.Collection;

public interface IF_Agenda {
	
	
	
	public  IF_Contato getContato(String telefone);
	
	
	public boolean adicionaContato(IF_Contato contato_);
	
	
	public boolean removeContato(String telefone);
	
	public Collection getListaAgenda();
	
	public String toString();
		   
}