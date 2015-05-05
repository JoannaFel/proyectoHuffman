package proyectohuffman;

/**
 *
 * @author oscar
 */

public class Arbol {
    
    Nodo raiz;
    
    public Arbol(){
        raiz = null;
    }
    
    //inserta un elemento en la con identificador de nodo "key" y el contenido es de cualquier tipo(valor)
    public void insertar(int key, Object valor){
        //key es el numero en el arbol
        Nodo nuevo = new Nodo(key);
        nuevo.valor = valor;
        
        //si no se ha insertado nada
        if(raiz == null){
            raiz = nuevo;
        //en temporal se almacena la raiz mientras se compara con el nuevo nodo
        //y se ubica en su posicion
        }else{
            Nodo temporal = raiz;
            while(temporal != null){
                nuevo.padre = temporal;
                if(nuevo.key >= temporal.key){
                    temporal = temporal.hijoDerecho;
                }else{
                    temporal = temporal.hijoIzquierdo;
                }
            }
            if(nuevo.key < nuevo.padre.key){
                nuevo.padre.hijoIzquierdo = nuevo;
            }else{
                nuevo.padre.hijoDerecho = nuevo;
            }
        } 
    }
    
    //recorrer el arbol en inorder y mostrar el contenido de cada key ordenada
    public void inorderTreeWalk(Nodo x){
        if(x != null){
            inorderTreeWalk(x.hijoIzquierdo);
            System.out.println(x.key);
            inorderTreeWalk(x.hijoDerecho);
        }
    }

    //clase anidada Nodo que va a ser solamente utilizada por la clase Arbol
    private class Nodo{
	public Nodo     padre;
	public Nodo     hijoDerecho;
	public Nodo     hijoIzquierdo;
	public Integer  key;
        public Object   valor;
        
        //constructor inicializando.
        public Nodo(int llave){
            key             = llave;
            hijoDerecho     = null;
            hijoIzquierdo   = null;
            padre           = null;
            valor           = null;
        
        }
    }
}
