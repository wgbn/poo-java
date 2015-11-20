import dao.PessoaDAO;
import dao.PessoaGDAO;
import dao.SimpleEntityManager;
import entity.PessoaEntity;

public class Main {

    public static void main(String[] args) {

        PessoaEntity p = new PessoaEntity();

        p.setNome("Gabriel");
        p.setIdade(19);

        PessoaEntity p2 = new PessoaEntity();

        p2.setNome("José");
        p2.setIdade(72);

        PessoaEntity p3 = new PessoaEntity();

        p3.setNome("Maria");
        p3.setIdade(27);

        PessoaEntity p4 = new PessoaEntity();

        p4.setNome("Rodolfo");
        p4.setIdade(16);

        PessoaDAO dao = new PessoaDAO();

        dao.insert(p);
        dao.insert(p2);
        dao.insert(p3);
        dao.insert(p4);

        // usando GenericDAO
        PessoaEntity p5 = new PessoaEntity();
        p5.setNome("Walter");
        p5.setIdade(35);

        SimpleEntityManager sem = new SimpleEntityManager("wgbn");
        PessoaGDAO gdao = new PessoaGDAO(sem.getEntityManager());
        gdao.insert(p5);

        for(PessoaEntity pe : dao.findAll()){
            System.out.println(pe.getId()+" - "+pe.getNome()+" - "+pe.getIdade()+" anos");
        }

        dao.delete(p);
        dao.deleteById(p2.getId());

        System.out.println("Removendo...");

        for(PessoaEntity pe : dao.findAll()){
            System.out.println(pe.getId()+" - "+pe.getNome()+" - "+pe.getIdade()+" anos");
        }
    }

}
