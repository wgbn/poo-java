import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ServidorData {

    private static ServerSocket serv;
    private final static int porta = 88;
    private static Date data;

    public static void main(String args[]) {
        try {
            serv = new ServerSocket(porta);
            data = new Date();
            System.out.println("Servidor a espera de cliente...");
            Socket s = serv.accept();
            System.out.println("Cliente conecado! Devolvendo data!");
            ObjectOutputStream saida = new ObjectOutputStream(s.getOutputStream());
            saida.writeObject(data);
            saida.flush();
            saida.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
