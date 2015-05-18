/**
 * Clase para leer el archivo txt y generar archivos con: -Codificacion Binaria
 * -Codificacion ascii -Informacion de nodos
 */
package proyectohuffman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Archivo {

    String linea, linea2;

    public Archivo() {
        linea2 = "";
        leerArchivo();
    }

    public void leerArchivo() {
        File archivo        = null;
        FileReader fr       = null;
        BufferedReader br   = null;

        try {
            
            archivo = new File("entrada.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            while ((linea = br.readLine()) != null) 
            {
                linea2 += linea;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void escribirArchivo(String codigo,String info,String ascii) {
        FileWriter ficheroCodigo    = null;
        FileWriter ficheroInfo      = null;
        FileWriter ficheroAscii     = null;
        try {
            ficheroCodigo   = new FileWriter("CodigoHuffman.txt");
            ficheroCodigo.write(codigo);
            
            ficheroInfo     = new FileWriter("Informacion.txt");
            ficheroInfo.write(info);
            
            ficheroAscii    = new FileWriter("Ascii.txt");
            ficheroAscii.write(ascii);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != ficheroCodigo) {
                    ficheroCodigo.close();
                    ficheroInfo.close();
                    ficheroAscii.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        System.out.print("Archivo Creado!");
    }

    public String getTexto() {
        return linea2;
    }
}
