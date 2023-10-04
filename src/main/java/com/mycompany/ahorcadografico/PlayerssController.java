/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.ahorcadografico;

import com.mycompany.ahorcadografico.Jugador;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.util.converter.IntegerStringConverter;

/**
 * FXML Controller class
 *
 * @author Yeray
 */
public class PlayerssController implements Initializable {

    @FXML
    private TableColumn<Jugador, String> elnombre;
    @FXML
    private TableColumn<Jugador, Integer> lospuntos;
    @FXML
    private TableColumn<Jugador, ImageView> lasfotos;
    @FXML
    private Button agregarbutton;
    @FXML
    private Button borrarbutton;
    @FXML
    private Button modificarbutton;
    @FXML
    private TableView<Jugador> tabla;
    public static ObservableList<Jugador> jugadores = FXCollections.observableArrayList();
    public List<Jugador> jugadoresSeleccionados;
    public Jugador jugador1Seleccionado;
    @FXML
    private TextField introducir;
    @FXML
    private Button volver;
    public static int indice = -1;
    public static int puntos;

    /**
     * TABLEVIEW Creo una lista, y una observablelist para poder ir modificando
     * y añadiendo objetos jugador a la tabla.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /**
         *
         * Deshabilito los botones, y actualizo la tabla cada vez que entro para
         * guardar los jugadores bien.
         *
         * Tengo un listener que mira si está seleccionandose algún jugador,
         * para habilitar los botones modificar y borrar.
         *
         * Y tengo una variable "indice" que cambia su valor dependiendo de que
         * jugador se esté seleccionando para jugar con el. Se llama indice
         * porque es el indice de la lista con el que se trabaja.
         */
        modificarbutton.setDisable(true);
        borrarbutton.setDisable(true);
        tabla.setItems(jugadores);
        tabla.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        tabla.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            boolean jugadorSeleccionado = newValue != null;
            modificarbutton.setDisable(!jugadorSeleccionado);
            borrarbutton.setDisable(!jugadorSeleccionado);
            indice = tabla.getSelectionModel().getSelectedIndex();
            System.out.println(indice);
        });

        elnombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        lospuntos.setCellValueFactory(new PropertyValueFactory<>("puntos"));
        lasfotos.setCellValueFactory(new PropertyValueFactory<>("foto"));
        lasfotos.setCellFactory(column -> new TableCell<Jugador, ImageView>() {
            private final ImageView imageView = new ImageView();

            /**
             * Aquí con la imagen seleccionada le damos anchura y altura,
             * siempre que haya imagen bien seleccionada.
             *
             */
            @Override
            protected void updateItem(ImageView imagen, boolean empty) {
                super.updateItem(imagen, empty);
                if (empty || imagen == null) {
                    setGraphic(null);
                } else {
                    imageView.setImage(imagen.getImage());
                    imageView.setFitWidth(75);
                    imageView.setFitHeight(75);
                    setGraphic(imageView);
                }
            }
        });

        tabla.setEditable(true);
        elnombre.setCellFactory(TextFieldTableCell.forTableColumn());
        lospuntos.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    }

    /**
     * Si pulsamos el botón, siempre que haya un nombre o no esté repetido, nos
     * dará a elegir una foto del PC y añadirá a la lista jugadores un nuevo
     * objeto jugador, con el nombre introducido en el textfield y con 0 puntos
     * ya que es nuevo.
     *
     * @param event
     */
    @FXML
    private void pulsaragregar(ActionEvent event) {
        String nombre = introducir.getText();
        boolean yaexiste = jugadores.stream()
                .anyMatch(jugador -> jugador.getNombre().equals(nombre));
        if (nombre.isEmpty()) {
            mostrarMensajeError("El campo de nombre está vacío.");
            return;
        } else if (yaexiste) {
            mostrarMensajeError("El jugador ya existe.");
            return;
        } else {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Seleccionar fotico");
            File archivo = fileChooser.showOpenDialog(null);
            if (archivo != null) {
                String rutaImagen = archivo.toURI().toString();
                ImageView imageView = new ImageView(new Image(rutaImagen));
                imageView.setFitWidth(75);
                imageView.setFitHeight(75);
                Jugador jugador = new Jugador(nombre, 0, imageView);
                jugadores.add(jugador);
                introducir.clear();
            }
        }

    }

    /**
     * Borra el jugador seleccionado.
     *
     * @param event
     */
    @FXML
    private void pulsarborrar(ActionEvent event) {
        jugadores.remove(indice);
        tabla.setItems(jugadores);
    }

    /**
     * Si pulsas este botón el jugador seleccionado cambiará su nombre al que
     * haya en el textfield "introducir" y dará a elegir una nueva foto.
     *
     * @param event
     */
    @FXML
    private void pulsarmodificar(ActionEvent event) {
        String nombre = introducir.getText();
        boolean yaexiste = jugadores.stream()
                .anyMatch(jugador -> jugador.getNombre().equals(nombre));

        if (nombre.isEmpty()) {
            mostrarMensajeError("El campo de nombre está vacío.");
            return;
        } else if (yaexiste) {
            mostrarMensajeError("El jugador ya existe.");
            return;
        } else {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Seleccionar fotico");
            File archivo = fileChooser.showOpenDialog(null);
            if (archivo != null) {
                jugadores.get(indice).setNombre(introducir.getText());
                if (archivo != null) {
                    String rutaImagen = archivo.toURI().toString();
                    ImageView imageView = new ImageView(new Image(rutaImagen));
                    imageView.setFitWidth(75);
                    imageView.setFitHeight(75);
                    jugadores.get(indice).setFoto(imageView);
                    introducir.clear();
                }
            }
        }

    }


    private void mostrarMensajeError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    /**
     * Vuelve al menú
     * @param event 
     */
    @FXML
    private void pulsarvolver(ActionEvent event) {
        try {
            App.setRoot("menu");
        } catch (IOException ex) {
            Logger.getLogger(PlayerssController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
