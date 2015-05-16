/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectohuffman;

/**
 *
 * @author oscar
 */
public class Lista {
    Nodo[] miListaNodosOrdenados = new Nodo[39];//va a ser la longitud de los caracteres
    private int pos = 0;
    
    public Nodo getMiListaNodosOrdenados(int i){
        return miListaNodosOrdenados[i];
    }    
    
    //lista de nodos 
    public void agregar(Nodo elnodo){
        miListaNodosOrdenados[pos] = elnodo;
        System.out.println("contenido en la posicion "+pos+" :"+miListaNodosOrdenados[pos].getFrecuencia()+"  "+miListaNodosOrdenados[pos].getSimbolo());
        pos++;
    }
    
   
    /*public int getFrecuencia(int i){
        int f = miListaNodosOrdenados[i].getFrecuencia();
        return f;
    }
    
    public Object getValor(int i){
        Object v = miListaNodosOrdenados[i].getSimbolo();
        return v;
    }*/
}
