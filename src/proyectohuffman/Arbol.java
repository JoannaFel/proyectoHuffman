package proyectohuffman;

/**
 *
 * @author oscar
 */

public class Arbol {
    
    Nodo raiz;
    lista listaArboles = new lista();
    public Arbol(){
        raiz = null;
    }
    
    //inserta un elemento en la con identificador de nodo "key" y el contenido es de cualquier tipo(simbolo)
    public void insertar(int key, Object simbolo){
        //key es el numero en el arbol
        Nodo nuevo = new Nodo(key,simbolo);      
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
    
    //recorrer el arbol en inorder y mostrar el contenido de cada key ordenada
    public void inorderTreeWalk(Nodo x){
        if(x != null){
            inorderTreeWalk(x.getHijoIzquierdo());
            //System.out.println(x.key +" "+ x.simbolo);
            listaArboles.agregar(x);
            inorderTreeWalk(x.getHijoDerecho());
        }
    }

}
