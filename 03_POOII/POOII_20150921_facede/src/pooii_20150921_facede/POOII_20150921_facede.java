/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooii_20150921_facede;

/**
 *
 * @author root
 */
public class POOII_20150921_facede {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cliente c1 = new Cliente("Jader Gomes", "767869889988998798", -10);
        NegocioFacade fac = new NegocioFacade();
        System.out.println("Verificação "+c1.getNome()+"\n"+fac.getValidaFinanciamento(c1));
    }
    
}
