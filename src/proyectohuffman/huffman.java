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
    Archivo archivo;
    char[] texto;
    Arbol arbol;
    Tabla tabla;
    String codigoHuffman;
    
    
    public huffman(){
        //lista = new Lista();
        arbol = new Arbol();
        archivo = new Archivo();
        tabla = new Tabla();
        
    }
   
    public void crearListaNodos(){
        String textoLeido = archivo.getTexto().toLowerCase();
        texto = textoLeido.toCharArray();
        Caracter caracter = null;
        int hash,frecuencia;
        tabla = new Tabla();
        ArbolBinario abb = new ArbolBinario();
        
        for(int i=0;i<texto.length;i++)
        {
            
            char car = texto[i];
            hash = tabla.hash(car);
            if(tabla.buscar(hash) == null)
            {
                caracter = new Caracter();
                caracter.setCaracter(car);
                frecuencia = caracter.getFrecuencia() + 1;
                caracter.setFrecuencia(frecuencia);
                tabla.insertar(hash, caracter);
            }
            else
            {
                if(car == tabla.buscar(hash).getCaracter())
                {
                    frecuencia = caracter.getFrecuencia() + 1;
                    caracter.setFrecuencia(frecuencia);
                }
            }
            
        }
        
        for(int i=0; i<39;i++)
        {
            if(tabla.buscar(i) != null){
            System.out.println(i + "." + tabla.buscar(i).getCaracter() + "-->" + tabla.buscar(i).getFrecuencia());
            abb.insertar(tabla.buscar(i).getFrecuencia(),tabla.buscar(i).getCaracter());
            }
        }
        
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
        
        for(int i=0;i<39;i++)
        {
            Nodo nodoActual = listaOrdenada.getMiListaNodosOrdenados(i);
            Nodo nodoSgte = listaOrdenada.getMiListaNodosOrdenados(i+1);
            if(nodoActual==null) // La lista es de 38 posiciones y tal vez no se llenen todas
            {                    //Me aseguro de leer solo las posiciones con nodos.
                i=39; 
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
        
        for(int i=0; i<39;i++)
        {
            Nodo nodoActual = listaOrdenada.getMiListaNodosOrdenados(i);
            if(nodoActual==null) // La lista es de 38 posiciones y tal vez no se llenen todas
            {                    //Me aseguro de leer solo las posiciones con nodos.
                i=39; 
            }
            else
            {  
                padreTemp= nodoActual.getPadre();
                simbFin = "" + nodoActual.getId();
                
                while(padreTemp != null)
                {
                    
                    simbPadre = "" + padreTemp.getId(); 
                    codigo = simbPadre + codigo;
                    padreTemp = padreTemp.getPadre();
                }
                
                codigo = codigo + simbFin ;
                hash = tabla.hash(nodoActual.getSimbolo());
                
                caracter = tabla.buscar(hash);
                caracter.setCodigo(codigo);
                codigo= "";
            }
        }
    }
    
    public void obtenerCodigoHuffman()
    {
        int hash;
        String codigoLetra;
        codigoHuffman = "";
        
        for(int i=0;i<texto.length;i++)
        {
            hash = tabla.hash(texto[i]);
            codigoLetra = tabla.buscar(hash).getCodigo();
            codigoHuffman =  codigoHuffman + codigoLetra ;
        }
        //codigoHuffman = ;
        System.out.println(codigoHuffman);
        
        archivo.escribirArchivo(codigoHuffman + " ");
    }
    
    public void imprimirTabla()
    {
        tabla.imprimir();
    }
    public void gestionar(){
        crearListaNodos();
        crearArbol();
        obtenerCodigoLetra();
        obtenerCodigoHuffman();
        imprimirTabla();
        //arbol.recorrerAmplitud(arbol.getRaiz());
    }
}
