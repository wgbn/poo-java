package sig;

public class Singleton {

    private Singleton self = null;
    private String texto;

    public Singleton getInstance() {
        if (this.self == null)
            this.self = new Singleton();

        return this.self;
    }

    private Singleton() {}

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
