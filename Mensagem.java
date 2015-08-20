public abstract class Mensagem {
	protected final int ABERTA	= 0;
	protected final int ENVIADA	= 1;
	protected final int ERRO		= 2;
	
	protected int 	estado;
	protected String 	conteudo;
	protected String 	dataHora;
	protected String 	destinatario;
	
	public Mensagem(String newDestinatario, String newConteudo, String newDataHora){
		this.estado			= this.ABERTA;
		this.conteudo		= newConteudo;
		this.dataHora		= newDataHora;
		this.destinatario	= newDestinatario;
	}
	
	public abstract boolean verifica();
	
	public int getEstado(){
		return this.estado;
	}
	
	public String getConteudo(){
		return this.conteudo;
	}
	
	public String getDataHora(){
		return this.dataHora;
	}
	
	public String getDestinatario(){
		return this.destinatario;
	}
	
	public boolean enviaMensagem(){
		if (
			this.verifica() &&
			this.estado == this.ABERTA &&
			!this.destinatario.equals("")
		){
			this.estado = this.ENVIADA;
			return true;
		} else {
			this.estado = this.ERRO;
			return false;
		}
	}
}
