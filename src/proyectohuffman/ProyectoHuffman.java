/*
 * Usa las estructuras de datos y objetos necesarios para llevar a cabo el algoritmo que 
 * genere el codigo huffman.
 */
package proyectohuffman;

import EstructurasDatos.ArrayNodos;
import EstructurasDatos.Nodo;
import EstructurasDatos.Arbol;
import EstructurasDatos.Tabla;
import EstructurasDatos.ArbolBinario;

public class ProyectoHuffman {

    ArrayNodos listaOrdenada;
    Archivo archivo;
    char[] texto;
    Arbol arbol;
    Caracter caracter;
    int tamanyoArray;
    Tabla tabla;
    String codigoHuffman;

    public ProyectoHuffman() {
        //lista = new ArrayNodos();
        arbol = new Arbol();
        archivo = new Archivo();
        tabla = new Tabla();
    }

    public void leerTexto() {
        String textoLeido = archivo.getTexto().toLowerCase(); // Cadena con el texto del archivo
        texto = textoLeido.toCharArray(); // array con los caracteres del texto
        caracter = null; // Objeto caracter que tendra letra,frecuencia y un codigo huffman.
        int hash, frecuencia, cont = 0; // cont: Contador que aumenta en 1 cuando ingreso un nuevo caracter 
        // a la tabla, esto con el fin de definir el tamanyo para el arreglo
        // ordenado de nodos         
        tabla = new Tabla();            // tabla funcionHash

        for (int i = 0; i < texto.length; i++) { // lee el arreglo con los caracteres del archivo de texto
            char letra = texto[i];
            hash = tabla.funcionHash(letra); // Aplico funcion funcionHash al caracter para asignar posicion
            // en la tabla hash
            if (tabla.buscar(hash) == null) { // Busco el contenido en la posicion
                caracter = new Caracter(); //Creo un nuevo objeto 
                caracter.setCaracter(letra); // Asigno al atributo caracter la letra 
                frecuencia = caracter.getFrecuencia() + 1; // Inicio la frecuencia del caracter,
                // por ser la primera vez leida--> frecuencia = 1
                caracter.setFrecuencia(frecuencia); // Asigno la frecuencia al caracter
                tabla.insertar(hash, caracter);     // Inserto en la tabla hash el nuevo objeto caracter
                cont++; // Por cada nuevo caracter insertado aumento el contador en 1
            } else { // Si la posicion en la tabla ya esta ocupada
                if (letra == tabla.buscar(hash).getCaracter()) {
                    caracter = tabla.buscar(hash);
                    frecuencia = caracter.getFrecuencia() + 1; // Aumento frecuencia
                    caracter.setFrecuencia(frecuencia);// Cambio la frecuencia ya almacenada por la nueva
                }
            }
        }
        tamanyoArray = cont;
    }
    /*
     * Crea la lista de nodos ordenada por frecuencias ascendentemente.
     */

    public void crearListaNodos() {
        ArbolBinario abb = new ArbolBinario(); // Estructura para ordenar las frecuencias de los nodos

        for (int i = 0; i < 39; i++) {
            if (tabla.buscar(i) != null) {
                System.out.println(i + "." + tabla.buscar(i).getCaracter() + "-->" + tabla.buscar(i).getFrecuencia());
                abb.insertar(tabla.buscar(i).getFrecuencia(), tabla.buscar(i).getCaracter());
            }
        }
        abb.crearLista(tamanyoArray);
        abb.inorderTreeWalk(abb.getRaiz());
        listaOrdenada = abb.getListaNodos();
        for (int i = 0; i < listaOrdenada.getTam(); i++) // Vuelve los null hijos de los nodos de la lista
        {

            listaOrdenada.getNodo(i).setHijoDerecho(null);
            listaOrdenada.getNodo(i).setHijoIzquierdo(null);

        }
    }

    /*
     * Crea el arbol con las sumas de frecuencias 
     */
    public void crearArbol() {
        int suma = 0;
        Nodo raiz;
        Nodo derTemp = null;
        for (int i = 0; i < listaOrdenada.getTam(); i++) {
            Nodo nodoActual = listaOrdenada.getNodo(i);

            if (i == 0 && listaOrdenada.getTam() > 1) {

                Nodo nodoSgte = listaOrdenada.getNodo(i + 1);
                suma = nodoActual.getFrecuencia() + nodoSgte.getFrecuencia();// Suma los nodos de menor frecuencia
                derTemp = nodoSgte;                                         // Variable temporal como hijo derecho de una raiz (Suma)
                i++;                                                        // Me aseguro de no leer la 2 posicion i=1
            } else {
                suma = suma + nodoActual.getFrecuencia(); // Sumo los nodos 
            }
            raiz = new Nodo(suma, '+'); // creo el nodo que almacena la suma de las frecuencias
            arbol.insertar(raiz, nodoActual, derTemp); // inserto los nodos raiz, hijoIzq e hijoDer en el nuevo arbol               
            derTemp = raiz; // Almaceno el nodo raiz creado para ubicarlo como hijo derecho de la proxima raiz Suma

        }
    }

    /*
     * Obtener el codigo de cada letra leyendo el id de cada nodo y el de sus padres.
     */
    public void obtenerCodigoLetra() {
        Nodo padreTemp;
        Caracter caracter;
        String codigo = "", simbFin = "", simbPadre = "";
        int hash, cont = 0;

        for (int i = 0; i < listaOrdenada.getTam(); i++) {
            Nodo nodoActual = listaOrdenada.getNodo(i);
            padreTemp = nodoActual.getPadre(); // padre del nodo
            simbFin = "" + nodoActual.getId(); // Id de nodo del que se obtendra el codigo
            cont++;
            while (padreTemp != null) {

                simbPadre = "" + padreTemp.getId(); // id del nodo padre
                codigo = simbPadre + codigo;        // Concatena los id
                padreTemp = padreTemp.getPadre();   // Padre del padre del nodo..
                cont++;
            }

            codigo = (codigo + simbFin).trim(); // Elimino espacios de la cadena
            hash = tabla.funcionHash(nodoActual.getSimbolo()); // Aplico funcion hash             
            caracter = tabla.buscar(hash);                     // para buscar la posicion  de la letra 
            caracter.setCodigo(codigo);                        // y almacenar el codigo que le corresponde
            codigo = ""; // Vuelvo la cadena vacia para almacenar el codigo del sgte nodo.

        }
    }

    /*
     * Obtengo el codigo huffman de la cadena de texto del archivo.
     */
    public void obtenerCodigoHuffman() {
        int hash;
        String codigoLetra;
        codigoHuffman = "";

        for (int i = 0; i < texto.length; i++) { // leo el array con los caracteres del archivo
            hash = tabla.funcionHash(texto[i]);          // aplico funcion hash al caracter leido
            codigoLetra = tabla.buscar(hash).getCodigo();// lo busco en la tabla y obtengo su codigo 
            codigoHuffman = codigoHuffman + codigoLetra; // Concateno los codigos de las letras que leo
        }
        System.out.println(codigoHuffman);
        //archivo.escribirArchivo(codigoHuffman); //Escribo en un txt la codificacion binaria generada
    }

    public void crearArchivos() {

        String cantNodos = "Nodos creados:" + arbol.calcularCantidadNodos(arbol.getRaiz());
        String profundidadArbol = "Profundidad maxima del arbol generado:" + arbol.profundidad();
        String tablaInfo = "Simbolo -- Caracter \n" + tabla.imprimir();
        String informacion = cantNodos + "\n" + profundidadArbol + "\n" + tablaInfo;

        String textoAscii = generarAscii(codigoHuffman);

        archivo.escribirArchivo(codigoHuffman, informacion, textoAscii);
        System.out.println(informacion);
    }

    //recibo el codigoHufman en binario y lo parte en cadenas de 8 bits
    //que luego se convierten a entero y a su vez a ascii.
    public String generarAscii(String binario) {
        int num;
        char ascii;
        String elemento;
        String textoAscii = "";
        while ((binario.length() % 8) != 0) {
            binario = binario + "0";
        }
        for (int i = 0; i <= binario.length() - 8; i++) {
            if (i == 0) {
                elemento = binario.substring(i, i + 8);
                num = Integer.parseInt(elemento, 2);
                ascii = (char) num;
                textoAscii += "" + ascii;
            } else {
                if (i % 8 == 0) {
                    elemento = binario.substring(i, i + 8);
                    num = Integer.parseInt(elemento, 2);
                    ascii = (char) num;
                    textoAscii += "" + ascii;
                }
            }
        }
        return textoAscii;
    }

    public void gestionar() {
        leerTexto();
        if (tamanyoArray != 1) {
            crearListaNodos();
            crearArbol();
            obtenerCodigoLetra();
            obtenerCodigoHuffman();
            crearArchivos();
        } else {
            System.out.println(texto[0]);
        }
    }
}
