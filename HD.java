
public class HD extends MemoriaS {
	
	private String numeroSerie;

	public HD(String newNumeroSerie, int newTotal, int newUnidade) {
		super(newTotal, newUnidade);
		this.numeroSerie = newNumeroSerie;
	}

	public double getPerda() {
		return (this.total / 10240) / 100;
	}

	public double getEspacoDisponivelRealKB() {
		//return this.getEspacoDisponivelKB() * (1 - (this.getEspacoDisponivelKB() * this.getPerda()));
		return this.getEspacoDisponivelKB() - ((this.getEspacoDisponivelKB() * this.getPerda()) / 100);
	}
	
	public String getNumeroSerie(){
		return this.numeroSerie;
	}
	
	public String toString(){
		 String _tmp = "HD Número de Serie " + this.numeroSerie + "\n";
		_tmp += "Percentual Disponível " + this.getPercentualDisponivel() + "%\n";
		_tmp += "Espaço Total " + this.total + "KB\n";
		_tmp += "Espaço Disponível Real " + this.getEspacoDisponivelRealKB() + "KB\n";
		_tmp += "Espaço utilizado " + this.getUtilizadoKB() + "\n";
		_tmp += "Perda " + this.getPerda() + "%";
		
		return _tmp;
	}

}
