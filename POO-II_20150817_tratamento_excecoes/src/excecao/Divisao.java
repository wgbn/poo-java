package excecao;

public class Divisao {
    private int x, y, resultado;
    String tre;

    public Divisao(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void divide() {
        try {
            resultado = x / y;
            System.out.println("O resultado é " + resultado);
            return;
        } catch (ArithmeticException e) {
            System.out.println("O segundo valor não pode ser 0");
            //System.out.println(e.getMessage());
            //e.printStackTrace();
        } finally {
            System.out.println("Fim!!");
        }
    }
}
