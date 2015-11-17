package modelo;

import entity.TbAlunoEntity;
import org.primefaces.model.SelectableDataModel;

import javax.faces.model.ListDataModel;
import java.util.List;

public class AlunoModelo extends ListDataModel<TbAlunoEntity> implements SelectableDataModel<TbAlunoEntity> {
    public AlunoModelo() {   }
    public AlunoModelo(List<TbAlunoEntity> list) {
        super(list);
    }
    @Override
    public Object getRowKey(TbAlunoEntity a) {
        return a.getMatricula();
    }
    @Override
    public TbAlunoEntity getRowData(String string) {
        List<TbAlunoEntity> vls = (List<TbAlunoEntity>) getWrappedData();
        for(TbAlunoEntity vl : vls) {
            if(String.valueOf(vl.getMatricula()).equals(string)) return vl;
        }
        return null;
    }
}