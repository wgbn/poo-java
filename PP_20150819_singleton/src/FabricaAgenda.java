public class FabricaAgenda {

    private static FabricaAgenda fabricaAgenda = null;

    private FabricaAgenda(){

    }

    public static FabricaAgenda getInstance(){
        if (FabricaAgenda.fabricaAgenda == null){
            FabricaAgenda.fabricaAgenda = new FabricaAgenda();
        }
        return FabricaAgenda.fabricaAgenda;
    }

    public String getTeste(){
        return "teste";
    }

}
