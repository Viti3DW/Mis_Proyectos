/**
* Clase ApplicationController.java
*
* @author Victor Fernandez Menendez
* @version 1.0
*/

package modelo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Estudiante {

    private final IntegerProperty id;
    private final StringProperty apellidos;
    private final StringProperty nombre;
    private final StringProperty situacion;

    // CONSTRUCTOR
    public Estudiante(int id, String apellidos, String nombre, String situacion) {
        this.id = new SimpleIntegerProperty(id);
        this.apellidos = new SimpleStringProperty(apellidos);
        this.nombre = new SimpleStringProperty(nombre);
        this.situacion = new SimpleStringProperty(situacion);
    }
    
 // --- ID ---
    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    // --- APELLIDOS ---
    public String getApellidos() {
        return apellidos.get();
    }

    public void setApellidos(String apellidos) {
        this.apellidos.set(apellidos);
    }

    public StringProperty apellidosProperty() {
        return apellidos;
    }

    // --- NOMBRE ---
    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    // --- SITUACIÓN ---
    public String getSituacion() {
        return situacion.get();
    }

    public void setSituacion(String situacion) {
        this.situacion.set(situacion);
    }

    public StringProperty situacionProperty() {
        return situacion;
    }
    
    @Override
    public String toString() {
        return "Estudiante: ID=" + getId() + "Nombre=" + getNombre() + " " + getApellidos() + "Situacion=" + getSituacion();
    }
}