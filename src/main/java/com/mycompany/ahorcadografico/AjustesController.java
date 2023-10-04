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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author dam1t
 */
public class AjustesController implements Initializable {

    @FXML
    private ImageView fondoajustes;
    @FXML
    private ImageView marco;
    @FXML
    private Slider slidersonido;
    @FXML
    private ImageView defecto;
    @FXML
    private ImageView volver;
    @FXML
    private Slider slidersfx;
    @FXML
    private RadioButton facil;
    @FXML
    private ToggleGroup dificultades;
    @FXML
    private RadioButton normal;
    @FXML
    private RadioButton dificil;
    public static int modo = 2;
    public static double sfx = 1;
    public static double musica = 0.7;

    public AjustesController() {
    }

    @Override

    /**
     * AJUSTES
     * Se pone el modo seleccionado, o por defecto
     * Se ajustan los volumenes y actualizo la variable modo para seleccionar la palabra más tarde
     * Se puede volver o restaurar los valores por defecto.
     */
    public void initialize(URL url, ResourceBundle rb) {
        slidersfx.setValue(0);
        switch (modo) {
            case 1:
                facil.setSelected(true);
                break;
            case 2:
                normal.setSelected(true);
                break;
            case 3:
                dificil.setSelected(true);
                break;
        }

        try {
            slidersfx.setValue(sfx);
            slidersonido.setValue(musica);
            fondoajustes.setImage(new Image(new FileInputStream(this.getClass().getResource("fondoajustes.png").getFile())));
            marco.setImage(new Image(new FileInputStream(this.getClass().getResource("marco.png").getFile())));
            defecto.setImage(new Image(new FileInputStream(this.getClass().getResource("pordefecto.png").getFile())));
            volver.setImage(new Image(new FileInputStream(this.getClass().getResource("volver.png").getFile())));
            slidersonido.setValue(100);
            slidersfx.setValue(100);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        slidersfx.valueProperty().addListener((o, ov, nv) -> {
            sfx = (double) nv;
            System.out.println(sfx);
        }
        );

        slidersonido.valueProperty().addListener((o, ov, nv) -> {
            musica = (double) nv;
            System.out.println(musica);
        }
        );

        System.out.println(modo);
        dificultades.selectedToggleProperty().addListener((o, ov, nv) -> {
            if (facil.isSelected()) {
                modo = 1;
            }
            if (normal.isSelected()) {
                modo = 2;
            }
            if (dificil.isSelected()) {
                modo = 3;
            }
            System.out.println(modo);
        }
        );
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
    private void pulsarPorDefecto(MouseEvent event) {
        slidersonido.setValue(100);
        slidersfx.setValue(100);
        dificultades.selectToggle(normal);
    }

    @FXML
    private void volverMenu(MouseEvent event) throws IOException {
        App.setRoot("menu");
    }

}
