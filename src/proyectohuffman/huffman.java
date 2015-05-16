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
    Archivo texto;
    //string que contiene el texto presente en el archivo
    String textoleido;
    //alfabeto a usar de tamaño constante
    char[] letras= {'a','b','c','d','e','f','g','h','i','j','k','l','m','n'
            ,'o','p','q','r','s','t','u','v','w','x','y','z','1','2','3','4'
            ,'5','6','7','8','9','0','.',',',' '};
    
    //arreglo de enteros de longitud alfabeto y va a contener la suma de cada letra
    //que se encuentre en el texto
    int[] cantXletra;
    //arreglo de char que contiene el texto leido por consola
    char[] textoLeidoChar;
    ArbolBinario abb;
    
    public huffman(){    
        arbol = new Arbol();
        texto = new Archivo();  
        textoleido = texto.getTexto();
        textoLeidoChar = textoleido.toCharArray();
        cantXletra = new int[123];
        abb = new ArbolBinario();
    }
    
    public void realizarInsercion(){
        for(int i=0;i<letras.length;i++){
            int num = convertirAscii(letras[i]);
            if(cantXletra[num] != 0){
                abb.insertar(cantXletra[num],letras[i]);
            }
        }
    }
    
    public void crearListaNodos(){
        realizarInsercion();
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
    //metodo que compara una letra contra todo el alfabeto y suma 1 a un arreglo
    //de enteros cantXletras en la posicion correspondiente a la letra del alfabeto.
    public void contar_letras(){
        for(int i=0; i < textoLeidoChar.length; i++){
            int num = convertirAscii(textoLeidoChar[i]);
            cantXletra[num] = cantXletra[num]+1; 
        }
    }
    
    public int convertirAscii(char a){
        int ascii;
        char caracter;
        caracter = a;
        ascii = (int) caracter;
        return ascii;
    }
    
    public void gestionar(){
        contar_letras();
        crearListaNodos();
        crearArbol();  
        
        char character = 'a';    
                
        //System.out.println("valor de a: "+ascii);
        
        //arbol.recorrerAmplitud(arbol.getRaiz());
    }
}
            /*for(int j=0; j<letras.length; j++){
                if(textoLeidoChar[i] == letras[j] ) {
                    cantXletra[j] = cantXletra[j]+1;    
                    //System.out.println("contador"+cantXletra[j]);
                }   
            }*/

        
        /*abb.insertar(5,null);
        abb.insertar(7,"a");
        abb.insertar(1,"s");
        abb.insertar(8,"w");
        abb.insertar(8,"q");
        abb.insertar(6,"x");
        abb.insertar(10,"l");*/
        