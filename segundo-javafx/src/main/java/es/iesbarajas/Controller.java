package es.iesbarajas;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
	@FXML
	private TextField email;
	@FXML
	private TextField password;
	@FXML
	private TextField rePassword;
	@FXML
	private Label errorMessage;

	@FXML
	public void borrarDatos() {
		email.setText("");
		password.setText("");
		rePassword.setText("");
		errorMessage.setText("");
	}

	@FXML
	public void validarDatos() {
		
		String error = ValAut.validar(email.getText(), password.getText(), rePassword.getText());
		
		if (error != null) {
			System.out.println(error);
			errorMessage.setText(error);
		} else {
			System.out.println("Contraseña válida!");
			errorMessage.setText("Contraseña válida!");
		}
	}
}
