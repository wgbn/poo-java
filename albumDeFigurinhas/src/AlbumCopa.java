import java.util.HashMap;
import java.util.Iterator;

public class AlbumCopa {
    public static final int BRASIL      = 1;
    public static final int ARGENTINA   = 2;
    public static final int PORTUGAL    = 3;
    public static final int ALEMANHA    = 4;

    private HashMap listaFiguringas     = new HashMap();
    private AlbumUsuario albumUsuario   = new AlbumUsuario();

    public void criaColecaoFigurinhas() {

        int t = 23;
        int inicio = 1;
        int fim = 23;
        for (int time = 1; time <= 4; time++) {

            for (int numero = inicio; numero <= fim; numero++) {
                Figurinha figurinha = new Figurinha();
                figurinha.setTime(time);
                figurinha.setNumero(new Integer(numero));
                this.listaFiguringas.put(figurinha.getNumero(), figurinha);

                System.out.println(time + "|" + numero);

            }

            inicio = fim + 1;
            fim = inicio + t - 1;

        }

    }

    public Figurinha getFigurinha(int numero) {

        return (Figurinha) this.listaFiguringas.get(new Integer(numero));
    }

    public HashMap getListaFigurinhas() {
        return listaFiguringas;
    }

    public void setListaFiguringas(HashMap listaFiguringas) {
        this.listaFiguringas = listaFiguringas;
    }

    public AlbumUsuario getAlbumUsuario() {
        return albumUsuario;
    }

    public void setAlbumUsuarioEduardo(AlbumUsuario albumUsuario) {
        this.albumUsuario = albumUsuario;
    }

    public String lisatAlbumUsuarioAlemanha() {
        String temp = "Album Copa do Mundo Pagina Alemanha\n";
        Iterator it = this.albumUsuario.getListaPagina().values().iterator();
        while (it.hasNext()) {
            Pagina pagina = (Pagina) it.next();
            if (pagina.getPagina().intValue() == AlbumCopa.ALEMANHA) {
                temp = temp + pagina;
            }

        }
        return temp;
    }

    public static void main(String[] args) {
        AlbumCopa albumCopa = new AlbumCopa();
        albumCopa.criaColecaoFigurinhas();

        System.out.println(albumCopa.getListaFigurinhas());

        albumCopa.getAlbumUsuario().criaAlbumUsuario();

        System.out.println(albumCopa.getAlbumUsuario().getListaPagina());

        Figurinha figurinha89 = albumCopa.getFigurinha(89);

        Pagina paginaBrasil = (Pagina) albumCopa.getAlbumUsuario().getListaPagina().get(new Integer(AlbumCopa.BRASIL));

        System.out.println(paginaBrasil.colaFigurinha(figurinha89));

        Pagina paginaAlemanha = (Pagina) albumCopa.getAlbumUsuario().getListaPagina().get(new Integer(AlbumCopa.ALEMANHA));

        System.out.println(paginaAlemanha.colaFigurinha(figurinha89));

        System.out.println(albumCopa.getAlbumUsuario().getListaPagina());

        Figurinha figurinha72 = albumCopa.getFigurinha(72);

        System.out.println(paginaAlemanha.colaFigurinha(figurinha72));

        System.out.println(albumCopa.lisatAlbumUsuarioAlemanha());
    }

}