package br.com.wgbn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GerenciandoSensores {

    private Map listaSala = new HashMap();

    public boolean criaSala(Integer _numeroSala){
        Sala s = new Sala();
        s.setNumero(_numeroSala);

        if (!this.listaSala.containsValue(s)) {
            this.listaSala.put(s.getNumero(), s);
            return true;
        }

        return false;
    }

    public void registraColetaSensoresSala(Integer _numeroSala, int _data){
        if (this.listaSala.containsKey(_numeroSala))
            ((Sala)this.listaSala.get(_numeroSala)).coletaDadosSensores(_data);
    }

    public String listaSalaSensores(Integer _numeroSala){
        if (this.listaSala.containsKey(_numeroSala)){
            Sala sala = (Sala)this.listaSala.get(_numeroSala);
            String tmp = "Lista Sala Número: " + sala.getNumero().toString() + "\n";

            Iterator navega = sala.getListaSensores().iterator();

            while (navega.hasNext()){
                Sensores sensor = (Sensores)navega.next();

                tmp += sensor.toString() + "\n";
            }

            return tmp;
        }

        return null;
    }

    public String listaInformacoesSalasPorPeriodo(int _dataMinima, int _dataMaxima){
        Iterator navegaSalas = this.listaSala.values().iterator();
        String tmp = "Lista Coleta de Dados\n";

        while(navegaSalas.hasNext()){
            Sala sala = (Sala)navegaSalas.next();

            tmp += "\nSala Numero: " + sala.getNumero().toString() + "\nLista Coletas: ";

            ArrayList listaSensores = sala.listaSensoresPorPeriodo(_dataMinima, _dataMaxima);

            if (listaSensores.size() > 0){
                tmp += listaSensores.toString() + "\n";
            }
        }

        return tmp;
    }

}
