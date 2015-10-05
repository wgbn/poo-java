public class DoisPontos {
    private int x1, x2, y1, y2;

    public DoisPontos(int _x1, int _y1, int _x2, int _y2){
        this.x1 = _x1;
        this.x2 = _x2;
        this.y1 = _y1;
        this.y2 = _y2;
    }

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
    }

    public String toString() {
        return "Ponto=(X1="+this.x1+",Y1="+this.y1+")(X2="+this.x2+",Y2="+this.y2+")";
    }
}
