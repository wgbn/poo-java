package dto;


public class tbProdutoDTO {
    private int idproduto;
    private String dsecricao;
    private String fabricante;
    private int qtestoque;
    private float vlpreco;

    public tbProdutoDTO() {
    }

    public tbProdutoDTO(int idproduto, String dsecricao, String fabricante, int qtestoque, float vlpreco) {
        this.idproduto = idproduto;
        this.dsecricao = dsecricao;
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

    public String getDsecricao() {
        return dsecricao;
    }

    public void setDsecricao(String dsecricao) {
        this.dsecricao = dsecricao;
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
