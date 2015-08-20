public class Login {

    protected String nome;
    protected String senha;

    public Login(String nome, String senha){
        this.nome   = nome;
        this.senha  = senha;
    }

    public String getNome(){
        return this.nome;
    }

    public String getSenha(){
        return this.senha;
    }

    public boolean verificaLogin(String nome, String senha){
        return  ((this.nome.equals(nome)  &&  this.senha.equals(senha))? true : false);
    }
}