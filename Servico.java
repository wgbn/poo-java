public class Servico {
	private static final int EMAIL	= 1;
	private static final int SMS	= 0;
	
	public static String enviaMensagem(int tipo, Mensagem m){
		if (m.enviaMensagem()){
			if (tipo == Servico.EMAIL){
				return "EMAIL;"+m.getDataHora()+";"+m.getDestinatario()+";"+((Email)m).getAssunto()+";"+m.getConteudo();
			} else {
				return "SMS;"+m.getDestinatario()+";"+m.getConteudo()+";"+m.getDataHora();
			}
		} else {
			return "Erro na mensagem";
		}
	}
	
	public static void main(String args[]){
        Servico servico = new Servico();
        
        Mensagem email = new Email("emjorge@novatec.org","Prova Tópicos II","03/10/2005","Aviso");
        Mensagem email1 = new Email("emjorge","Prova Tópicos II","03/10/2005","Aviso");

        Mensagem sms = new Sms("9129-2234","A Prova de Tópicos II será na sala 36","03/10/2005");
        Mensagem sms1 = new Sms("9129-2234","Prova Tópicos II","03/10/2005");

        System.out.println(servico.enviaMensagem(Servico.SMS,sms));
        System.out.println(servico.enviaMensagem(Servico.EMAIL,email));
        System.out.println(servico.enviaMensagem(Servico.EMAIL,email1));
        System.out.println(servico.enviaMensagem(Servico.SMS,sms1));
	}
}
