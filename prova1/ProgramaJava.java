package prova1;

public class ProgramaJava extends Programa {

	public ProgramaJava(Arquivo _arquivo) {
		super(_arquivo);
	}

	public Arquivo compilado() {
		return new Arquivo(this.arquivo.getNome(), this.arquivo.getTexto()+" código class", Programa.getTipo(CLASS));
	}

}
