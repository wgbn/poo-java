
public class ImpostoCompleto extends ImpostoRenda {

	private double gastoEducacao;
	private double gastoSaude;
	
	public ImpostoCompleto(double _rendaBruta, int _ano){
		super(_rendaBruta, _ano);
		this.gastoEducacao	= _rendaBruta * .1;
		this.gastoSaude		= this.gastoEducacao;
	}
	
	public ImpostoCompleto(double _rendaBruta, int _ano, double _gastoEducacao, double _gastoSaude) {
		super(_rendaBruta, _ano);
		this.gastoEducacao	= _gastoEducacao;
		this.gastoSaude		= _gastoSaude;
	}
	
	public double getGastoEducacao(){
		return this.gastoEducacao;
	}
	
	public double getGastoSaude(){
		return this.gastoSaude;
	}

	public double calculo() {
		if (this.rendaBruta >= 100000)
			this.valorPagar = this.rendaBruta * .27;
		else if (this.rendaBruta < 50000)
			this.valorPagar = this.rendaBruta * .12;
		else
			this.valorPagar = this.rendaBruta * .23;
		
		return this.valorPagar - this.gastoEducacao - this.gastoSaude;
	}

}
