public class Programa {
    
	public static void main(String[] args){
        // instancia objeto login
        Login log = new Login("eduardo", "123");
        
        // testa o login e imprime seu valor
        System.out.println(
            (log.verificaLogin("carlos", "123") ? "Login válido" : "Login inválido")
        );
    }
    
}