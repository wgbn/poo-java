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
public class Banco {
    public String getLinhaDeCredito(Cliente _cliente){
        return (_cliente.getSaldo() > 2000) ? "Saldo compativel" : "Saldo insuficiente";
    }
}
