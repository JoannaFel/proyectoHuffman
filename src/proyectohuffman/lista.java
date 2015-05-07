/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectohuffman;

import proyectohuffman.Arbol.Nodo;

/**
 *
 * @author oscar
 */
public class lista {
    Nodo[] miLista = new Nodo[38];//va a ser la longitud de los caracteres
    public int pos = 0;
    
    public void agregar(Nodo elnodo){
        miLista[pos] = elnodo;
        pos++;
        System.out.println("el contenido de la lista:"+elnodo.key+" "+elnodo.valor);
    }
}
