package prova1;

public class ProgramaC extends Programa {

	public ProgramaC(Arquivo _arquivo) {
		super(_arquivo);
	}

	public Arquivo compilado() {
		Arquivo obj = this.compiladoObjeto();
		return new Arquivo(obj.getNome(), obj.getTexto()+" código executável", Programa.getTipo(EXE));
	}
	
	public Arquivo compiladoObjeto(){
		return new Arquivo(this.arquivo.getNome(), this.arquivo.getTexto()+" código objeto", Programa.getTipo(O));
	}

	public String toString() {
		return super.toString()+"\n  Objeto: "+this.compiladoObjeto().toString();
	}

}
