/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectohuffman;

/**
 *
 * @author oscar
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long inicio=0, fin=0;
        ProyectoHuffman h = new ProyectoHuffman();
        inicio = System.currentTimeMillis();
        
        h.gestionar();
        
        fin = System.currentTimeMillis();
        System.out.println();
        System.out.println(" el tiempo de computo fue : "+(fin - inicio)+" ms");
    }
}
