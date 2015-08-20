package aplicacao;
import java.util.*;


public class AgendaList implements IF_Agenda{
	
	private List listaContato = new ArrayList(); 
	
	private int localizaContato(String telefone){
		    IF_Contato contato_ = new Contato();
		    contato_.setTelefone(telefone);
		  	return this.listaContato.indexOf(contato_);
	}
	
	public  IF_Contato getContato(String telefone){
		    return (IF_Contato) this.listaContato.get(this.localizaContato(telefone));
	}	
	public boolean adicionaContato(IF_Contato contato_){
		
		   if (localizaContato(contato_.getTelefone())==-1){
		
		  	 	this.listaContato.add(contato_);
		 	 	return true;
		   }else {
		   		return false;
		   }
		
		
	}	
	
	
	public boolean removeContato(String telefone){
		int i = localizaContato(telefone);
		if (i==-1){
		
		  	 
		 	 	return false;
		}else {
		   	    this.listaContato.remove(i); 
		   		return true;
		}
		   
	}
	
	
	
	public String toString(){
		String temp ="Lista de Contatos \n";
	
		Iterator it = this.listaContato.iterator();
		while (it.hasNext()){
			IF_Contato c =(IF_Contato) it.next();
			temp =temp+ "Nome:"+c.getNome()+"\n Telefone:"+c.getTelefone()+"\n";
		}	
			
		return temp;	
	}
		
	
	public Collection getListaAgenda(){
		return this.listaContato;
	}

	
	public static void main(String args[]){
		
		AgendaList agenda = new AgendaList();
		
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