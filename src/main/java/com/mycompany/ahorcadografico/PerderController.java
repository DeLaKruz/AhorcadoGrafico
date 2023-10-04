/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.ahorcadografico;

import com.mycompany.ahorcadografico.App;
import com.mycompany.ahorcadografico.JugarController;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.effect.Effect;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**PERDER
 * Es lo que sale cuando no aciertas la palabra.
 * Puedes volver al menú
 *
 * @author dam1t
 */
public class PerderController implements Initializable {

    @FXML
    private ImageView fondo;
    @FXML
    private ImageView texto;
    @FXML
    private ImageView horca;
    @FXML
    private ImageView volvermenu;
    @FXML
    private Text erapalabra;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            horca.setImage(new Image(new FileInputStream(this.getClass().getResource("horca7.png").getFile())));
            texto.setImage(new Image(new FileInputStream(this.getClass().getResource("perdiste.png").getFile())));
            fondo.setImage(new Image(new FileInputStream(this.getClass().getResource("cementerio.png").getFile())));
            volvermenu.setImage(new Image(new FileInputStream(this.getClass().getResource("volvermenu.png").getFile())));
            erapalabra.setText(erapalabra.getText() + JugarController.palabradescubierta);
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
    private void volvermenu(MouseEvent event) throws IOException {
        App.setRoot("menu");
    }

}
