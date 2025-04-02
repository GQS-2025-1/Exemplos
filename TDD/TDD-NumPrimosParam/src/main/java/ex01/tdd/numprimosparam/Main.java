/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex01.tdd.numprimosparam;

/**
 *
 * @author rafaelamoreira
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] numeros = {0, 1, 2, 3, 4, 13, 20};

        for (int numero : numeros) {
            boolean resultado = VerificadorPrimo.ePrimo(numero);
            System.out.printf("%d é primo? %s\n", numero, resultado ? "Sim" : "Não");
        }    
    }
    
}
