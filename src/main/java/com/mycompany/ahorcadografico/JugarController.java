/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.ahorcadografico;

import com.mycompany.ahorcadografico.AjustesController;
import com.mycompany.ahorcadografico.App;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.Glow;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author dam1t
 */
public class JugarController implements Initializable {

    ColorAdjust coloradjust = new ColorAdjust();

    @FXML
    private ImageView fondo;
    @FXML
    private ImageView letraq;
    @FXML
    private ImageView letraw;
    @FXML
    private ImageView letrae;
    @FXML
    private ImageView letrar;
    @FXML
    private ImageView letrat;
    @FXML
    private ImageView letray;
    @FXML
    private ImageView letrau;
    @FXML
    private ImageView letrai;
    @FXML
    private ImageView letrao;
    @FXML
    private ImageView letrap;
    @FXML
    private ImageView letraa;
    @FXML
    private ImageView letras;
    @FXML
    private ImageView letrad;
    @FXML
    private ImageView letrag;
    @FXML
    private ImageView letrah;
    @FXML
    private ImageView letraj;
    @FXML
    private ImageView letrak;
    @FXML
    private ImageView letral;
    @FXML
    private ImageView letraz;
    @FXML
    private ImageView letrax;
    @FXML
    private ImageView letrac;
    @FXML
    private ImageView letrav;
    @FXML
    private ImageView letrab;
    @FXML
    private ImageView letran;
    @FXML
    private ImageView suicidarse;
    @FXML
    private ImageView letram;
    @FXML
    private ImageView horca;
    @FXML
    private ImageView tumba;
    @FXML
    private Text jugador;
    //private MediaPlayer reproductorsfx = new MediaPlayer(new Media(new File(this.getClass().getResource("hover.mp3").getPath()).toURI().toString()));
    private int ganar = 0;
    public static String palabraenjuego = "";

    private char letrapulsada;
    private String palabra;
    private StringBuilder espacios;
    private final String palabraEspacios = "";
    private int fallos = 0;
    public static String palabradescubierta;
    @FXML
    private ImageView letraf;
    @FXML
    private Text textoPalabra;

    /**
     * Llamamos al método "modo" para elegir la palabra y meteremos la palabra en un stringbuilder para hacer un stringbuilder de la palabra con sus espacios
     * entre letras. 
     * 
     * Llamamos a todas las imágenes. 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(AjustesController.sfx);
        palabra = modo();

        if (PlayerssController.indice >= 0) {
            jugador.setText(PlayerssController.jugadores.get(PlayerssController.indice).getNombre());
        }
        espacios = new StringBuilder(palabra);

        for (int i = 0; i < palabra.length(); i++) {
            espacios.setCharAt(i, '_');
        }

        String palabraEspacios = "";

        for (int i = 0; i < espacios.length(); i++) {
            palabraEspacios += espacios.charAt(i);
            palabraEspacios += " ";
        }

        textoPalabra.setText(palabraEspacios);

        try {
            // TODO
            horca.setImage(new Image(new FileInputStream(this.getClass().getResource("horca.png").getFile())));
            fondo.setImage(new Image(new FileInputStream(this.getClass().getResource("fondo.png").getFile())));
            letraa.setImage(new Image(new FileInputStream(this.getClass().getResource("A.png").getFile())));
            letrab.setImage(new Image(new FileInputStream(this.getClass().getResource("B.png").getFile())));
            letrac.setImage(new Image(new FileInputStream(this.getClass().getResource("C.png").getFile())));
            letrad.setImage(new Image(new FileInputStream(this.getClass().getResource("D.png").getFile())));
            letrae.setImage(new Image(new FileInputStream(this.getClass().getResource("E.png").getFile())));
            letraf.setImage(new Image(new FileInputStream(this.getClass().getResource("F.png").getFile())));
            letrag.setImage(new Image(new FileInputStream(this.getClass().getResource("G.png").getFile())));
            letrah.setImage(new Image(new FileInputStream(this.getClass().getResource("H.png").getFile())));
            letrai.setImage(new Image(new FileInputStream(this.getClass().getResource("I.png").getFile())));
            letraj.setImage(new Image(new FileInputStream(this.getClass().getResource("J.png").getFile())));
            letrak.setImage(new Image(new FileInputStream(this.getClass().getResource("K.png").getFile())));
            letral.setImage(new Image(new FileInputStream(this.getClass().getResource("L.png").getFile())));
            letram.setImage(new Image(new FileInputStream(this.getClass().getResource("M.png").getFile())));
            letran.setImage(new Image(new FileInputStream(this.getClass().getResource("N.png").getFile())));
            letrao.setImage(new Image(new FileInputStream(this.getClass().getResource("O.png").getFile())));
            letrap.setImage(new Image(new FileInputStream(this.getClass().getResource("P.png").getFile())));
            letraq.setImage(new Image(new FileInputStream(this.getClass().getResource("Q.png").getFile())));
            letrar.setImage(new Image(new FileInputStream(this.getClass().getResource("R.png").getFile())));
            letras.setImage(new Image(new FileInputStream(this.getClass().getResource("S.png").getFile())));
            letrat.setImage(new Image(new FileInputStream(this.getClass().getResource("T.png").getFile())));
            letrau.setImage(new Image(new FileInputStream(this.getClass().getResource("U.png").getFile())));
            letrav.setImage(new Image(new FileInputStream(this.getClass().getResource("V.png").getFile())));
            letraw.setImage(new Image(new FileInputStream(this.getClass().getResource("W.png").getFile())));
            letrax.setImage(new Image(new FileInputStream(this.getClass().getResource("X.png").getFile())));
            letray.setImage(new Image(new FileInputStream(this.getClass().getResource("Y.png").getFile())));
            letraz.setImage(new Image(new FileInputStream(this.getClass().getResource("Z.png").getFile())));
            suicidarse.setImage(new Image(new FileInputStream(this.getClass().getResource("suicidarse.png").getFile())));
            tumba.setImage(new Image(new FileInputStream(this.getClass().getResource("tumbajugador.png").getFile())));

            modo();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

       /**
     * Cuando salgamos del boton quitaremos el filtro. 
     * @param event
     * @throws URISyntaxException 
     */
    @FXML
    private void exit(MouseEvent event) {
        ImageView botoncico1 = (ImageView) event.getSource();
        if (!botoncico1.isDisabled()) {
            botoncico1.setEffect(null);
        }
    }

    /**
     * Cuando entres en un botón aplicamos un filtro para que se note cual vamos a pulsar. 
     * @param event
     * @throws URISyntaxException 
     */
    @FXML
    private void enter(MouseEvent event) throws URISyntaxException {
        ImageView botoncico1 = (ImageView) event.getSource();
        botoncico1.setEffect(new SepiaTone());
        //reproductorsfx = new MediaPlayer(new Media(new File(this.getClass().getResource("hover.mp3").getPath()).toURI().toString()));
       //reproductorsfx.setVolume(AjustesController.sfx);
        //reproductorsfx.play();
    }

    /** 
     * Aquí crearemos un contador para saber si has acertado la letra y sumarele uno, recorreremos con un for la palabra carácter a carácter 
     * para comprobar si es la misma letra. Cuando acumulemos un contador igual al número de letras ganaremos. 
     * 
     * Si ganamos sumaremos 100 puntos al jugador con el que estemos jugando.
     * @param c 
     */
    private void descubrirCaracter(char c) {
        int cont = 0;
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == c) {
                cont++;
                espacios.setCharAt(i, c);
                ganar++;
            }
        }
        if (ganar == palabra.length()) {
            try {
                if (PlayerssController.indice >= 0) {
                    PlayerssController.jugadores.get(PlayerssController.indice).setPuntos(PlayerssController.jugadores.get(PlayerssController.indice).getPuntos() + 100);
                }
                App.setRoot("ganar");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        /**
         * Si aciertas las siguientes líneas harán que la letra pulsada se vuelva verde e inutilizable, si fallas se aplicará lo mismo pero en rojo.
         * Si fallas más de 5 veces perderás y restaremos 50 puntos al jugador con el que se esté jugando. 
         */
        ImageView bloqueadas = bloquear();
        if (cont != 0) {
            bloqueadas.setEffect(null);
            bloqueadas.setEffect(new ColorAdjust(0.50, -0.02, 0.12, -0.34));
            bloqueadas.setDisable(true);
        } else {
            bloqueadas.setEffect(null);
            bloqueadas.setEffect(new ColorAdjust(-0.27, -0.05, 0.23, -0.15));
            bloqueadas.setDisable(true);
            fallos++;
            if (fallos > 5) {
                try {
                    if (PlayerssController.indice >= 0) {
                        PlayerssController.jugadores.get(PlayerssController.indice).setPuntos(PlayerssController.jugadores.get(PlayerssController.indice).getPuntos() - 50);
                    }
                    App.setRoot("perder");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            System.out.println(fallos);
            try {
                cambiarhorca();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Aquí cogeremos la palabra del fichero con dos buffers, uno para leer el archivo entero y otro para, con un número aleatorio, coger una palabra de ese archivo.
     * Ese número aleatorio será la línea de la palabra.
     * 
     * Utilizo un uppercase para, en caso de minúsculas, convertirlas en mayúsculas. 
     * @return 
     */
    private String leerpalabra() {
        int npalabras = 0;
        int v = 0;
        try {
            FileReader fr = new FileReader(new File(this.getClass().getResource("vegabaja.txt").getFile()));
            BufferedReader bufferedr = new BufferedReader(fr);
            String linea;

            while ((linea = bufferedr.readLine()) != null) {
                npalabras++;
            }
            fr.close();
            FileReader fr2 = new FileReader(new File(this.getClass().getResource("vegabaja.txt").getFile()));
            BufferedReader bufferedr2 = new BufferedReader(fr2);
            String linea2;

            int numeropalabra = (int) (Math.random() * npalabras + 1);

            while ((linea2 = bufferedr2.readLine()) != null) {
                v++;
                if (v == numeropalabra) {
                    return linea2.toUpperCase();
                }
            }
            palabra.toUpperCase();
            char[] letra = palabra.toCharArray();
            //cambiar_barrabaja(linea2, letra);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException io) {

        }

        return null;
    }

    /** 
     * Pulsar el botón suicidarse servirá para volver al menú, no tendrá penalización. 
     * @param event 
     */
    @FXML
    private void rendirse(MouseEvent event) {
        try {
            App.setRoot("menu");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Este método observará qué imagen(botón) hemos pulsado y con un switch llamaremos a la función descubrir carácter según la letra que hayamos pulsado.
     * @param event 
     */
    @FXML
    private void letraclick(MouseEvent event) {
        ImageView botoncico1 = (ImageView) event.getSource();
        System.out.println(botoncico1.getId());
        switch (botoncico1.getId()) {
            case "letraa":
                letrapulsada = 'A';
                descubrirCaracter(letrapulsada);
                break;
            case "letrab":
                letrapulsada = 'B';
                descubrirCaracter(letrapulsada);
                break;

            case "letrac":
                letrapulsada = 'C';
                descubrirCaracter(letrapulsada);
                break;

            case "letrad":
                letrapulsada = 'D';
                descubrirCaracter(letrapulsada);
                break;

            case "letrae":
                letrapulsada = 'E';
                descubrirCaracter(letrapulsada);
                break;

            case "letraf":
                letrapulsada = 'F';
                descubrirCaracter(letrapulsada);
                break;

            case "letrag":
                letrapulsada = 'G';
                descubrirCaracter(letrapulsada);
                break;

            case "letrah":
                letrapulsada = 'H';
                descubrirCaracter(letrapulsada);
                break;

            case "letrai":
                letrapulsada = 'I';
                descubrirCaracter(letrapulsada);
                break;

            case "letraj":
                letrapulsada = 'J';
                descubrirCaracter(letrapulsada);
                break;

            case "letrak":
                letrapulsada = 'K';
                descubrirCaracter(letrapulsada);
                break;

            case "letral":
                letrapulsada = 'L';
                descubrirCaracter(letrapulsada);
                break;

            case "letram":
                letrapulsada = 'M';
                descubrirCaracter(letrapulsada);
                break;

            case "letran":
                letrapulsada = 'N';
                descubrirCaracter(letrapulsada);
                break;

            case "letrao":
                letrapulsada = 'O';
                descubrirCaracter(letrapulsada);
                break;

            case "letrap":
                letrapulsada = 'P';
                descubrirCaracter(letrapulsada);
                break;

            case "letraq":
                letrapulsada = 'Q';
                descubrirCaracter(letrapulsada);
                break;

            case "letrar":
                letrapulsada = 'R';
                descubrirCaracter(letrapulsada);
                break;

            case "letras":
                letrapulsada = 'S';
                descubrirCaracter(letrapulsada);
                break;

            case "letrat":
                letrapulsada = 'T';
                descubrirCaracter(letrapulsada);
                break;

            case "letrau":
                letrapulsada = 'U';
                descubrirCaracter(letrapulsada);
                break;

            case "letrav":
                letrapulsada = 'V';
                descubrirCaracter(letrapulsada);
                break;

            case "letraw":
                letrapulsada = 'W';
                descubrirCaracter(letrapulsada);
                break;

            case "letrax":
                letrapulsada = 'X';
                descubrirCaracter(letrapulsada);
                break;

            case "letray":
                letrapulsada = 'Y';
                descubrirCaracter(letrapulsada);
                break;

            case "letraz":
                letrapulsada = 'Z';
                descubrirCaracter(letrapulsada);
                break;
        }

        String palabraEspacios = "";

        for (int i = 0; i < espacios.length(); i++) {
            palabraEspacios += espacios.charAt(i);
            palabraEspacios += " ";
        }
        palabradescubierta = palabra;
        textoPalabra.setText(palabraEspacios);
    }

    /**
     * Utilizo esta función para saber cuál fue la última letra pulsada y en la función en la que se utiliza "bloquear" se le aplica un filtro sepia y la bloqueo.
     * @return 
     */
    public ImageView bloquear() {
        switch (letrapulsada) {
            case 'A':
                return letraa;
            case 'B':
                return letrab;
            case 'C':
                return letrac;
            case 'D':
                return letrad;
            case 'E':
                return letrae;
            case 'F':
                return letraf;
            case 'G':
                return letrag;
            case 'H':
                return letrah;
            case 'I':
                return letrai;
            case 'J':
                return letraj;
            case 'K':
                return letrak;
            case 'L':
                return letral;
            case 'M':
                return letram;
            case 'N':
                return letran;
            case 'O':
                return letrao;
            case 'P':
                return letrap;
            case 'Q':
                return letraq;
            case 'R':
                return letrar;
            case 'S':
                return letras;
            case 'T':
                return letrat;
            case 'U':
                return letrau;
            case 'V':
                return letrav;
            case 'W':
                return letraw;
            case 'X':
                return letrax;
            case 'Y':
                return letray;
            case 'Z':
                return letraz;
        }
        return null;
    }

    /**
     * Por cada fallo se cambiará la foto de la horca. 
     * @throws FileNotFoundException 
     */
    public void cambiarhorca() throws FileNotFoundException {
        switch (fallos) {

            case 1:
                horca.setImage(new Image(new FileInputStream(this.getClass().getResource("horca1.png").getFile())));
                break;

            case 2:
                horca.setImage(new Image(new FileInputStream(this.getClass().getResource("horca2.png").getFile())));
                break;

            case 3:
                horca.setImage(new Image(new FileInputStream(this.getClass().getResource("horca3.png").getFile())));
                break;

            case 4:
                horca.setImage(new Image(new FileInputStream(this.getClass().getResource("horca4.png").getFile())));
                break;

            case 5:
                horca.setImage(new Image(new FileInputStream(this.getClass().getResource("horca5.png").getFile())));
                break;

            case 6:
                horca.setImage(new Image(new FileInputStream(this.getClass().getResource("horca6.png").getFile())));
                break;
        }
    }

    /**
     * Esta función hace que según el modo elegido se ejecute un bucle que busca la palabra entre las longitudes comprenididas según el modo elegido.
     * @return 
     */
    private String modo() {
        switch (AjustesController.modo) {
            case 1:
                do {
                    palabraenjuego = leerpalabra();
                } while (palabraenjuego.length() > 5);
                return palabraenjuego;

            case 2:
                do {
                    palabraenjuego = leerpalabra();
                } while (palabraenjuego.length() > 7 || palabraenjuego.length() < 5);
                return palabraenjuego;

            case 3:
                do {
                    palabraenjuego = leerpalabra();
                } while (palabraenjuego.length() < 8);
                return palabraenjuego;
        }
        return null;
    }

}
