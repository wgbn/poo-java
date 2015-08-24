import sig.Singleton;

public class Program {
    public static void main(String[] args) {
        Singleton var1 = new Singleton();
        var1.setTexto("Maria José");

        Singleton var2 = new Singleton();
        var2.setTexto("John Doe");

        System.out.println("Objeto var1: "+var1.getTexto());
        System.out.println("Objeto var2: "+var2.getTexto());
    }
}
