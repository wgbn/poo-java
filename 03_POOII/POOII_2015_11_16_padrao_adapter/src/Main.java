/**
 * Created by walter on 16/11/15.
 */
public class Main {
    public static void main(String[] args) {
        TomadaDeTresPinos t3 = new TomadaDeTresPinos();
        AdapterTomada at = new AdapterTomada(t3);

        at.ligarNaTomadaDeDoisPinos();
    }
}
