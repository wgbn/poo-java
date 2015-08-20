public class Contato implements IF_Contato {
	
	private String nome;
	private String telefone;

	public Contato(){
		this.nome 		= null;
		this.telefone 	= null;
	}
	
	public Contato(String _nome, String _telefone) {
		this.nome 		= _nome;
		this.telefone 	= _telefone;
	}

	public String getNome() {
		return this.nome;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setNome(String _nome) {
		this.nome = _nome;
	}

	public void setTelefone(String _telefone) {
		this.telefone = _telefone;
	}

	public String toString() {
		return "Contato nome:" + nome + ", telefone:" + telefone;
	}

	public boolean equals(Object obj){
		return ((IF_Contato)obj).getTelefone().equals(this.telefone);
	}
	
	/*public static void main(String args[]){
		IF_Contato[] c = new IF_Contato[3];
		
		c[0] = new Contato();
		c[0].setNome("Eduardo");
		c[0].setTelefone("9999-0000");
		
		c[1] = new Contato();
		c[1].setNome("Camila");
		c[1].setTelefone("8888-0000");
		
		c[2] = new Contato();
		c[2].setNome("Edu");
		c[2].setTelefone("9999-0000");
		
		System.out.println(c[0].equals(c[1]));
		System.out.println(c[0].equals(c[2]));
	}*/
}
