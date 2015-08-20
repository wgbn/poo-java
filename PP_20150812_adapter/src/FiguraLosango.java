public class FiguraLosango extends FiguraGeometrica {
    private Losango losango;

    public FiguraLosango(Losango _losango){
        super(_losango.getTriangulo1().getDoisPontos());
        this.losango = _losango;
    }

    public double getArea() {
        return this.losango.getTriangulo1().getArea() + this.losango.getTriangulo2().getArea();
    }

    public String getInformacaoEspecifica() {
        return "Lozango "+this.doisPontos+" Area="+this.getArea();
    }

    public String toString() {
        return super.toString()+" "+this.getInformacaoEspecifica();
    }
}
