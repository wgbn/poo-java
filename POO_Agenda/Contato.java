
public class Contato implements IF_Contato{
	
	private String nome;
	private String telefone;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String toString(){
		return "Nome:"+this.nome+ " Telefone:"+this.telefone;
	}
	public boolean equals(Object o){
		Contato c = (Contato)o;
		
		return this.telefone.equals(c.getTelefone());
		
		
		
		//return this.telefone.equals( ((Contato)o).getTelefone());
	}
		
	
	public static void main(String args[]){
	        IF_Contato[] c = new IF_Contato[100];	
	        c[0] = new Contato();
	        c[0].setNome("A");
	        c[0].setTelefone("8899-9089");
	        
	        c[1] = new Contato();
	        c[1].setNome("B");
	        c[1].setTelefone("8899-9089");
	        
	        
	        System.out.println(c[0].equals(c[1]));
	        
	        
	        
	        
	}
	

}
