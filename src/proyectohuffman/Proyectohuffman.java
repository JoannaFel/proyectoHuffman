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
public class Proyectohuffman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Arbol abb = new Arbol();
        abb.insertar(5,null);
        abb.insertar(7,"a");
        abb.insertar(1,"s");
        abb.insertar(8,"w");
        abb.insertar(8,"q");
        abb.insertar(6,"x");
        abb.insertar(10,"l");
        
        abb.inorderTreeWalk(abb.raiz);
        
        Archivo a = new Archivo();
        a.leerArchivo();
    }
    
}
