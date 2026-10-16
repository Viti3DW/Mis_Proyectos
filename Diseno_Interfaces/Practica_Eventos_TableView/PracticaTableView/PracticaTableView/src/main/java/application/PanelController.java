/**
* Clase ApplicationController.java
*
* @author Victor Fernandez Menendez
* @version 1.0
*/

package application;

import javafx.collections.FXCollections;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import java.util.Optional;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import modelo.Estudiante;

public class PanelController {

    // --- COMPONENTES INYECTADOS DESDE EL FXML ---
    @FXML
    private TableView<Estudiante> tablaEstudiantes;

    @FXML
    private TableColumn<Estudiante, Number> colId;

    @FXML
    private TableColumn<Estudiante, String> colApellidos;

    @FXML
    private TableColumn<Estudiante, String> colNombre;

    @FXML
    private TableColumn<Estudiante, String> colSituacion;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtApellidos;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtSituacion;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnAceptar;

    @FXML
    private Label lblEstado;

    // Lista observable donde guardaremos los estudiantes
    private ObservableList<Estudiante> listaEstudiantes;

    /**
     * Este método se ejecuta automáticamente cuando JavaFX termina de cargar el archivo FXML.
     * Equivale a inicializar y arrancar la lógica de la pantalla.
     */
    @FXML
    public void initialize() {
        configurarColumnas();
        cargarDatosPrueba();
        //configurarBorradoTeclado();
        
        // 1. Mensaje en la barra de estado al arrancar (Ampliacion 1 - Atajo)
        lblEstado.setText("Estudiantes cargados: " + listaEstudiantes.size() + " | Pulsa Supr para eliminar");

        // 2. Tooltip sobre la tabla
        Tooltip tooltipTabla = new Tooltip("Selecciona una fila y pulsa la tecla Supr para eliminar");
        tablaEstudiantes.setTooltip(tooltipTabla);
    }

    /**
     * Conecta cada columna de la tabla con la propiedad correspondiente de Estudiante.
     */
    private void configurarColumnas() {
        // Para el ID usamos Number porque IntegerProperty hereda de ObservableValue<Number>
        colId.setCellValueFactory(fila -> fila.getValue().idProperty());
        colApellidos.setCellValueFactory(fila -> fila.getValue().apellidosProperty());
        colNombre.setCellValueFactory(fila -> fila.getValue().nombreProperty());
        colSituacion.setCellValueFactory(fila -> fila.getValue().situacionProperty());
    }

    /**
     * Crea 5 estudiantes de prueba, los mete en la lista y los asigna a la tabla.
     */
    private void cargarDatosPrueba() {
        listaEstudiantes = FXCollections.observableArrayList(
            new Estudiante(1, "García López", "Ana", "Matriculado"),
            new Estudiante(2, "Fernández Ruiz", "Pablo", "Matriculado"),
            new Estudiante(3, "Martínez Sanz", "Lucía", "Pendiente"),
            new Estudiante(4, "Álvarez Díaz", "Marcos", "Matriculado"),
            new Estudiante(5, "Suárez Menéndez", "Carla", "Matriculado")
        );

        // Conectamos la lista con la tabla
        tablaEstudiantes.setItems(listaEstudiantes);

        // Mensaje inicial en la barra de estado inferior
        lblEstado.setText("Estudiantes cargados: " + listaEstudiantes.size());
    }
    
    /**
     * Se ejecuta al hacer clic sobre la tabla.
     * Carga los datos en el formulario únicamente si es doble clic con botón izquierdo sobre una fila.
     */
    @FXML
    private void manejarClickTabla(javafx.scene.input.MouseEvent event) {
        System.out.println("Clic detectado: " + event.getClickCount() + " botón: " + event.getButton());

        if (event.getButton() == javafx.scene.input.MouseButton.PRIMARY && event.getClickCount() == 2) {
            Estudiante seleccionado = tablaEstudiantes.getSelectionModel().getSelectedItem();
            
            System.out.println("Estudiante seleccionado: " + seleccionado);

            if (seleccionado != null) {
                txtId.setText(String.valueOf(seleccionado.getId()));
                txtApellidos.setText(seleccionado.getApellidos());
                txtNombre.setText(seleccionado.getNombre());
                txtSituacion.setText(seleccionado.getSituacion());
            }
        }
    }
    
    /**
     * Limpia todas las cajas de texto del formulario y deselecciona la fila.
     */
    @FXML
    private void manejarCancelar() {
        txtId.clear();
        txtApellidos.clear();
        txtNombre.clear();
        txtSituacion.clear();
        tablaEstudiantes.getSelectionModel().clearSelection();
        lblEstado.setText("Edición cancelada");
    }

    /**
     * Aplica los cambios escritos en el formulario sobre el estudiante seleccionado.
     */
    @FXML
    private void manejarAceptar() {
        Estudiante seleccionado = tablaEstudiantes.getSelectionModel().getSelectedItem();

        if (seleccionado == null) {
            lblEstado.setText("Error: Selecciona primero un estudiante con doble clic");
            return;
        }

        try {
            // Actualizamos los datos del objeto Estudiante
            seleccionado.setId(Integer.parseInt(txtId.getText().trim()));
            seleccionado.setApellidos(txtApellidos.getText().trim());
            seleccionado.setNombre(txtNombre.getText().trim());
            seleccionado.setSituacion(txtSituacion.getText().trim());

            lblEstado.setText("Estudiante " + seleccionado.getNombre() + " actualizado correctamente");

        } catch (NumberFormatException e) {
            lblEstado.setText("Error: El ID debe ser un número entero válido");
        }
    }
    
    /**
     * Elimina el alumno seleccionado al presionar la tecla Supr (DELETE).
     */
    private void configurarBorradoTeclado() {
        tablaEstudiantes.setOnKeyPressed(event -> {
            if (event.getCode() == javafx.scene.input.KeyCode.DELETE) {
                Estudiante seleccionado = tablaEstudiantes.getSelectionModel().getSelectedItem();

                if (seleccionado != null) {
                    // 1. Lo borramos de la lista observable
                    listaEstudiantes.remove(seleccionado);

                    // 2. Si estaba cargado en el formulario, limpiamos los campos
                    manejarCancelar();

                    // 3. Actualizamos la barra de estado
                    lblEstado.setText("Estudiante eliminado. Total restantes: " + listaEstudiantes.size());
                }
            }
        });
    }
    
    @FXML
    private void manejarTeclaTabla(javafx.scene.input.KeyEvent event) {
        // 1. ¿Ha sido la tecla Supr?
        if (event.getCode() == javafx.scene.input.KeyCode.DELETE) {
            
            // Obtenemos el alumno seleccionado
            Estudiante seleccionado = tablaEstudiantes.getSelectionModel().getSelectedItem();

            // 2. Si no hay nadie seleccionado, avisamos abajo y salimos (Prueba 10)
            if (seleccionado == null) {
                lblEstado.setText("Debes seleccionar un estudiante antes de pulsar Supr");
                return;
            }

            // 3. Si hay alumno, preparamos la ventana de confirmación
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Eliminar estudiante");
            alerta.setHeaderText("¿Eliminar a " + seleccionado.getNombre() + " " + seleccionado.getApellidos() + "?");
            alerta.setContentText("Esta acción no se puede deshacer.");

            // Mostramos el diálogo y esperamos a que el usuario pulse un botón
            Optional<ButtonType> respuesta = alerta.showAndWait();

            // 4. Solo si pulsa expresamente Aceptar, borramos
            if (respuesta.isPresent() && respuesta.get() == ButtonType.OK) {
                listaEstudiantes.remove(seleccionado);
                manejarCancelar(); // Limpiamos el formulario por si estaba cargado
                lblEstado.setText("Eliminado: " + seleccionado.getNombre() + " " + seleccionado.getApellidos());
            }
        }
    }
    
    /**
     * Limpia todas las cajas de texto del formulario y deselecciona la fila.
     */
    @FXML
    private void manejarLimpiar() {
        txtId.clear();
        txtApellidos.clear();
        txtNombre.clear();
        txtSituacion.clear();
        tablaEstudiantes.getSelectionModel().clearSelection();
        lblEstado.setText("Campos limpios");
    }

}