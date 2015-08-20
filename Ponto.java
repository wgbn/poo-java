public class Ponto {
    private int x, y;
    
    public Ponto(){
        this.x = 2;
        this.y = 3;
    }
    
    public Ponto(int x){
    	this.x = x;
    	this.y = -1;
    }
    
    public Ponto(int x, int y){
    	this(x);
    	this.y = y;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public void setX(int x){
    	this.x = x;
    }
    
    public void setY(int y){
    	this.y = y;
    }
    
    public String toString(){
    	return "X="+this.x+" Y="+this.y;
    }
    
    public static void main(String args[]){
        Ponto p = new Ponto();
        System.out.println("Ponto P x="+p.getX()+" y="+p.getY());
        
        Ponto q = new Ponto();
        q.setX(10);
        q.setY(5);
        System.out.println("Ponto Q x="+q.getX()+" y="+q.getY());
        
        Ponto z = new Ponto(100,33);
        System.out.println("Ponto Z x="+z.getX()+" y="+z.getY());
    }
}