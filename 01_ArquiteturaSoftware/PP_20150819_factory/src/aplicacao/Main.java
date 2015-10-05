package aplicacao;

public class Main {
    public static void main(String args[]){

        IF_Agenda agenda = FabricaAgenda.getInstancia().criaAgenda(FabricaAgenda.AGENDALIST);

        IF_Contato[] contatos= new IF_Contato[3];

        contatos[0] = new Contato();
        contatos[0].setNome("A");
        contatos[0].setTelefone("345-2455");

        System.out.println("Adicionando " +  contatos[0]);
        agenda.adicionaContato(contatos[0]);

        contatos[1] = new Contato();
        contatos[1].setNome("X");
        contatos[1].setTelefone("234-9085");

        System.out.println("Adicionando " +  contatos[1]);
        agenda.adicionaContato(contatos[1]);



        contatos[2] = new Contato();
        contatos[2].setNome("Y");
        contatos[2].setTelefone("8890-19085");

        System.out.println("Adicionando " +  contatos[2]);

        agenda.adicionaContato(contatos[2]);


        System.out.println(agenda);

        System.out.println("Localizando 345-2455");


        System.out.println(agenda.getContato("345-2455"));

        System.out.println("Removendo 234-9085");

        agenda.removeContato("234-9085");

        System.out.println(agenda);
    }
}
