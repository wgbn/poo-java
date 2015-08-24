import sig.Singleton;

public class Program {
    public static void main(String[] args) {
        Singleton.getInstance().setTexto("Maria José");
        System.out.println(Singleton.getInstance().getTexto());

        Singleton.getInstance().setTexto("John Doe");
        System.out.println(Singleton.getInstance().getTexto());
    }
}
