
public class Jogador {

	private String nome;
	
	private static void print(String string){
		System.out.println(string + "\n");
	}
	
	public Jogador(String _nome) {
		this.nome = _nome;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public static void main(String[] args){
		Jogador jogador1 = new Jogador("Eduardo");
		Jogador jogador2 = new Jogador("Camila");
		
		JogoDado jogo1 = new JogoUmDado(jogador1, jogador2);
		JogoDado jogo2 = new JogoDoisDados(jogador1, jogador2);
		
		int count = 0;
		while(count++ < 10){
		   print(count+" Jogada "+jogo1.jogada());
		}
 		print("Jogo Um Dado "+jogo1.getPlacar());
 		print(jogo1.toString());

		count = 0;

		while(count++ < 10){
           print(count+" Jogada "+jogo2.jogada());
		}
		print("Jogo Dois Dados "+jogo2.getPlacar());
		print(jogo2.toString());
	}

}
