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
public class Pila {
	
	class NodoPila {
	    Nodo nodoActual;
	    NodoPila sig;
	}
	
    private NodoPila raiz;
    
    Pila () {
        raiz=null;
    }
    
    public void insertar(Nodo x) {
    	NodoPila nuevo;
        nuevo = new NodoPila();
        nuevo.nodoActual = x;
        if (raiz==null)
        {
            nuevo.sig = null;
            raiz = nuevo;
        }
        else
        {
            nuevo.sig = raiz;
            raiz = nuevo;
        }
    }
    
    public Nodo extraer ()
    {
        if (raiz!=null)
        {
            Nodo informacion = raiz.nodoActual;
            raiz = raiz.sig;
            return informacion;
        }
        else
        {
            return null;
        }
    }
    
    public void imprimir() {
        NodoPila reco=raiz;
        System.out.println("Listado de todos los elementos de la pila.");
        while (reco!=null) {
            System.out.print(reco.nodoActual+"-");
            reco=reco.sig;
        }
        System.out.println();
    }
    
    public boolean vacia() {
        if (raiz==null) {
            return true;
        } else {
    	    return false; 
        }
    }
}
