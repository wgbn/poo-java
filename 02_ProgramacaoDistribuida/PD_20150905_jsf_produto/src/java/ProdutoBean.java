import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "prodBean")
@ViewScoped
public class ProdutoBean {
    private List<Produto> produtos;
    private Produto produto;
    
    public ProdutoBean(){
        this.produto = new Produto();
        this.produtos = new ArrayList<Produto>();
    }
    
    public void salvar(){
        if ((this.produto.getCodigo() > 0) && (this.produto.getDescricao() != null)){
            if (!this.produtos.contains(this.produto)){
                this.produtos.add(produto);
            } else {
                this.produtos.set(this.produtos.indexOf(this.produto), this.produto);
            }            
        }
        produto = new Produto();
    }
    
    public void delProduto(Produto _produto){
        if (this.produtos.contains(_produto)){
            this.produtos.remove(_produto);
        }
    }
    
    public void edtProduto(Produto _produto){
        if (this.produtos.contains(_produto)){
            this.produto = _produto;
            //this.edtProduto = _produto;
        }
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
    
    public Produto getProduto(){
        return this.produto;
    }
}