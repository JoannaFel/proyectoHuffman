/*
 * Tabla que almacena los caracteres, su frecuencia y su codigo huffman.
 */
package EstructurasDatos;

import proyectohuffman.Caracter;

public class Tabla {

    Caracter[] caracteres;

    public Tabla() {
        caracteres = new Caracter[39];
    }

    public void insertar(int llave, Caracter simbolo) {
        caracteres[llave] = simbolo;
    }

    public Caracter buscar(int llave) {
        return caracteres[llave];
    }
    
    /*
    * La funcion hash toma el cod ascii de cada char y saca el modulo de dividirlo por 39.
    * Evito colisiones ocupando los slots null que haya en la tabla
    */
    public int funcionHash(char simbolo) {
        int hash;
        int ascii = (int) simbolo;
        if (simbolo == ' ') {
            ascii = 47;
        }
        if (simbolo == ',') {
            ascii = 123;
        }
        hash = ascii % 39;
        return hash;
    }
    //muestra por consola el el caracter y el cogido binario generado
    public String imprimir() {
        String tablaInfo = "";
        for (int i = 0; i < 39; i++) {
            if (caracteres[i] != null) {
                tablaInfo = tablaInfo + caracteres[i].getCaracter() +" -------- "+ caracteres[i].getCodigo() + "\n";
            }
        }
        return tablaInfo;
    }
}