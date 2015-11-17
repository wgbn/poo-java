package dto;

import java.util.Date;

public class tbManualDTO {
    private int idmanual;
    private tbProdutoDTO produto;
    private String dsinstrucao;
    private Date dtvalidade;

    public tbManualDTO(int idmanual, tbProdutoDTO produto, String dsinstrucao, Date dtvalidade) {
        this.idmanual = idmanual;
        this.produto = produto;
        this.dsinstrucao = dsinstrucao;
        this.dtvalidade = dtvalidade;
    }
    
    public tbManualDTO(){
        this.produto = new tbProdutoDTO();
    }

    public int getIdmanual() {
        return idmanual;
    }

    public void setIdmanual(int idmanual) {
        this.idmanual = idmanual;
    }

    public tbProdutoDTO getProduto() {
        return produto;
    }

    public void setProduto(tbProdutoDTO produto) {
        this.produto = produto;
    }

    public String getDsinstrucao() {
        return dsinstrucao;
    }

    public void setDsinstrucao(String dsinstrucao) {
        this.dsinstrucao = dsinstrucao;
    }

    public Date getDtvalidade() {
        return dtvalidade;
    }

    public void setDtvalidade(Date dtvalidade) {
        this.dtvalidade = dtvalidade;
    }
}
