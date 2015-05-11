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
public class Cola {
    class NodoCola {
        Nodo nodoActual;
        NodoCola sig;
    }
    private NodoCola head,tail;
    
    Cola() {
        tail=null;
        head=null;
    }
    
    boolean colaVacia(){
        if (head == null)
            return true;
        else
            return false;
    }

    void encolar(Nodo nodoIngreso)
    {
        NodoCola nodoCola;
        nodoCola = new NodoCola ();
        nodoCola.nodoActual = nodoIngreso;
        nodoCola.sig = null;
        if (colaVacia ()) {
            head= nodoCola;
            tail = nodoCola;
        } else {
            tail.sig = nodoCola;
            tail = nodoCola;
        }
    }

    Nodo desencolar()
    {
        if (!colaVacia ())
        {
            Nodo informacion = head.nodoActual;
            if (head== tail){
                head= null;
                tail = null;
            } else {
                head= head.sig;
            }
            return informacion;
        } else
            return null;
    }

    public void imprimir() {
        NodoCola reco=head;
        System.out.println("Listado de todos los elementos de la cola.");
        while (reco!=null) {
            System.out.print(reco.nodoActual.getFrecuencia()+"->");
            reco=reco.sig;
        }
        System.out.println();
    }
}
