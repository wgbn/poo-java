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
public class Spc {
    public String getValidaCpf(Cliente _cliente){
        return (_cliente.getCpf().length() < 11) ? "Cliente sujo" : "Cliente limpo";
    }
}
