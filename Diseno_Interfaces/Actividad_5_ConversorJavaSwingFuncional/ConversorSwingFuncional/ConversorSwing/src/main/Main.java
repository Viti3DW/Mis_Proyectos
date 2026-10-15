/**
* Clase Main.java
*
* @author Victor Fernandez Menendez
* @version 1.0
*/

package main;

import java.awt.EventQueue;
import application.ConversorSwing;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // Se crea la ventana
                    ConversorSwing window = new ConversorSwing();
                    window.hacerVisible();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}