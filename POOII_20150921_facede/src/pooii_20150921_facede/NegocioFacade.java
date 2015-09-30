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
public class NegocioFacade {
    private Spc spc = new Spc();
    private Serasa serasa = new Serasa();
    private Banco banco = new Banco();
    private Caixa caixa = new Caixa();
    
    public String getValidaFinanciamento(Cliente _cliente){
        return spc.getValidaCpf(_cliente)+"\n"+
                serasa.getConsultaSerasa(_cliente)+"\n"+
                banco.getLinhaDeCredito(_cliente)+"\n"+
                caixa.getVerificaFinanciamento(_cliente);
    }
}
