public class Losango {
    private FiguraTriangulo triangulo1;
    private FiguraTriangulo triangulo2;

    public Losango(FiguraTriangulo triangulo_) {
        this.triangulo1 = triangulo_;
    }

    public void criaTriangulo2() {
        int x1 = triangulo1.getDoisPontos().getX1();
        int y1 = triangulo1.getDoisPontos().getY1();
        int x2 = triangulo1.getDoisPontos().getX2();
        int y2 = triangulo1.getDoisPontos().getY2();
        DoisPontos p = new DoisPontos(x1, y1, x2, y2);
        triangulo2 = new FiguraTriangulo(p);
    }

    public FiguraTriangulo getTriangulo1() {
        return triangulo1;
    }

    public FiguraTriangulo getTriangulo2() {
        return triangulo2;
    }
}	
  