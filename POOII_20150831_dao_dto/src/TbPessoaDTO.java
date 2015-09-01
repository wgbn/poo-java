public class TbPessoaDTO {
    private int codigo;
    private String nome;
    private String bairro;

    public TbPessoaDTO(int _codigo, String _nome, String _bairro) {
        this.codigo = _codigo;
        this.nome = _nome;
        this.bairro = _bairro;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int _codigo) {
        this.codigo = _codigo;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String _nome) {
        this.nome = _nome;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(String _bairro) {
        this.bairro = _bairro;
    }
}
