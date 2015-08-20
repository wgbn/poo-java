
public abstract class JogoDado {

	protected Jogador	jogador1;
	protected Jogador	jogador2;
	protected int		vitorias1 = 0;
	protected int		vitorias2 = 0;
	protected int		empate = 0;
	
	public JogoDado(Jogador _jogador1, Jogador _jogador2) {
		this.jogador1 = _jogador1;
		this.jogador2 = _jogador2;
	}
	
	public abstract int getValorDado();	 

	public String jogada(){
		int dado1 = this.getValorDado();
		int dado2 = this.getValorDado();
		
		// comparar dado1 do jogador1 com dado2 do jogador2
		if (dado1 > dado2){ // jogador1 ganha
			this.vitorias1++;
			return "Vencedor Jogador1 " + this.jogador1.getNome() + " Dado1=" + dado1 + " Dado2=" + dado2;
		} else if (dado1 < dado2){ // jogador2 ganha
			this.vitorias2++;
			return "Vencedor Jogador2 " + this.jogador2.getNome() + " Dado1=" + dado1 + " Dado2=" + dado2;
		} else { // da empate
			this.empate++;
			return "Empate Dado1=" + dado1 + " Dado2=" + dado2;
		}
	}

	public String getPlacar(){
		if (this.vitorias1 > this.vitorias2)
			return "Vencedor Jogador1 " + jogador1.getNome() + " com " + this.vitorias1 + " vitorias";
		else
			return "Vencedor Jogador2 " + jogador2.getNome() + " com " + this.vitorias2 + " vitorias";
	}

	public String toString(){
		String _tmp = "Jogadas: " + (this.vitorias1 + this.vitorias2 + this.empate) + "\n";
		_tmp += "Jogador1(" + jogador1.getNome() + ") = " + this.vitorias1 + "\n";
		_tmp += "Jogador2(" + jogador2.getNome() + ") = " + this.vitorias2 + "\n";
		_tmp += "Empates = " + this.empate;
		
		return _tmp;
	}

}
