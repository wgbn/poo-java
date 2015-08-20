import java.util.ArrayList;
import java.util.List;

import java.util.*;

public class AgendaList extends Agenda {
	
	private List listaContatos = new ArrayList();
    
	public Collection getColecao(){
		return this.listaContatos;
	}
	
	@Override
	public boolean adicionaContato(IF_Contato contato) {
		
		if ( !this.listaContatos.contains(contato)){
			this.listaContatos.add(contato);
			return true;
			
		}else{
		// TODO Auto-generated method stub
			return false;
		}
	}

	
	public IF_Contato getContatoPorTelefone(String telefone) {
		
		IF_Contato c = new Contato();
		c.setTelefone(telefone);
		int i = this.listaContatos.indexOf(c);
		if (i==-1){
			return null;
		}else{
			return (IF_Contato) this.listaContatos.get(i);
		}
		
		
	}
	

	@Override
	public boolean removeContato(String telefone) {
		
		
		// TODO Auto-generated method stub
		IF_Contato c = (IF_Contato) this.getContatoPorTelefone(telefone);
		if (c!=null){
			this.listaContatos.remove(c);
			return true;
		}else{
			return false;
		}
	}


	
	
	public static void main(String args[]){
			
		    Agenda agenda = new AgendaList();
		
		    IF_Contato[] c= new IF_Contato[100];
	
			c[0] = new Contato();
	        c[0].setNome("A");
	        c[0].setTelefone("8899-9089");
	        
	         agenda.adicionaContato(c[0]);
	        
	        c[1] = new Contato();
	        c[1].setNome("B");
	        c[1].setTelefone("8899-9089");
	        agenda.adicionaContato(c[1]);
	        
		
	        
	        c[2] = new Contato();
	        c[2].setNome("C");
	        c[2].setTelefone("5365-3243");
	        
	        agenda.adicionaContato(c[2]);
	        
	        c[3] = new Contato();
	        c[3].setNome("Ab");
	        c[3].setTelefone("3438-3434");
	        
	        agenda.adicionaContato(c[3]);
	        
	        System.out.println(agenda.getContatoPorTelefone("5365-3243"));
	        System.out.println(agenda.getContatoPorNome("C"));
	        System.out.println(agenda.getContatoPorInicias("A"));
	        
	        agenda.removeContato("3438-3434");
	        
	        
	        System.out.println(agenda.listaContatos());
	        
	        
	        
	}
	

}
