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
	private Label lbNombre;
	
	@FXML
	private Label lbDescuento;
	
	@FXML
	private Label lbExtras;
	
	@FXML
	private Label lbCuotaMensual;
	
	@FXML
	private void initialize() {
		ObservableList<String> options = FXCollections.observableArrayList("Mensual", "Trimestral", "Anual");

		cmbCuota.setItems(options);
	}

	@FXML
	private void calcularCuota() {
		final String NAME_REGEX = "^[p{L}]+$";
		
		if (txtNombre.getText().isBlank() || txtNombre.getText().matches(NAME_REGEX)) {
			cmbCuota.setStyle("");
			txtNombre.setStyle("-fx-border-color: red; -fx-background-color: #ffe6e6; -fx-border-radius: 6;");

		} else if (cmbCuota.getValue() == null) {
			txtNombre.setStyle("");
			cmbCuota.setStyle("-fx-border-color: red; -fx-background-color: #ffe6e6; -fx-border-radius: 6;");

		} else {
			cmbCuota.setStyle("");
			txtNombre.setStyle("");
			QotCal cuota = new QotCal(txtNombre.getText(), cmbCuota.getValue(), chClasesDirigidas.isSelected(),
					chEntrenadorPersonal.isSelected());
			
			lbPagar.setText(cuota.fullCuota() + "");
			
			// M2 : Añadir nombre al resultado
			lbNombre.setText(cuota.getName().toUpperCase());
			
			
			lbDescuento.setText(cuota.getDescuento() + "%");
			lbExtras.setText(cuota.getExtras() + "");
			lbCuotaMensual.setText(cuota.getCuota());
			
			
			
		}
	}
	
	// M1 : Añadir boton limpiar
	@FXML
	private void limpiar() {
		txtNombre.setText("");
//		cmbCuota.setValue("");
		cmbCuota.getSelectionModel().clearSelection();
		chClasesDirigidas.setSelected(false);
		chEntrenadorPersonal.setSelected(false);
		lbPagar.setText("");
		lbNombre.setText("");
	}
	// M3 : Añadir desglose de la cuota
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}