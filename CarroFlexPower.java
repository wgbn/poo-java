public class CarroFlexPower extends Carros {
	private int combustivelAlcool;
	private int combustivelGasolina;
	
	public CarroFlexPower(String _placa, int _consumo, int _alcool, int _gasolina) {
		super(_placa, _consumo);
		this.combustivelAlcool		= _alcool;
		this.combustivelGasolina	= _gasolina;
	}

	public double getCombustivelAlcool(){
		return this.combustivelAlcool;
	}
	
	public double getCombustivelGasolina(){
		return this.combustivelGasolina;
	}
	public double getKm(){
		return ((this.consumo * .7) * this.combustivelAlcool) + (this.consumo * this.combustivelGasolina);
	}
}
