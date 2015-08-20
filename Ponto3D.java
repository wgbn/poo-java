public class Ponto3D extends Ponto {
	private int z;
	
	public Ponto3D(int _x, int _y, int _z){
		super(_x, _y);
		this.z = _z;
	}
	
	public int getZ(){
		return this.z;
	}
	
	public String toString(){
		return super.toString()+" Z="+this.z;
	}
	
	public static void main(String args[]){
		//Ponto3D p1 = new Ponto(); // erro porque tenta criar um objeto da classe pai apontando para uma variavel da classe filha
		Ponto	p2 = new Ponto();
		//Ponto	p3 = new Ponto3D(); // erro porque não existe o construtor vazio na classe Ponto3D
		//Ponto	p4 = new Ponto3D(1,2); // erro porque não existe o construtor somente com dois parametros na classe Ponto3D
		Ponto	p5 = new Ponto3D(1,2,3);
		Ponto3D p6 = new Ponto3D(1,2,3);
		
		p5.getX();
		
		Ponto3D p7 = (Ponto3D)p5; // faz cast (força conversão de tipos) atribuindo uma nova variavel
		
		((Ponto3D)p5).getZ(); // faz cast (força conversão de tipos) em uma linha
		
		p6.getX();
	}
}