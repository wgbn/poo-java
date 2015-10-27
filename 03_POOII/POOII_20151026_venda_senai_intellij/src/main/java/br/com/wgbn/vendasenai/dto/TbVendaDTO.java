package dto;

/**
 *
 * @author Walter Gandarella
 */
public class TbVendaDTO {
    private int idvenda;
    private TbVendedorDTO vendedor;
    private TbProdutoDTO produto;
    private int qtquantidade;
    
    public TbVendaDTO(){
        
    }

    public TbVendaDTO(int idvenda) {
        this.idvenda = idvenda;
    }

    public TbVendaDTO(int idvenda, TbVendedorDTO vendedor, TbProdutoDTO produto, int qtquantidade) {
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

    public TbVendedorDTO getVendedor() {
        return vendedor;
    }

    public void setVendedor(TbVendedorDTO vendedor) {
        this.vendedor = vendedor;
    }

    public TbProdutoDTO getProduto() {
        return produto;
    }

    public void setProduto(TbProdutoDTO produto) {
        this.produto = produto;
    }

    public int getQtquantidade() {
        return qtquantidade;
    }

    public void setQtquantidade(int qtquantidade) {
        this.qtquantidade = qtquantidade;
    }
}
