/*
 * Conta Poupança
 * @author Walter GAndarella
 *
 */
public class ContaPoupanca extends Conta {

	private double indice;
	
	/*
	 * Chama o construtor
	 * @param _numero	Número da conta
	 * @param _saldo	Saldo da conta
	 */
	public ContaPoupanca(String _numero, double _saldo, double _indice) {
		super(_numero, _saldo);
		this.indice = _indice;
	}

	/**
	 * Aplica a taxa de dez reais * o índice
	 */
	public void taxa() {
		if (!super.debitoConta(10 * this.indice)){
			this.estado = Conta.BLOQ;
		}
	}
	
	/**
	 * Retorna o valor do índice
	 * @return double
	 */
	public double getIndice(){
		return this.indice;
	}
	
	/**
	 * Imprime o estado da conta
	 */
	public String toString(){
		return "Conta Poupança "+super.toString();
	}
}
/*
* Sobrecarga está nos construtores
* Polimorfismo está na taxa
*/