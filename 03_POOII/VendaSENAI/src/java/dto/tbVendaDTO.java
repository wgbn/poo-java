package dto;


public class tbVendaDTO {
    private int idvenda;
    private tbVendedorDTO vendedor;
    private tbProdutoDTO produto;
    private int qtquantidade;

    public tbVendaDTO() {
        vendedor = new tbVendedorDTO();
        produto = new tbProdutoDTO();
    }

    public tbVendaDTO(int idvenda, tbVendedorDTO vendedor, tbProdutoDTO produto, int qtquantidade) {
        this.idvenda = idvenda;
        this.vendedor = vendedor;
        this.produto = produto;
        this.qtquantidade = qtquantidade;
    }

    public int getIdvenda() {
        return idvenda;
    }

    public void setIdvenda(int idvenda) {
        this.idvenda = idvenda;
    }

    public tbVendedorDTO getVendedor() {
        return vendedor;
    }

    public void setVendedor(tbVendedorDTO vendedor) {
        this.vendedor = vendedor;
    }

    public tbProdutoDTO getProduto() {
        return produto;
    }

    public void setProduto(tbProdutoDTO produto) {
        this.produto = produto;
    }

    public int getQtquantidade() {
        return qtquantidade;
    }

    public void setQtquantidade(int qtquantidade) {
        this.qtquantidade = qtquantidade;
    }
    
    
}
