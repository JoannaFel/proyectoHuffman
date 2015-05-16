package proyectohuffman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

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
    
    public void escribirArchivo(String codigo){
        FileWriter fichero = null;
        //PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("CodigoHuffman.txt");
            //pw = new PrintWriter(fichero);
 
            
            fichero.write(codigo);
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
        System.out.print("Archivo Creado!");
    }
    
   public String getTexto(){
       return linea2;
   }
   
}