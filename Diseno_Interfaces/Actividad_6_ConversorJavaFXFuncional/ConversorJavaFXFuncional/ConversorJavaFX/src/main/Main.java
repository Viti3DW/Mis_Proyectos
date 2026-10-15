/**
* Clase Main.java
*
* @author Victor Fernandez Menendez
* @version 1.0
*/

package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
        	// Esto carga el diseño de la aplicación
            Parent root = FXMLLoader.load(getClass().getResource("/application/Conversor.fxml"));
            Scene scene = new Scene(root);
            
            primaryStage.setTitle("Conversor");
            primaryStage.setScene(scene);
            primaryStage.show();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}