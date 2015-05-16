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
public class Tabla { 
    Caracter[] caracteres;
    
    public Tabla(){
        caracteres = new Caracter[39];
    }
    
    public void insertar(int llave,Caracter simbolo){
        caracteres[llave] = simbolo;
    }
    public Caracter buscar(int llave){
        return caracteres[llave];
    }
    public int hash(char simbolo){
        int hash;
       /* char []lista ={'a', 'b', 'c', 'd', 'e','f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
                'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                 '0', '1', '2', '3', '4', '5', '6', '7', '8', '9','.',' ',','};*/         
                
                int ascii = (int) simbolo;
                
                if(simbolo == ' ')
                {
                    ascii = 47;
                }
                if(simbolo == ',')
                {
                    ascii = 123;
                }
                
                hash = ascii % 39;
                System.out.print(simbolo + "--->" + hash + "\n");
                return hash;
 
            }
    
    public void imprimir(){
        for(int i=0; i<39;i++)
        {
            if(caracteres[i] != null){
            System.out.println(i + "." + caracteres[i].getCaracter() + "-->" + caracteres[i].getFrecuencia() + "-->" + caracteres[i].getCodigo());
            }
        }
    }
    
            
}
