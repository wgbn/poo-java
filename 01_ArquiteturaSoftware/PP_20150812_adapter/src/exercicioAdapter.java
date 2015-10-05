public class exercicioAdapter {

    public static void main(String[] args) {
        DoisPontos p = new DoisPontos(4, 6, 5, 4);
        FiguraGeometrica figuraTriangulo = new FiguraTriangulo(p);
        System.out.println(figuraTriangulo);
        Losango l = new Losango((FiguraTriangulo) figuraTriangulo);
        l.criaTriangulo2();
        FiguraGeometrica figuraLosango = new FiguraLosango(l);
        System.out.println(figuraLosango);
    }

}
