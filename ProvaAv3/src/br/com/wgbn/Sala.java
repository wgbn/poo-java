package br.com.wgbn;

import java.util.ArrayList;
import java.util.Iterator;

public class Sala {

    private Integer     numero;
    private ArrayList   listaSensores = new ArrayList();

    public Integer getNumero() {
        return numero;
    }

    public ArrayList getListaSensores() {
        return listaSensores;
    }

    public void setNumero(Integer _numero) {
        this.numero = _numero;
    }

    public void setListaSensores(ArrayList _listaSensores) {
        this.listaSensores = _listaSensores;
    }

    public void coletaDadosSensores(int _data){
        Sensores s = new Sensores();

        s.setId(this.listaSensores.size() + 1);
        s.setData(_data);
        s.coletaDados();

        if (!this.listaSensores.contains(s))
            this.listaSensores.add(s);
    }

    public ArrayList listaSensoresPorPeriodo(int _dataMinima, int _dataMaxima){
        ArrayList l = new ArrayList();

        Iterator navega = this.listaSensores.iterator();

        while (navega.hasNext()){
            Sensores s = (Sensores)navega.next();

            if (s.getData() >= _dataMinima && s.getData() <= _dataMaxima)
                l.add(s);
        }

        return l;
    }
}
