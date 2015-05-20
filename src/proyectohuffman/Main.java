/*
 *
 *Clase principal de nuestra aplicacion.
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
        inicio = System.currentTimeMillis();//para el tiempo que toma ejecutar el programa
        
        h.gestionar();
        
        fin = System.currentTimeMillis();
        System.out.println();
        System.out.println(" el tiempo de computo fue : "+(fin - inicio)+" ms");
    }
}
