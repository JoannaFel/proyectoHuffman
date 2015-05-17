/*
 * Array para almacenar los nodos ordenados segun frecuencia.
 */
package EstructurasDatos;

import EstructurasDatos.Nodo;

public class ArrayNodos {
    Nodo[] nodo;
    private int pos = 0, tam = 0;
    
    public Nodo getNodo(int i){
        return nodo[i];
    }     
    public void setTam(int tam){
        this.tam = tam;
    }
    public int getTam(){
        return tam;
    }
    
    public void crearLista(){
        nodo= new Nodo[getTam()];
    }
    
    public void agregar(Nodo elnodo){
        nodo[pos] = elnodo;
        pos++;
    }  
}
