package br.com.wgbn;

import java.util.Objects;
import java.util.Random;

public class Sensores {

    private int     data;
    private int     id;
    private double  temperatura;
    private double  umidade;
    private double  luminosidade;

    public int getData() {
        return data;
    }

    public int getId() {
        return id;
    }

    public String getChave(){
        return ((Integer) this.id).toString() + '.' + ((Integer)this.data).toString();
    }

    public void setData(int _data) {
        this.data = _data;
    }

    public void setId(int _id) {
        this.id = _id;
    }

    public String toString() {
        return "Sensores" +
                " Código: " + this.data +
                " Temperatura: " + this.temperatura +
                " Umidade: " + this.umidade +
                " Luminosidade: " + this.luminosidade;
    }

    public void coletaDados(){
        Random r = new Random();

        this.temperatura    = r.nextDouble() * 100;
        this.umidade        = r.nextDouble() * 30 + 10;
        this.luminosidade   = r.nextDouble() + 4;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sensores s = (Sensores)o;

        return s.getChave().equals(this.getChave()) ? true : false;
    }
}
