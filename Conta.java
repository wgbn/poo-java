/**
 * Classe Conta
 * @author walter Gandarella
 */
public abstract class Conta {
	public static final int OK		= 0;
	public static final int BLOQ	= 1;
	
	private String	numero;
	private double	saldo;
	private double	limite;
	protected int	estado;
	
	/**
	 * Construtor da classe
	 * @param _numero	Número da conta
	 * @param _saldo	Saldo da conta
	 * @param _limite	Limite da conta
	 */
	public Conta(String _numero, double _saldo, double _limite){
		this.numero	= _numero;
		this.saldo	= _saldo;
		this.limite	= _limite;
		this.estado	= Conta.OK;
	}
	
	/**
	 * Este construtor chama o primeiro e define o limite como 10% do saldo
	 * @param _numero	Número da conta
	 * @param _saldo	Saldo da conta
	 */
	public Conta(String _numero, double _saldo){		
		this(_numero, _saldo, _saldo * .1);
	}
	
	/**
	 * Faz o crédito na conta
	 * @param _valor	Valor a ser creditado na conta
	 * @return			TRUE caso o crédito seja feito e FALSE caso algo saia errado
	 */
	public boolean creditoConta(double _valor){
		if (this.estado == Conta.OK){
			this.saldo += _valor;
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Faz o débito na conta
	 * @param _valor	Valor a ser retirado da conta
	 * @return			TRUE caso o débito seja feito e FALSE caso algo saia errado
	 */
	public boolean debitoConta(double _valor){
		if ((this.estado == Conta.OK) && (this.saldo + this.limite) >= _valor){
			this.saldo -= _valor;
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Imprime o estado da conta
	 */
	public String toString(){
		return	"Nº "+this.numero+" está atualmente:\n"+
				"Saldo:\t"+this.saldo+"\n"+
				"Limite:\t"+this.limite+"\n"+
				"Estado:\t"+(this.estado == Conta.OK ? "OK" : "BLOQ")+"\n";
	}
	
	public abstract void taxa();
}
