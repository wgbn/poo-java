import java.util.Objects;

/**
 * Created by walter on 02/06/15.
 */
public class Figurinha {

    Integer numero;
    int time;

    public Integer getNumero() {
        return numero;
    }

    public int getTime() {
        return time;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Figurinha figurinha = (Figurinha)o;
        return Objects.equals(numero, figurinha.numero);
    }

    public String toString() {
        return "Time: "+this.time+" Número: "+this.numero;
    }
}
