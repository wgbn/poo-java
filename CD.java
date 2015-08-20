
public class CD extends MemoriaS {
	
	public static final int ABERTO	= 1;
	public static final int FECHADO = 0;
	
	private int estado;

	public CD(int newTotal, int newUnidade) {
		super(newTotal, newUnidade);
		this.estado = ABERTO;
	}

	public double getPerda() {
		return .98;
	}

	public double getEspacoDisponivelRealKB() {
		return this.total * this.getPerda();
	}
	
	public boolean GravaKB(int newTamanho){
		if (this.estado == ABERTO)
			return super.GravaKB(newTamanho);
		else
			return false;
	}

	public String getEstado(){
		if (this.estado == ABERTO)
			return "ABERTO";
		else
			return "FECHADO";
	}
	
	public String toString(){
		String _tmp = "CD Estado " + this.getEstado() + "\n";
		_tmp += "Percentual Disponível " + this.getPercentualDisponivel() + "%\n";
		_tmp += "Espaço Total " + this.total + "KB\n";
		_tmp += "Espaço Disponível Real " + this.getEspacoDisponivelRealKB() + "KB\n";
		_tmp += "Perda " + (100 - (100 * this.getPerda())) + "%";
		
		return _tmp;
	}

}
