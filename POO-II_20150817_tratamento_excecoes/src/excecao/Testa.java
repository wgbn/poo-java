package excecao;

public class Testa {
    public static void main(String args[]){
        //Divisao d = new Divisao(2, 0);
        //d.divide();

        Calc calc = new Calc();
        try {
            int div = calc.div(10,0);
            System.out.println(div);
        } catch (DivPorZero e){
            System.out.println(e);
        }
    }
}
