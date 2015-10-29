/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ba.poo2.modelo;

import br.ba.poo2.mapeamento.Aluno;
import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;

public class AlunoModelo extends ListDataModel<Aluno> implements SelectableDataModel<Aluno> {
    public AlunoModelo() {   }
    public AlunoModelo(List<Aluno> list) {
        super(list);
    }
    @Override
    public Object getRowKey(Aluno a) {
        return a.getMatricula();
    }
    @Override
    public Aluno getRowData(String string) {
        List<Aluno> vls = (List<Aluno>) getWrappedData();
        for(Aluno vl : vls) {
            if(String.valueOf(vl.getMatricula()).equals(string)) return vl;
        }
        return null;
    }
}
