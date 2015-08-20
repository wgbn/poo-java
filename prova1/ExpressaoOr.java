package prova1;

public class ExpressaoOr extends ExpressaoBooleana {

	public boolean getValor(boolean _valor1, boolean _valor2) {
		return (_valor1 || _valor2 ? true : false);
	}
	
	public boolean getNegacaoValor(boolean _valor1, boolean _valor2){
		return !this.getValor(_valor1, _valor2);
	}

}