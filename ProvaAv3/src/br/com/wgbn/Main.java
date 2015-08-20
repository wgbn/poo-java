package br.com.wgbn;

public class Main {

    public static void main(String[] args) {
	    GerenciandoSensores gs = new GerenciandoSensores();

        gs.criaSala(13);

        for (int x = 200; x <= 210; x++)
            gs.registraColetaSensoresSala(13, x);

        gs.criaSala(21);

        for (int x = 200; x <= 210; x++)
            gs.registraColetaSensoresSala(21, x);

        System.out.println(gs.listaSalaSensores(13));

        System.out.println(gs.listaInformacoesSalasPorPeriodo(202, 208));
    }
}
