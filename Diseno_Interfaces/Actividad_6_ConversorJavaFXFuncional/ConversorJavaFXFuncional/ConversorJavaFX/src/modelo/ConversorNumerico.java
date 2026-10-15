/**
* Clase ConversorNumerico.java
*
* @author Victor Fernandez Menendez
* @version 1.0
*/

package modelo;

public class ConversorNumerico {

    // Método para calcular el binario
    public static String decimalABinario(int numero) {
        return Integer.toBinaryString(numero);
    }

    // Método para calcular el hexadecimal
    public static String decimalAHexadecimal(int numero) {
        return Integer.toHexString(numero).toUpperCase();
    }
}