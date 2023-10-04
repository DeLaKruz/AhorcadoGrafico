package com.mycompany.ahorcadografico;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.ImageView;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Yeray
 */

/**JUGADOR
 * Esta es mi clase jugador, donde guardo su nombre, los puntos y su foto.
 * Tiene sus constructores, getter y setter.
 * @author Yeray
 */
public class Jugador {

 private StringProperty nombre;
    private IntegerProperty puntos;
    private ObjectProperty<ImageView> foto;

    public Jugador(String nombre, int puntos, ImageView foto) {
        this.nombre = new SimpleStringProperty(nombre);
        this.puntos = new SimpleIntegerProperty(puntos);
        this.foto = new SimpleObjectProperty<>(foto);
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public IntegerProperty puntosProperty() {
        return puntos;
    }

    public int getPuntos() {
        return puntos.get();
    }

    public void setPuntos(int puntos) {
        this.puntos.set(puntos);
    }

    public ObjectProperty<ImageView> fotoProperty() {
        return foto;
    }

    public ImageView getFoto() {
        return foto.get();
    }

    public void setFoto(ImageView foto) {
        this.foto.set(foto);
    }

}
