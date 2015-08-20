public abstract class Carros {
	protected String	placa;
	protected int		consumo;
	
	public static void ImprimeKm(Carros carro){
		System.out.println(carro.getKm()+"km");
	}
	
	public Carros(String _placa, int _consumo){
		this.placa		= _placa;
		this.consumo	= _consumo;
	}
	
	public abstract double getKm();
	
	public String toString(){
		return "Placa:\t"+this.placa+"\tKM:\t"+this.consumo;
	}
}
