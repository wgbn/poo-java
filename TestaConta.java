
public class TestaConta {
	
	public static void taxaImprimeConta(Conta conta){
		conta.taxa();
		System.out.println(conta);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Conta conta		= new ContaCorrente("A-001", 100);
		Conta poupanca	= new ContaPoupanca("P-XXX", 100, 1.10);
		
		for (int _i = 1; _i <= 12; _i++){
			System.out.println("Mês: "+_i);
			TestaConta.taxaImprimeConta(conta);
			TestaConta.taxaImprimeConta(poupanca);
			
			System.out.println("Índice da conta poupança: "+((ContaPoupanca)poupanca).getIndice()+"\n");
		}
	}

}
