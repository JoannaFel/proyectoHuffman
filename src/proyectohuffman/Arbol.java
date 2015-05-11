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
            raiz = nodoPadre;
            raiz.setHijoIzquierdo(nodoIzq);
            raiz.setHijoDerecho(nodoDer);
        }else{
            Nodo hijoDerTemp = raiz; // toma la raiz de un arbol ya creado y lo guarda temporalmente como hijo derecho.
            raiz = nodoPadre;
            raiz.setHijoIzquierdo(nodoIzq);
            raiz.setHijoDerecho(hijoDerTemp);
            }
            
        }
    
   /* public void recorrerAmplitud(Nodo raiz){
        Cola cola, colaAux; //DEFINICIÓN DE 2 VARIABLES DE TIPO COLA
        Nodo aux = new Nodo(0,null); //DEFINICIÓN AUX DE TIPO NODOARBOL

            cola=new Cola(); //SE INSTANCIA EL OBJETO COLA
            colaAux=new Cola(); //SE INSTANCIA EL OBJETO COLAAUX
            cola.encolar(raiz); //SE INSERTA EL NODOARBOL "A" (RAIZ) COMO PRIMER NODO EN LA COLA
            while (!cola.colaVacia()) //MIENTRAS HAYAN ELEMENTOS EN LA COLA...
            {
                
                aux=cola.desencolar();
                //System.out.println(aux.getFrecuencia());
                colaAux.encolar(aux); /*EL ELEMENTO EXTRAIDO DE LA COLA PRINCIPAL ES ASIGNADO 
                A AUX Y A SU VEZ INSERTADO EN LA COLA AUXILIAR*
                if (aux.getHijoIzquierdo() != null) //SI EL HIJO IZQUIERDO DEL NODO ACTUAL EXISTE
                {
                cola.encolar(aux.getHijoIzquierdo()); //SE INSERTA ESE HIJO COMO ELEMENTO SIGUIENTE EN LA COLA
                }
                if (aux.getHijoDerecho()!= null) //SI EL HIJO DERECHO DEL NODO ACTUAL EXISTE
                {
                cola.encolar(aux.getHijoDerecho()); //SE INSERTA ESE HIJO COMO ELEMENTO SIGUIENTE EN LA COLA
                }
            }
           
        colaAux.imprimir(); //POR ÚLTIMO SE IMPRIME LA COLA AUXILIAR
    }*/
}
    
    

