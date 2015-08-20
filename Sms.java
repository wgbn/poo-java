public class Sms extends Mensagem {
	public Sms(String newDestinatario,String newConteudo,String newDataHora){
		super(newDestinatario, newConteudo, newDataHora);
	}
	
	public boolean verifica(){
		return (this.conteudo.length() <= 20) ? true : false;
	}
}
