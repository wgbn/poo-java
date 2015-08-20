
public class ImpostoSimplificado extends ImpostoRenda {

	public ImpostoSimplificado(double _rendaBruta, int _ano) {
		super(_rendaBruta, _ano);
	}

	public double calculo() {
		this.valorPagar = rendaBruta * .15;
		return this.valorPagar;
	}

}
