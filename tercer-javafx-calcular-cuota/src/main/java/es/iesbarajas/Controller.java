package es.iesbarajas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;

public class Controller {

	@FXML
	private TextField txtNombre;

	@FXML
	private ComboBox<String> cmbCuota;

	@FXML
	private CheckBox chClasesDirigidas;

	@FXML
	private CheckBox chEntrenadorPersonal;

	@FXML
	private Label lbPagar;
	
	@FXML
	private void initialize() {
		ObservableList<String> options = FXCollections.observableArrayList("Mensual", "Trimestral", "Anual");

		cmbCuota.setItems(options);
	}

	@FXML
	private void calcularCuota() {

		if (txtNombre.getText().isBlank()) {
			cmbCuota.setStyle("");
			txtNombre.setStyle("-fx-border-color: red; -fx-background-color: #ffe6e6;");

		} else if (cmbCuota.getValue() == null) {
			txtNombre.setStyle("");
			cmbCuota.setStyle("-fx-border-color: red; -fx-background-color: #ffe6e6;");

		} else {
			cmbCuota.setStyle("");
			txtNombre.setStyle("");
			QotCal cuota = new QotCal(cmbCuota.getValue(), chClasesDirigidas.isSelected(),
					chEntrenadorPersonal.isSelected());
			
			lbPagar.setText(cuota.getCuota());
		}
	}
}