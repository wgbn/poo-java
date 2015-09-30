
public class JogoUmDado extends JogoDado {

	public JogoUmDado(Jogador _jogador1, Jogador _jogador2) {
		super(_jogador1, _jogador2);
	}

	public int getValorDado() {
		return (new Float((Math.random()*6+1))).intValue();
	}

}
