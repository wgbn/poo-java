/**
 * Conta Corrente
 * @author Walter Gandarella
 *
 */
public class ContaCorrente extends Conta {

	/**
	 * Chama o construtor
	 * @param _numero	Número da conta
	 * @param _saldo	Saldo da conta
	 */
	public ContaCorrente(String _numero, double _saldo) {
		super(_numero, _saldo); // chama construtor da superclasse
	}

	/**
	 * Aplica a taxa de dez reais
	 */
	public void taxa() {
		if (!this.debitoConta(10)){
			this.estado = Conta.BLOQ;
		}
	}
	
	/**
	 * Imprime o estado da conta
	 */
	public String toString(){
		return "Conta Corrente "+super.toString();
	}
}
