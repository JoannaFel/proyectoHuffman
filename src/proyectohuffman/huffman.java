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
public class huffman {
    
    Lista lista;
    //Nodo[] listaNodos;
    Arbol arbol;
    
    
    public huffman(){
        //lista = new Lista();
        arbol = new Arbol();
    }
    public void crearListaNodos(){
        ArbolBinario abb = new ArbolBinario();
        abb.insertar(5,null);
        abb.insertar(7,"a");
        abb.insertar(1,"s");
        abb.insertar(8,"w");
        abb.insertar(8,"q");
        abb.insertar(6,"x");
        abb.insertar(10,"l");
        abb.inorderTreeWalk(abb.getRaiz());
        lista= abb.getListaNodos();
        for(int i=0; i<38;i++) // Vuelve los null hijos de los nodos de la lista
        {
            if(lista.getMiListaNodosOrdenados(i)==null)
            {
                i=38;
            }else
            {
                lista.getMiListaNodosOrdenados(i).setHijoDerecho(null);
                lista.getMiListaNodosOrdenados(i).setHijoIzquierdo(null);
            }
        }
        
    }
    
    public void crearArbol(){
        int suma = 0;
        Nodo raiz = new Nodo(0,null);
        Nodo derTemp = new Nodo(0,null);
        
        for(int i=0;i<38;i++)
        {
            Nodo nodoActual = lista.getMiListaNodosOrdenados(i);
            Nodo nodoSgte = lista.getMiListaNodosOrdenados(i+1);
            
            if(nodoActual==null) // La lista es de 38 posiciones y tal vez no se llenen todas
            {                    //Me aseguro de leer solo las posiciones con nodos.
                i=38; 
                
            }
            else
            { 
                if(i==0)
                {
                    suma = nodoActual.getFrecuencia() + nodoSgte.getFrecuencia();// Suma los nodos de menor frecuencia
                    derTemp = nodoSgte;                                         // Variable temporal como hijo derecho de una raiz (Suma)
                    i++;                                                        // Me aseguro de no leer la 2 posicion i=1
                }
                else
                {
                    suma = suma + nodoActual.getFrecuencia(); // Sumo los nodos 
                }
                raiz = new Nodo(suma,"RaizSuma"); // creo el nodo que almacena la suma de las frecuencias
                arbol.insertar(raiz, nodoActual, derTemp); // inserto los nodos raiz, hijoIzq e hijoDer en el nuevo arbol
                System.out.println(raiz.getFrecuencia() + ":izq->" + nodoActual.getFrecuencia() + ":der->" + derTemp.getFrecuencia());
                derTemp=raiz; // Almaceno el nodo raiz creado para ubicarlo como hijo derecho de la proxima raiz Suma
            }
        }        
    }
     
    public void contarCaracteres(){
        String textoleido ="";
        
        char[] letras = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n'
                ,'o','p','q','r','s','t','u','v','w','x','y','z','1','2','3','4'
                ,'5','6','7','8','9','0','.',',',' '};
        
        //int[] cantXletra = new int[];
        
        //textoleido = texto.leerArchivo();
        
        //convertimos el string a una cadena de caracteres
        char[] textoLeidoChar = textoleido.toCharArray();
        int j=0;
        for(int i=0; i <= textoLeidoChar.length; i++){
            //if(textoLeidoChar[i] == letras[j] || letras[j+1] || letras[j+2])
              // j++ 
        }
    }
    
    public void gestionar(){
        crearListaNodos();
        crearArbol();
        //arbol.recorrerAmplitud(arbol.getRaiz());
    }
}
