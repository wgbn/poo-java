public class MeusCarros {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Carros c1 = new CarroNormal("KJH5345",10,40);
		Carros.ImprimeKm(c1);
		
		Carros c2 = new CarroFlexPower("KJH5345",10,20,20);
		Carros.ImprimeKm(c2);
		
		System.out.println(((CarroFlexPower)c2).getCombustivelAlcool());
		System.out.println(((CarroFlexPower)c2).getCombustivelGasolina());
	}

}
