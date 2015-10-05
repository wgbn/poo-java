/*
 * Created on 24/07/2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package aplicacao;

/**
 * @author emjorge
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class FabricaAgenda {

    private static FabricaAgenda fabricaAgenda = null;
    public static final int AGENDAMAP = 0;
    public static final int AGENDALIST = 1;

    private FabricaAgenda(){

    }

    public static FabricaAgenda getInstancia(){
        if (FabricaAgenda.fabricaAgenda == null){
            FabricaAgenda.fabricaAgenda = new FabricaAgenda();
        }
        return FabricaAgenda.fabricaAgenda;
    }

    public IF_Agenda criaAgenda(int _tipo){
        if (_tipo == AGENDAMAP)
            return new AgendaMap();
        else
            return new AgendaList();
    }
}
