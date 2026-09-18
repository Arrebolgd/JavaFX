package es.iesbarajas;

import javafx.fxml.FXML;
//import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    private Label lblMensaje;

    @FXML
    public void saludar() {
        lblMensaje.setText("¡Has pulsado el botón!");
    }
}