
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;
public class ClienteData {

    public static int porta = 88;

    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", porta);
            ObjectInputStream entrada = new ObjectInputStream(s.getInputStream());
            Date d = (Date) entrada.readObject();
            System.out.println("Data do servidor: " + d.toString());
            entrada.close();
            s.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
    }
}
