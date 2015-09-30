
public abstract class ImpostoRenda {

	protected double valorPagar;
	protected double rendaBruta;
	protected int ano;
	
	public ImpostoRenda(double _rendaBruta, int _ano){
		this.rendaBruta	= _rendaBruta;
		this.ano		= _ano;
	}
	
	public double getRendaBruta(){
		return this.rendaBruta;
	}
	
	public int getAno(){
		return this.ano;
	}
	
	public double getValorPagar(){
		return this.valorPagar;
	}
	
	public abstract double calculo();
	
	public boolean processamento(int _anoBase){
		if (_anoBase == this.ano && this.rendaBruta > 12000){
			this.valorPagar = this.calculo();
			return true;
		} else
			return false;
	}

}
