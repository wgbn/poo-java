import java.util.*;


public abstract class Agenda {
	
    public abstract boolean adicionaContato(IF_Contato contato);
	
	public abstract IF_Contato getContatoPorTelefone(String telefone);
	
	public IF_Contato getContatoPorNome(String nome){
		
		Iterator it = this.getColecao().iterator();
		while (it.hasNext()){
			IF_Contato c = (IF_Contato) it.next();
			
			if (c.getNome().equals(nome)){
				return c;
			}
		}
		
		return null;
		
	}
	
	public List getContatoPorInicias(String iniciais){
		List temp = new ArrayList();
		
		Iterator it = this.getColecao().iterator();
		while (it.hasNext()){
			IF_Contato c = (IF_Contato) it.next();
			if (c.getNome().startsWith(iniciais)){
				temp.add(c);
			}
		}
		// TODO Auto-generated method stub
		return temp;
		
	}
	
	public abstract boolean removeContato(String telefone);
	
	public String listaContatos(){
		    String temp = "Lista de Contatos \n";
			
			Iterator it = this.getColecao().iterator();
			while (it.hasNext()){
				IF_Contato c = (IF_Contato) it.next();
			    temp = temp +c+ "\n";
			}
			// TODO Auto-generated method stub
			return temp;
	}
	
	public abstract Collection getColecao();
	

}
