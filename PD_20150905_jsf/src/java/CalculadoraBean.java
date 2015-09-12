
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author root
 */
@ManagedBean(name = "calcBean")
@SessionScoped
public class CalculadoraBean {
    private double valor1;
    private double valor2;
    private double resultado;
    private char operador;

    public double getValor1() {
        return valor1;
    }

    public void setValor1(double valor1) {
        this.valor1 = valor1;
    }

    public double getValor2() {
        return valor2;
    }

    public void setValor2(double valor2) {
        this.valor2 = valor2;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public char getOperador() {
        return operador;
    }

    public void setOperador(char operador) {
        this.operador = operador;
    }
    
    public void calcular(){
        switch(this.operador){
            case '+':
                this.resultado = this.valor1 + this.valor2;
                break;
            case '-':
                this.resultado = this.valor1 - this.valor2;
                break;
            case '*':
                this.resultado = this.valor1 * this.valor2;
                break;
            case '/':
                this.resultado = this.valor1 / this.valor2;
                break;
        }
    }
    
}
