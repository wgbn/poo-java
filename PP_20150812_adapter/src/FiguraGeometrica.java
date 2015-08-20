public abstract class FiguraGeometrica {
    protected DoisPontos doisPontos;

    public FiguraGeometrica(DoisPontos _doisPontos){
        this.doisPontos = _doisPontos;
    }

    public DoisPontos getDoisPontos() {
        return doisPontos;
    }

    public String toString() {
        return "Figura Geometrica";
    }

    protected abstract double getArea();

    protected abstract String getInformacaoEspecifica();
}
