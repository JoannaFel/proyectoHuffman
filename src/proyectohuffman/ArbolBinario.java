package proyectohuffman;

/**
 *
 * @author oscar
 */

public class ArbolBinario {
    
    Nodo raiz;
    Lista listaArboles = new Lista();
    
    public ArbolBinario(){
        raiz = null;
    }

    public Nodo getRaiz() {
        return raiz;
    }
    
    
    //inserta un elemento en la con identificador de nodo "frecuencia" y el contenido es de cualquier tipo(simbolo)
    public void insertar(int frecuencia, Object simbolo){
        //frecuencia es el numero en el arbol
        Nodo nuevo = new Nodo(frecuencia,simbolo);      
        //si no se ha insertado nada
        if(raiz == null){
            raiz = nuevo;
        //en temporal se almacena la raiz mientras se compara con el nuevo nodo
        //y se ubica en su posicion
        }else{
            Nodo temporal = raiz;
            while(temporal != null){
                nuevo.setPadre(temporal);
                if(nuevo.getFrecuencia() >= temporal.getFrecuencia()){
                    temporal = temporal.getHijoDerecho();
                }else{
                    temporal = temporal.getHijoIzquierdo();
                }
            }
            if(nuevo.getFrecuencia() < nuevo.getPadre().getFrecuencia()){
                nuevo.getPadre().setHijoIzquierdo(nuevo);
            }else{
                nuevo.getPadre().setHijoDerecho(nuevo);
            }
        } 
    }
    
    //recorrer el arbol en inorder y mostrar el contenido de cada frecuencia ordenada
    public void inorderTreeWalk(Nodo x){
        if(x != null){
            inorderTreeWalk(x.getHijoIzquierdo());
            //System.out.println(x.frecuencia +" "+ x.simbolo);
            listaArboles.agregar(x);
            inorderTreeWalk(x.getHijoDerecho());
        }
    }
    
    public Lista getListaNodos() {
        return listaArboles;
    }
    
     //Metodo que me permite recorrer el arbol y calcular la profundidad
    public int profundidad(Nodo raiz){
       
             int alt = 1;     //Variable que me guarda la altura del arbol
        
             if(raiz == null){  //Si el arbol esta vacio la altura es 0
                  System.out.print("la altura del arbol es: 0");
                  
               }else {
                   Nodo nodo=raiz;    
                   while(nodo.getHijoDerecho()!=null){   //Compara hasta que el hijo derecho sea null
                   alt++;                                 //aumenta en 1 cada vez que entre al ciclo
                   nodo=nodo.getHijoDerecho();   //Nodo raiz pasa a ser el hijo derecho 
                 
                   }
             
               }
        return alt;   // Retorna la altura
             
             }        
          
    
}
