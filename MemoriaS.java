
public abstract class MemoriaS {
	
	public static final int BYTE = 1;
	public static final int KB	 = 2;
	public static final int MB	 = 3;
	public static final int GB	 = 4;
	
	protected double 	total;
	protected double	utilizadoKb;
	protected int		unidade;
	
	protected double getEspacoDisponivelKB(){
		return this.total - this.utilizadoKb;
	}
	
	protected double getConverteKB(double _valor){
		switch (this.unidade) {
		case BYTE:
			_valor = _valor / 1024;
			break;
			
		case MB:
			_valor = _valor * 1024;
			break;
			
		case GB:
			_valor = _valor * 1048576;
			break;
		}
		
		return _valor;
	}
	
	abstract double getPerda();
	
	abstract double getEspacoDisponivelRealKB();
	
	public double getUtilizadoKB(){
		return this.utilizadoKb;
	}
	
	public boolean GravaKB(int newTamanho){
		if (this.getEspacoDisponivelRealKB() >= this.getConverteKB(newTamanho)){
			this.utilizadoKb += this.getConverteKB(newTamanho);
			return true;
		} else
			return false;
	}
	
	public String getUnidade(){
		String _tmp;
		
		switch (this.unidade) {
		case BYTE:
			_tmp = "BYTE";
			break;
			
		case KB:
			_tmp = "KILOBYTE";
			break;
			
		case MB:
			_tmp = "MEGABYTE";
			break;
			
		case GB:
			_tmp = "GIGABYTE";
			break;
			
		default:
			_tmp = "";
		}
		
		return _tmp;
	}
	
	public double getPercentualDisponivel(){
		return (this.getEspacoDisponivelRealKB() / this.total) * 100;
	}
	
	public String toString(){
		String _tmp = "Percentual Disponível " + this.getPercentualDisponivel() + "%\n";
		_tmp += "Espaço Total " + this.total + "KB\n";
		_tmp += "Espaço Disponível Real " + this.getEspacoDisponivelRealKB() + "KB\n";
		_tmp += "Perda " + this.getPerda() + "%";
		
		return _tmp;
	}

	public MemoriaS(int newTotal, int newUnidade){
		this.utilizadoKb	= 0;
		this.unidade 		= newUnidade;
		this.total			= this.getConverteKB(newTotal);
	}
	
	public MemoriaS(int newTotal){
		this(newTotal, KB);
	}

}
