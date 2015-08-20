package aplicacao;
import java.util.*;


public class AgendaMap implements IF_Agenda{
	
	private Map listaContato = new HashMap(); 
	
	
	
	public  IF_Contato getContato(String telefone){
		    return (IF_Contato) this.listaContato.get(telefone);
	}	
	public boolean adicionaContato(IF_Contato contato_){
		
		   if (!(this.listaContato.containsKey(contato_.getTelefone()))){
		
		  	 	this.listaContato.put(contato_.getTelefone(),contato_);
		 	 	return true;
		   }else {
		   		return false;
		   }
		
		
	}	
	
	
	public boolean removeContato(String telefone){
		
		
		if (this.listaContato.containsKey(telefone)){
			
			  	 	this.listaContato.remove(telefone);
			 	 	return true;
			   }else {
			   		return false;
			   }
		
		   
	}
	
	
	
	public Collection getListaAgenda(){
		return this.listaContato.values();
	}

	
	
	
	public String toString(){
		String temp ="Lista de Contatos \n";
	
		Iterator it = this.listaContato.values().iterator();
		while (it.hasNext()){
			IF_Contato c =(IF_Contato) it.next();
			temp =temp+ "Nome:"+c.getNome()+"\n elefone:"+c.getTelefone()+"\n";
		}	
			
		return temp;	
	}
		
	
	public Collection listaContato(){
		return this.listaContato.values();
	}
	
	public static void main(String args[]){
	
		
		AgendaMap agenda = new AgendaMap();
		
		IF_Contato[] contatos= new IF_Contato[3];
		
		contatos[0] = new Contato();
		contatos[0].setNome("A");
		contatos[0].setTelefone("345-2455");
		
		System.out.println("Adicionando " +  contatos[0]);
		agenda.adicionaContato(contatos[0]);
		
		contatos[1] = new Contato();
		contatos[1].setNome("X");
		contatos[1].setTelefone("234-9085");
		
		System.out.println("Adicionando " +  contatos[1]);
		agenda.adicionaContato(contatos[1]);
		
		
		
	    contatos[2] = new Contato();
		contatos[2].setNome("Y");
		contatos[2].setTelefone("8890-19085");
		
		System.out.println("Adicionando " +  contatos[2]);
		
		agenda.adicionaContato(contatos[2]);
		
		
		System.out.println(agenda);
		
		System.out.println("Localizando 345-2455");
		
		
		System.out.println(agenda.getContato("345-2455"));
		
		System.out.println("Removendo 234-9085");
		
		agenda.removeContato("234-9085");
		
		System.out.println(agenda);
	}
}