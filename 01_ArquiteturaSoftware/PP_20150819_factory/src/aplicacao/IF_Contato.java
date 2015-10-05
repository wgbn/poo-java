package aplicacao;
public interface IF_Contato {
	
	public String getNome();
	
	public String getTelefone();
	
	public void setNome(String nome_);
	
	public void setTelefone(String telefone_);
	
	
	public boolean equals(Object o);
	
	public String toString();
}