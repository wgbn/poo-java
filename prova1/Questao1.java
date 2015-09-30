package prova1;

public class Questao1 {
	
	public static void TestaExpresso(ExpressaoBooleana eb){
		System.out.println(eb.getValor(false,true));
	}
	
	public static void main(String args[]){
		ExpressaoBooleana eb1 = new ExpressaoAnd();
		ExpressaoBooleana eb2 = new ExpressaoOr();
		
		Questao1.TestaExpresso(eb1);
		Questao1.TestaExpresso(eb2);
		
		System.out.println( ((ExpressaoOr)eb2).getNegacaoValor(false, false) );
	}
	
}
