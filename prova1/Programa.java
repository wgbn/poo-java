package prova1;

public abstract class Programa {
	
	// constantes
	protected static final int JAVA	= 0;
	protected static final int C		= 1;
	protected static final int O		= 2;
	protected static final int EXE		= 3;
	protected static final int CLASS	= 4;
	
	// atributos
	protected Arquivo arquivo;
	
	public Programa(Arquivo _arquivo){
		this.arquivo = _arquivo;
	}
	
	public abstract Arquivo compilado();

	public String toString() {
		return "Programa: "+this.arquivo.toString()+"\n  Compilado: "+this.compilado().toString();
	}
	
	public static String getTipo(int tipo){
		switch(tipo){
			case Programa.JAVA:
				return "java";
			case Programa.C:
				return "c";
			case Programa.O:
				return "o";
			case Programa.EXE:
				return "exe";
			case Programa.CLASS:
				return "class";
			default:
				return "TIPO INDEFINIDO";
		}
	}
	
}
