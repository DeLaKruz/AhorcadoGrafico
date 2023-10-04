/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.ahorcadografico;

import com.mycompany.ahorcadografico.App;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author dam1t
 */
public class GanarController implements Initializable {

    @FXML
    private ImageView fondo;
    @FXML
    private ImageView ganartexto;
    @FXML
    private ImageView persona;
    @FXML
    private ImageView volvermenu;
    @FXML
    private Text erapalabra;

    /**
     * GANAR
     * Es la pantalla que sale cuando aciertas la palabra, se puede volver al menú
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        erapalabra.setText(erapalabra.getText() + JugarController.palabradescubierta);
        try {
            ganartexto.setImage(new Image(new FileInputStream(this.getClass().getResource("textoganar.png").getFile())));
            fondo.setImage(new Image(new FileInputStream(this.getClass().getResource("fondoganar.gif").getFile())));
            persona.setImage(new Image(new FileInputStream(this.getClass().getResource("persona.png").getFile())));
            volvermenu.setImage(new Image(new FileInputStream(this.getClass().getResource("volvermenu.png").getFile())));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void exit(MouseEvent event) {
        ImageView botoncico1 = (ImageView) event.getSource();
        botoncico1.setEffect(null);
    }

    @FXML
    private void enter(MouseEvent event) {
        ImageView botoncico1 = (ImageView) event.getSource();
        botoncico1.setEffect(new SepiaTone());
    }

    @FXML
    private void clickmenu(MouseEvent event) {
        try {
            App.setRoot("menu");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
