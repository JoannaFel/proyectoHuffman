/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectohuffman;

/**
 *
 * @author usuario
 */
public class Arbol {
    
    private Nodo raiz;
    
    
    public Arbol(){
        raiz = null;
    }
    
    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }
    
    public void insertar(Nodo nodoPadre, Nodo nodoIzq, Nodo nodoDer){ 
        if(raiz == null){ // Crea el primer arbol con la suma de las frecuencias de los dos primeros nodos
            nodoIzq.setId('0');
            nodoDer.setId('1');
            raiz = nodoPadre;
            
            raiz.setHijoIzquierdo(nodoIzq);
            raiz.setHijoDerecho(nodoDer);
            raiz.getHijoIzquierdo().setPadre(raiz);
            raiz.getHijoDerecho().setPadre(raiz);
        }else{
            Nodo hijoDerTemp = raiz; // toma la raiz de un arbol ya creado y lo guarda temporalmente como hijo derecho.
            nodoIzq.setId('0');
            hijoDerTemp.setId('1');
            raiz = nodoPadre;
            raiz.setHijoIzquierdo(nodoIzq);
            raiz.setHijoDerecho(hijoDerTemp);
            raiz.getHijoIzquierdo().setPadre(raiz);
            raiz.getHijoDerecho().setPadre(raiz);
            }
            
        }
}
    
    

