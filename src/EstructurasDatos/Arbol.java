/*
 * Arbol construido con las sumas de las frecuencias de los nodos.
 */
package EstructurasDatos;

public class Arbol {
    
    private Nodo    raiz;
    private int     cantidadNodos;
    
    public Arbol(){
        raiz            = null;
        cantidadNodos   = 0;
    }
    
    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }
    
    public void insertar(Nodo nodoPadre, Nodo nodoIzq, Nodo nodoDer){ 
        if(raiz == null){ // Crea el primer arbol con la suma de las frecuencias de los dos primeros nodos
            nodoIzq.setId('0'); //Asigno los id 
            nodoDer.setId('1');
            raiz = nodoPadre;
            raiz.setHijoIzquierdo(nodoIzq); //Asigno hijos a la raiz
            raiz.setHijoDerecho(nodoDer);
            raiz.getHijoIzquierdo().setPadre(raiz); //Asigno padres a los hijos
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
    
    public int calcularCantidadNodos(Nodo nodo) {  
        if (nodo!=null) {
            cantidadNodos++;
            calcularCantidadNodos(nodo.getHijoIzquierdo());
            calcularCantidadNodos(nodo.getHijoDerecho());
        }
        return cantidadNodos;
    }
    
    
    /*
    *Metodo que me permite recorrer el arbol y calcular la profundidad
    */
    public int profundidad() {
        int alt = 1;     //Variable que me guarda la altura del arbol
        if (raiz == null) {  //Si el arbol esta vacio la altura es 0
            System.out.print("la altura del arbol es: 0");

        } else {
            Nodo nodo = raiz;
            while (nodo.getHijoDerecho() != null) {   //Compara hasta que el hijo derecho sea null
                alt++;                                 //aumenta en 1 cada vez que entre al ciclo
                nodo = nodo.getHijoDerecho();   //Nodo raiz pasa a ser el hijo derecho 
            }
        }
        return alt;   // Retorna la altura
    }  
}
    
    

