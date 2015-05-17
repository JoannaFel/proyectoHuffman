/*
 * Nodo de ArbolBinario y Arbol.
 */
package EstructurasDatos;

public class Nodo {
    private Nodo        padre;
    private Nodo        hijoDerecho;
    private Nodo        hijoIzquierdo;
    private Integer     frecuencia;
    private char        simbolo;
    private char        id; 
        
        //constructor inicializando.
    public Nodo(int llave,char etiqueta)
    {
        frecuencia  = llave;
        simbolo     = etiqueta;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }

    public void setHijoDerecho(Nodo hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    public void setHijoIzquierdo(Nodo hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public void setFrecuencia(Integer frecuencia) {
        this.frecuencia = frecuencia;
    }

    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }
        
    public Nodo getPadre() {
        return padre;
    }

    public Nodo getHijoDerecho() {
        return hijoDerecho;
    }

    public Nodo getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public Integer getFrecuencia() {
        return frecuencia;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public char getId() {
        return id;
    }

    public void setId(char id) {
        this.id = id;
    }
}
