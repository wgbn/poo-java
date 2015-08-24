package sig;

public class Singleton {

    private static Singleton self = null;
    private String texto;

    public static Singleton getInstance() {
        if (self == null)
            self = new Singleton();

        return self;
    }

    private Singleton() {}

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
