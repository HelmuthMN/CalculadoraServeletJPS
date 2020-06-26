/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author Helmuth
 */
public class Adicao extends Calculo{

    public Adicao(float valor1, float valor2) {
        super(valor1, valor2);
    }

    @Override
    public float calcular() {
        return valor1 + valor2;       
    }      
}
