public class FiguraTriangulo extends FiguraGeometrica {
    private int base;
    private int altura;

    public FiguraTriangulo(DoisPontos _doisPontos) {
        super(_doisPontos);
        this.base = 2 * (this.doisPontos.getX2() - this.doisPontos.getX1());
        this.altura = this.doisPontos.getY1() > this.doisPontos.getY2() ? this.doisPontos.getY1() - this.doisPontos.getY2() : this.doisPontos.getY2() - this.doisPontos.getY1();
    }

    public int getBase() {
        return base;
    }

    public int getAltura() {
        return altura;
    }

    public double getArea() {
        return (this.base * this.altura) / 2;
    }

    public String getInformacaoEspecifica() {
        return "Triangulo "+this.doisPontos.toString()+" Area="+this.getArea();
    }
    public String toString() {
        return super.toString()+" "+this.getInformacaoEspecifica();
    }
}
