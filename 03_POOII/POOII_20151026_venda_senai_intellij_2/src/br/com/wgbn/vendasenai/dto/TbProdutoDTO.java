package br.com.wgbn.vendasenai.dto;

/**
 *
 * @author Walter Gandarella
 */
public class TbProdutoDTO {
    private int idproduto;
    private String descricao;
    private String fabricante;
    private int qtestoque;
    private float vlpreco;
    
    public TbProdutoDTO(){
        
    }

    public TbProdutoDTO(int idproduto) {
        this.idproduto = idproduto;
    }

    public TbProdutoDTO(int idproduto, String descricao, String fabricante, int qtestoque, float vlpreco) {
        this.idproduto = idproduto;
        this.descricao = descricao;
        this.fabricante = fabricante;
        this.qtestoque = qtestoque;
        this.vlpreco = vlpreco;
    }

    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getQtestoque() {
        return qtestoque;
    }

    public void setQtestoque(int qtestoque) {
        this.qtestoque = qtestoque;
    }

    public float getVlpreco() {
        return vlpreco;
    }

    public void setVlpreco(float vlpreco) {
        this.vlpreco = vlpreco;
    }
}
