package aplicacao;
public class Contato implements IF_Contato{
	
	private String nome;
	private String telefone;
	
	public String getNome(){
		return this.nome;
	}
	
	public String getTelefone(){
		return this.telefone;
	}
	
	public void setNome(String nome_){
		 this.nome = nome_;
	}	
	
	public void setTelefone(String telefone_){
		this.telefone = telefone_;
	}
	
	
	public boolean equals(Object o){
		Contato contato_ = (Contato) o;
		return this.telefone.equals(contato_.getTelefone());
	}
	
	public String toString(){
		
		return this.nome + "/"+ this.telefone;
	}
}	