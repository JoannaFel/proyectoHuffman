package proyectohuffman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author oscar
 */
public class Archivo {
    String linea,linea2;
    
    public Archivo() {
        linea2="";
        leerArchivo();
    }
    
    public void leerArchivo(){
        // Lectura del fichero
        
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File ("archivo.txt");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);


            while( (linea = br.readLine()) != null)
                //System.out.println(linea);
                linea2 += linea; 
        }
        catch(Exception e){
            e.printStackTrace();
        }finally{
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try{                    
                if( null != fr ){   
                   fr.close();     
                }                  
            }catch (Exception e2){ 
                e2.printStackTrace();
            }
        }
   }
    
   public String getTexto(){
       return linea2;
   }

}