public class Email extends Mensagem {
	private String assunto;
	
	public Email(String newDestinatario, String newConteudo, String newDataHora, String newAssunto){
		super(newDestinatario, newConteudo, newDataHora);
		this.assunto = newAssunto;
	}
	
	public boolean verifica(){
		return (this.destinatario.indexOf('@') != -1) ? true : false;
	}
	
	public String getAssunto(){
		return this.assunto;
	}
}
