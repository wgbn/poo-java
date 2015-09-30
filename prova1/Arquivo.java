package prova1;

public class Arquivo {

	private String texto;
	private String nome;
	private String extensao;
	
	public Arquivo(String _nome, String _texto, String _extensao){
		this.nome		= _nome;
		this.texto		= _texto;
		this.extensao	= _extensao;
	}

	public String getTexto() {
		return this.texto;
	}

	public String getNome() {
		return this.nome;
	}

	public String getExtensao() {
		return this.extensao;
	}

	public String toString() {
		return "Nome: "+this.nome+"."+this.extensao+" Texto: "+this.texto;
	}
	
	public static void main(String args[]){
		Arquivo arquivoJava = new Arquivo("Carro", "public class Carro{ }", Programa.getTipo(Programa.JAVA));
		Programa programaJava = new ProgramaJava(arquivoJava);
		
		Arquivo aqruivoC = new Arquivo("Soma", "#include stdio.h int x, y ", Programa.getTipo(Programa.C));
		Programa programaC = new ProgramaC(aqruivoC);
		
		System.out.println(programaJava);
		System.out.println(programaC);
	}
	
}
