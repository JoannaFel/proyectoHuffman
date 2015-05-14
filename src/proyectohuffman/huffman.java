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
    
    Lista listaOrdenada;
    Lista listaSimbolos;
    //Nodo[] listaNodos;
    Arbol arbol;
    
    
    public huffman(){
        //lista = new Lista();
        arbol = new Arbol();
    }
    public void crearListaNodos(){
        ArbolBinario abb = new ArbolBinario();
        abb.insertar(5,' ');
        abb.insertar(7,'a');
        abb.insertar(1,'s');
        abb.insertar(8,'w');
        abb.insertar(8,'q');
        abb.insertar(6,'x');
        abb.insertar(10,'l');
        abb.inorderTreeWalk(abb.getRaiz());
        listaOrdenada= abb.getListaNodos();
        for(int i=0; i<38;i++) // Vuelve los null hijos de los nodos de la lista
        {
            if(listaOrdenada.getMiListaNodosOrdenados(i)==null)
            {
                i=38;
            }else
            {
                String simbolo = listaOrdenada.getMiListaNodosOrdenados(i).getSimbolo() + "";
                String simboloMay = simbolo.toUpperCase();
                listaOrdenada.getMiListaNodosOrdenados(i).setSimbolo(simboloMay.charAt(0));
                listaOrdenada.getMiListaNodosOrdenados(i).setHijoDerecho(null);
                listaOrdenada.getMiListaNodosOrdenados(i).setHijoIzquierdo(null);
            }
        }
        
        
        
         char []lista ={'a', 'b', 'c', 'd', 'e','f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
                'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                 '0', '1', '2', '3', '4', '5', '6', '7', '8', '9','.',' ',','};
         
         
         
         
        // Esta parte es para incluir como funcion hash         
        for(int i=0; i<lista.length;i++)
        {
           
            //if(listaOrdenada.getMiListaNodosOrdenados(i) == null)
            //{
            //    i=38;
            //}else
            {
               // char caracter = listaOrdenada.getMiListaNodosOrdenados(i).getSimbolo();
               
                char caracter = lista[i];
                int ascii = (int) caracter;
                
                if(caracter == ' ')
                {
                    ascii = 47;
                }
                if(caracter == ',')
                {
                    ascii = 123;
                }
                
                int result = ascii % 39;
                if(result < 0)
                {
                    result = result * -1;
                }
                
                System.out.print(i + "--->" + result + "\n");
            }
        }
        
        
    }
    
    public void crearArbol(){
        int suma = 0;
        Nodo raiz ;
        Nodo derTemp = null;
        listaSimbolos = new Lista();
        
        for(int i=0;i<38;i++)
        {
            Nodo nodoActual = listaOrdenada.getMiListaNodosOrdenados(i);
            Nodo nodoSgte = listaOrdenada.getMiListaNodosOrdenados(i+1);
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
                raiz = new Nodo(suma,'+'); // creo el nodo que almacena la suma de las frecuencias
                arbol.insertar(raiz, nodoActual, derTemp); // inserto los nodos raiz, hijoIzq e hijoDer en el nuevo arbol
                System.out.println(raiz.getFrecuencia() + ":izq->" + nodoActual.getId() + ":der->" + derTemp.getId());
                listaSimbolos.agregar(nodoActual);
                
                if(derTemp.getSimbolo()!= '+')
                {
                    listaSimbolos.agregar(derTemp);
                }
                derTemp=raiz; // Almaceno el nodo raiz creado para ubicarlo como hijo derecho de la proxima raiz Suma
            }
        }
        
        
    }
     
   /* public void obtenerCodigoLetra(){
        
        String codigo = "";
        String simb = "";
        
        for(int i=0; i<38;i++)
        {
            Nodo nodoActual = listaSimbolos.getMiListaNodosOrdenados(i);
            
            
            
            if(nodoActual==null) // La lista es de 38 posiciones y tal vez no se llenen todas
            {                    //Me aseguro de leer solo las posiciones con nodos.
                i=38; 
            }
            else
            {  
                while(nodoActual.getPadre() != null)
                {
                    simb = nodoActual.getPadre().getSimbolo() + "";
                    
                }
                
            }
        }
    }*/
    
    public void gestionar(){
        crearListaNodos();
        crearArbol();
        //arbol.recorrerAmplitud(arbol.getRaiz());
    }
}
