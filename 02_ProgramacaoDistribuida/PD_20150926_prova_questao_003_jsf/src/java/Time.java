public class Time {
    private String  nome;
    private String  estado;
    private String  divisao;
    private float   investimento;
    private int     numero;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDivisao() {
        return divisao;
    }

    public void setDivisao(String divisao) {
        this.divisao = divisao;
    }

    public float getInvestimento() {
        return investimento;
    }

    public void setInvestimento(float investimento) {
        this.investimento = investimento;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Time(){
        
    }
    
    public Time(String nome, String estado, String divisao, float investimento, int numero) {
        this.nome = nome;
        this.estado = estado;
        this.divisao = divisao;
        this.investimento = investimento;
        this.numero = numero;
    }
}
