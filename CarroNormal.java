public class CarroNormal extends Carros {

	private int combustivel;
	
	public CarroNormal(String _placa, int _consumo, int _combustivel) {
		super(_placa, _consumo);
		this.combustivel = _combustivel;
	}
	
	public CarroNormal(String _placa, int _combustivel){
		this(_placa, 10, _combustivel);
	}

	public double getKm(){
		return this.consumo * this.combustivel;
	}
}
