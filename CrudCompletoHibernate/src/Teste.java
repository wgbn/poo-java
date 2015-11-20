import dao.PessoaDAO;
import entity.PessoaEntity;

public class Teste {
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

        dao.persist(p);
        dao.persist(p2);
        dao.persist(p3);
        dao.persist(p4);

        for(PessoaEntity pe : dao.findAll()){
            System.out.println(pe.getId());
            System.out.println(pe.getNome());
            System.out.println();
        }

        dao.remove(p);
        dao.removeById(p2.getId());

        for(PessoaEntity pe : dao.findAll()){
            System.out.println(pe.getId());
            System.out.println(pe.getNome());
            System.out.println();
        }
    }
}
