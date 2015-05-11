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
public class Nodo {
    private Nodo     padre;
    private Nodo     hijoDerecho;
    private Nodo     hijoIzquierdo;
    public Integer  frecuencia;
    public Object   simbolo;
        
        //constructor inicializando.
    public Nodo(int llave,Object etiqueta)
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

    public void setSimbolo(Object simbolo) {
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

    public Object getSimbolo() {
        return simbolo;
    }
   
    
}
