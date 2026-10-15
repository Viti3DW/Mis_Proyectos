/**
* Clase ConversorController.java
*
* @author Victor Fernandez Menendez
* @version 1.0
*/

package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import modelo.ConversorNumerico;

public class ConversorController {

    // Conexión con las cajas de texto donde el usuario escribe
    @FXML
    private TextField txtDecimalBinario;

    @FXML
    private TextField txtDecimalHexa;

    // Conexión con las etiquetas donde mostraremos el resultado
    @FXML
    private Label lblResultadoBinario;

    @FXML
    private Label lblResultadoHexa;
    
    @FXML
    private VBox panelBinario;

    @FXML
    private VBox panelHexa;

    @FXML
    private void convertirBinario(ActionEvent event) {
        try {
            
        	// Leemos el texto de la caja de binario
            String texto = txtDecimalBinario.getText();
            
            // Convertimos el texto a un int
            int numero = Integer.parseInt(texto);
            
            // Llamamos al modelo pasándole 'numero'
            String binario = ConversorNumerico.decimalABinario(numero);
            
            // Mostramos el resultado
            lblResultadoBinario.setText("Resultado: " + binario);
            
        } catch (NumberFormatException e) {
            // Si el usuario no escribe algo válido sacamos un alert en la pantalla
        	Alert alerta = new Alert(Alert.AlertType.ERROR);
        	alerta.setTitle("Error en la entrada de valores");
        	alerta.setHeaderText("Valor no válido");
        	alerta.setContentText("Por favor, introduce un número entero.");
        	alerta.showAndWait();
        }
    }

    // 4. Método para convertir a Hexadecimal
    @FXML
    private void convertirHexa(ActionEvent event) {
        try {
            String texto = txtDecimalHexa.getText();
            int numero = Integer.parseInt(texto);
            String hexa = ConversorNumerico.decimalAHexadecimal(numero);
            lblResultadoHexa.setText("Resultado: " + hexa);
            
        } catch (NumberFormatException e) {
            lblResultadoHexa.setText("Por favor, introduce un número válido");
        }
    }
    
    @FXML
    private void mostrarBinario(ActionEvent event) {
        panelBinario.setVisible(true);
        panelHexa.setVisible(false);
    }

    @FXML
    private void mostrarHexa(ActionEvent event) {
        panelBinario.setVisible(false);
        panelHexa.setVisible(true);
    }
    
    
}