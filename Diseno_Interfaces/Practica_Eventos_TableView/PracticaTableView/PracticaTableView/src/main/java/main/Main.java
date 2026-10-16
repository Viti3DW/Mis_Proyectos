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
            // Cargamos el diseño desde el archivo FXML
            // Si tu panel.fxml está directamente en src/main/resources, la ruta es "/panel.fxml"
            // Si lo metiste dentro de una carpeta "application", sería "/application/panel.fxml"
            Parent root = FXMLLoader.load(getClass().getResource("/panel.fxml"));

            Scene scene = new Scene(root);

            primaryStage.setTitle("Práctica con TableView");
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