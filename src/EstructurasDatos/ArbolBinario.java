
/**
 * Estructura usada para crear la lista ordenada de los nodos de caracteres y frecuencias
 */

package EstructurasDatos;

public class ArbolBinario {

    Nodo raiz;
    ArrayNodos listaArboles = new ArrayNodos();

    public ArbolBinario() {
        raiz = null;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void insertar(int frecuencia, char simbolo) {
        Nodo nuevo = new Nodo(frecuencia, simbolo);
        if (raiz == null) {
            raiz = nuevo;
        
        } else {
            Nodo temporal = raiz;
            while (temporal != null) {
                nuevo.setPadre(temporal);
                if (nuevo.getFrecuencia() >= temporal.getFrecuencia()) {
                    temporal = temporal.getHijoDerecho();
                } else {
                    temporal = temporal.getHijoIzquierdo();
                }
            }
            if (nuevo.getFrecuencia() < nuevo.getPadre().getFrecuencia()) {
                nuevo.getPadre().setHijoIzquierdo(nuevo);
            } else {
                nuevo.getPadre().setHijoDerecho(nuevo);
            }
        }
    }

    public void crearLista(int tam) {
        listaArboles.setTam(tam);
        listaArboles.crearLista();
    }

    /*
    *recorrer el arbol inorden para obtener una lista de nodos ordenada ascendentemente segun las frecuencias
    */
    public void inorderTreeWalk(Nodo x) {
        if (x != null) {
            inorderTreeWalk(x.getHijoIzquierdo());
            listaArboles.agregar(x);
            inorderTreeWalk(x.getHijoDerecho());
        }
    }

    public ArrayNodos getListaNodos() {
        return listaArboles;
    }

}
