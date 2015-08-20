import java.util.ArrayList;
import java.util.Collection;

public interface IF_Agenda {
	public boolean adicionaContato(IF_Contato _contato);
	public IF_Contato getContatoPorTelefone(String _telefone);
	public ArrayList<IF_Contato> getContatoPorIniciaisNome(String _iniciais); // user .startWith()
	public boolean removeContato(String _telefone);
	public Collection<IF_Contato> listContato();
	public IF_Contato getContatoPorNome(String c);

	// diagrama http://yuml.me/edit/1da01c78
}
