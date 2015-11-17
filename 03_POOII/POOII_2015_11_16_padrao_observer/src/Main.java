/**
 * Created by walter on 16/11/15.
 */
public class Main {
    public static void main(String[] args) {
        SireneConcreta sireneConcreta = new SireneConcreta();
        OperarioConcreto obs1 = new OperarioConcreto(sireneConcreta);
        OperarioConcreto obs2 = new OperarioConcreto(sireneConcreta);

        sireneConcreta.alterarAlerta();

        System.out.println("======================");

        sireneConcreta.alterarAlerta();
    }
}
