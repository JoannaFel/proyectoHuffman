/*
 * Objeto Caracter para ser almacenado en la tabla hash.
 */
package proyectohuffman;

public class Caracter {
    private char caracter;
    private String codigo;
    private int frecuencia;
    
    public Caracter(){
        caracter    = ' ';
        codigo      = "";
        frecuencia  = 0; 
    }
    
    public char getCaracter() {
        return caracter;
    }

    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    } 
}
