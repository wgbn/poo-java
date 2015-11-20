import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteDaJpa {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaNaPratica");
        EntityManager em = emf.createEntityManager();
        em.close();
        emf.close();
    }

}
