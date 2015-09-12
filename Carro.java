import java.util.Scanner;


public class Carro {

	private String placa;
	private double reserva, consumo, quantidade;
	//private Scanner teclado = new Scanner(System.in);
	
	public double getConsumo(){
		return this.consumo;
	}
	
	public double getQuantidade(){
		return this.quantidade;
	}
	
	public String getPlaca(){
		return this.placa;
	}
	
	public void setConsumo(){
		//System.out.println("Digite o consumo:");
		//this.consumo = this.teclado.nextFloat();
		this.consumo = Console.readDouble("Digite o consumo:");
	}
	
	public void setQuantidade(){
		//System.out.println("Digite a quantidade:");
		//this.quantidade = this.teclado.nextFloat();
		this.quantidade = Console.readDouble("Digite a quantidade:");
	}
	
	public void setPlaca(){
		//System.out.println("Digite a placa:");
		//this.placa = this.teclado.next();
		this.placa = Console.readString("Digite a placa:");
	}
	
	public double autonomiaKm(){
		if (this.consumo > 0 && this.quantidade > 0){
			return this.consumo * this.quantidade;
		} else {
			return 0;
		}
	}
	
	public double kmParaReserva(){
		if (this.consumo > 0 && this.quantidade > 0){
			return (this.autonomiaKm() - (this.quantidade * this.reserva));
		} else {
			return 0;
		}
	}
	
	public void mostraAutonomia(){
		if (this.consumo > 0 && this.quantidade > 0){
			System.out.println("Placa: "+this.placa);
			System.out.println("Consumo: "+this.autonomiaKm()+"km");
			System.out.println("Consumo até reserva: "+(this.autonomiaKm() - this.kmParaReserva())+"km");
		} else {
			System.out.println("Faltou definir os parametros");
		}
	}
	
	public Carro(){
		this.consumo = 0;
		this.quantidade = 0;
		this.placa = "";
		this.reserva = 8;
	}
	
	public Carro(String p){
		this();
		this.placa = p;
	}
	
	public Carro(String p, float c, float q){
		this(p);
		this.consumo = c;
		this.quantidade = q;
	}

	public static void main(String[] args) {
		Carro carro1 = new Carro();
		
		carro1.setPlaca();
		carro1.setConsumo();
		carro1.setQuantidade();
		carro1.mostraAutonomia();
	}

}
