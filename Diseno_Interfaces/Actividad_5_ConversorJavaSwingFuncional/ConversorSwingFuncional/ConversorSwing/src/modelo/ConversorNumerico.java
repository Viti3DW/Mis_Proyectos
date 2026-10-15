/**
* Clase ConversorNumerico.java
*
* @author Victor Fernandez Menendez
* @version 1.0
*/
package modelo;

public class ConversorNumerico {

    public static String decimalABinario(int numero) {
        return Integer.toBinaryString(numero);
    }

    public static String decimalAHexadecimal(int numero) {
        return Integer.toHexString(numero).toUpperCase();
    }
}