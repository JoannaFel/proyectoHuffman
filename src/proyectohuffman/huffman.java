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
   //Lista listaSimbolos;
    //Nodo[] listaNodos;
    Arbol arbol;
    Tabla tabla;
    
    
    public huffman(){
        //lista = new Lista();
        arbol = new Arbol();
    }
    public void crearListaNodos(){
        ArbolBinario abb = new ArbolBinario();
        abb.insertar(1,'H');
        abb.insertar(3,'o');
        abb.insertar(2,'l');
        abb.insertar(2,'a');
        abb.insertar(1,'c');
        abb.insertar(1,'n');
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
                String simboloMay = simbolo.toLowerCase();
                listaOrdenada.getMiListaNodosOrdenados(i).setSimbolo(simboloMay.charAt(0));
                listaOrdenada.getMiListaNodosOrdenados(i).setHijoDerecho(null);
                listaOrdenada.getMiListaNodosOrdenados(i).setHijoIzquierdo(null);
            }
        }        
    }
    public void crearArbol(){
        int suma = 0;
        Nodo raiz ;
        Nodo derTemp = null;
        //listaSimbolos = new Lista();
        
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
                System.out.println(raiz.getFrecuencia() + ":izq->" + nodoActual.getFrecuencia()+ ":der->" + derTemp.getFrecuencia());
                //listaOrdenada.agregar(nodoActual);

                //if(derTemp.getSimbolo()!= '+')
                //{
                    //listaSimbolos.agregar(derTemp);
                //}
                //System.out.println(i + "." + nodoActual +"-->"+nodoActual.getPadre().getFrecuencia());

                derTemp=raiz; // Almaceno el nodo raiz creado para ubicarlo como hijo derecho de la proxima raiz Suma
            
            }
        }
    }
    public void obtenerCodigoLetra(){
        
        Nodo padreTemp;
        Caracter caracter;
        String codigo = "",simbFin = "", simbPadre = "";
        
        int hash;
        tabla = new Tabla();
        for(int i=0; i<38;i++)
        {
            Nodo nodoActual = listaOrdenada.getMiListaNodosOrdenados(i);
            if(nodoActual==null) // La lista es de 38 posiciones y tal vez no se llenen todas
            {                    //Me aseguro de leer solo las posiciones con nodos.
                i=38; 
            }
            else
            {  
                //System.out.println(i + "." + nodoActual +"-->"+nodoActual.getPadre().getFrecuencia());
                caracter = new Caracter();
                padreTemp= nodoActual.getPadre();
                simbFin = "" + nodoActual.getId();
                while(padreTemp != null)
                {
                    
                    simbPadre = "" + padreTemp.getId(); 
                    codigo = simbPadre + codigo;
                    padreTemp = padreTemp.getPadre();
                }
                codigo = codigo + simbFin;
                caracter.setCaracter(nodoActual.getSimbolo());
                caracter.setCodigo(codigo);
                caracter.setFrecuencia(nodoActual.getFrecuencia());
                hash = tabla.hash(caracter.getCaracter());
                tabla.insertar(hash, caracter);
                codigo= "";
            }
        }
    }
    
   /* public void obtenerCodigoArchivo()
    {
        char[] texto = {'H','o','l','a','a','c','o','l','o','n'};
        for(int i=0;i<39;i++)
        {
            
        }
    }*/
    
    public void imprimirTabla()
    {
        tabla.imprimir();
    }
    public void gestionar(){
        crearListaNodos();
        crearArbol();
        obtenerCodigoLetra();
        imprimirTabla();
        //arbol.recorrerAmplitud(arbol.getRaiz());
    }
}
