import java.util.*;

public class AgendaMap extends Agenda {
	
    private Map listaContato = new HashMap();
	
    public Collection getColecao(){
    		return this.listaContato.values();
    }
    @Override
	
	
	public boolean adicionaContato(IF_Contato contato) {
		
		if (!this.listaContato.containsKey(contato.getTelefone())){
			this.listaContato.put(contato.getTelefone(), contato);
			return true;
		}else{
		// TODO Auto-generated method stub
			return false;
		}
	}

	@Override
	public IF_Contato getContatoPorTelefone(String telefone) {
		// TODO Auto-generated method stub
		return (IF_Contato)this.listaContato.get(telefone);
	}

	

	@Override
	public boolean removeContato(String telefone) {
		// TODO Auto-generated method stub
		if (this.listaContato.containsKey(telefone)){
			this.listaContato.remove(telefone);
			return true;
		}else{
			return false;
		}
		 
	}

	
	public static void main(String args[]){
		
	    Agenda agenda = new AgendaMap();
	
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
