/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.ahorcadografico;

import com.mycompany.ahorcadografico.App;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Effect;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 *MENU
 * En el menú puedes elegir jugar, los ajustes del juego, la tabla de jugadores, o salir.
 * 
 *
 * @author dam1t
 */
public class MenuController implements Initializable {

    @FXML
    private ImageView jugarBoton;
    @FXML
    private ImageView ajustesBoton;
    @FXML
    private ImageView salirBoton;
    @FXML
    private ImageView horca;
    @FXML
    private ImageView fondoMenu;
    @FXML
    private ImageView titulo;
    private boolean reproduccion = false;
    //private MediaPlayer reproductorsfx = new MediaPlayer(new Media(new File(this.getClass().getResource("hover.mp3").getPath()).toURI().toString()));
    //private MediaPlayer reproductor = new MediaPlayer(new Media(new File(this.getClass().getResource("musicatitulo.mp3").getPath()).toURI().toString()));
    @FXML
    private Button jugadoresboton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            //reproductor.setVolume(AjustesController.musica);
            horca.setImage(new Image(new FileInputStream(this.getClass().getResource("horca.png").getFile())));
            jugarBoton.setImage(new Image(new FileInputStream(this.getClass().getResource("botonjugar.png").getFile())));
            salirBoton.setImage(new Image(new FileInputStream(this.getClass().getResource("botonsalir.png").getFile())));
            ajustesBoton.setImage(new Image(new FileInputStream(this.getClass().getResource("botonajustes.png").getFile())));
            fondoMenu.setImage(new Image(new FileInputStream(this.getClass().getResource("fondo.png").getFile())));
            titulo.setImage(new Image(new FileInputStream(this.getClass().getResource("cooltext.png").getFile())));
                //reproductor.stop();
                //reproductor = new MediaPlayer(new Media(new File(this.getClass().getResource("musicatitulo.mp3").getPath()).toURI().toString()));
                //reproductor.setVolume(AjustesController.musica);
                //reproductor.play();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void exit(MouseEvent event) {
        ImageView botoncico = (ImageView) event.getSource();
        botoncico.setEffect(null);
    }

    @FXML
    private void enter(MouseEvent event) {
        ImageView botoncico1 = (ImageView) event.getSource();
        botoncico1.setEffect(new SepiaTone());
        //reproductorsfx = new MediaPlayer(new Media(new File(this.getClass().getResource("hover.mp3").getPath()).toURI().toString()));
        //reproductorsfx.setVolume(AjustesController.sfx);
        //reproductorsfx.play();
    }

    @FXML
    private void salir(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void mostrarAjustes(MouseEvent event) throws IOException {
        App.setRoot("ajustes");
    }

    @FXML
    private void jugar(MouseEvent event) throws IOException {
        App.setRoot("jugar");
    }

    @FXML
    private void pulsarjugadores(ActionEvent event) {
        try {
            App.setRoot("playerss");
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
