
public class TesteMemoria {
	
	private static void print(String string){
		System.out.println(string + "\n");
	}

	public static void main(String[] args) {
		MemoriaS hd = new HD("46327", 10, MemoriaS.MB);
		MemoriaS cd = new CD(650, MemoriaS.MB);
		
		// imprimir numero de serie do objeto hd
		print("No Serie HD: " + ((HD)hd).getNumeroSerie());
		// imprime o percentual de perda do objeto hd
		print("Percent de perda HD: " + ((HD)hd).getPerda());
		
		// imprime estado do objeto cd
		print("Estado CD: " + ((CD)cd).getEstado());
		
		// os metodos polimorficos
		print("Os métodos polimóficos são:\n- getPerda()\n- getEspacoDisponivelRealKB()\n- toString()");
		
		// testa outros métodos
		print(hd.toString());
		print(cd.toString());
		
		HD hd2 = new HD("125678", 2, HD.GB);
		print(hd2.toString());
		hd2.GravaKB(1);
		print(hd2.toString());
	}

}
