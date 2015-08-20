package excecao;

public class Calc {
    public int div(int a, int b) throws DivPorZero {
        if (b == 0)
            throw new DivPorZero();

        return a / b;
    }
}
