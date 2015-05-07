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
            //System.out.println(x.key +" "+ x.valor);
            listaArboles.agregar(x);
            inorderTreeWalk(x.hijoDerecho);
        }
    }

    //clase anidada Nodo que va a ser solamente utilizada por la clase Arbol
    public class Nodo{
	private Nodo     padre;
	private Nodo     hijoDerecho;
	private Nodo     hijoIzquierdo;
	private Integer  key;
        private Object   valor;
        
        //constructor inicializando.
        public Nodo(int llave){
            key             = llave;
            hijoDerecho     = null;
            hijoIzquierdo   = null;
            padre           = null;
            valor           = null;
        
        }
        /*
        public Nodo(int llave,Object cont){
            key             = llave;
            hijoDerecho     = null;
            hijoIzquierdo   = null;
            padre           = null;
            valor           = cont;
        
        }*/

        public Nodo getPadre() {
            return padre;
        }

        public Nodo getHijoDerecho() {
            return hijoDerecho;
        }

        public Nodo getHijoIzquierdo() {
            return hijoIzquierdo;
        }

        public Integer getKey() {
            return key;
        }

        public Object getValor() {
            return valor;
        }
        
    }
}
