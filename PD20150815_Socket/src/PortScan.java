import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class PortScan {

    public static String endereco = "localhost";

    public static void main(String[] args) {
        StringBuffer portasOk, portasNok;
        portasOk = new StringBuffer();
        portasNok = new StringBuffer();
        Socket s;
        for (int i = 70; i <= 100; i++) {
            try {
                s = new Socket(endereco, i);
                portasOk.append(i + " ");
                System.out.println("Porta " + i + " Aberta");
                s.close();
            } catch (UnknownHostException h) {
                System.out.println(h.getMessage());
                System.exit(0);
            } catch (IOException e) {
                portasNok.append(i + " ");
                System.out.println("Porta " + i + " Fechada");
            }
        }
        System.out.println("Portas abertas: " + portasOk.toString() + "\nPortas fechadas: " + portasNok.toString());
}
}
