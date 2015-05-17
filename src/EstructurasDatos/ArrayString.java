/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDatos;

/**
 *
 * @author oscar
 */
public class ArrayString {
    
    String[] arrayString;
    private int pos = 0, tam = 0;
    
    public String getNodo(int i){
        return arrayString[i];
    }     
    
    public void setTam(int tam){
        this.tam = tam;
    }
    
    public int getTam(){
        return tam;
    }
    
    public void crearLista(){
        arrayString = new String[getTam()];
    }
    
    public void agregar(String elemento){
        arrayString[pos] = elemento;
        pos++;
    }  
}
