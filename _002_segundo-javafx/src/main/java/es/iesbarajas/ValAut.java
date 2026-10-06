package es.iesbarajas;


public class ValAut {

	private final static String REGEX_EMAIL = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
	private final static String REGEX_MINUS = ".*[a-z].*";
	private final static String REGEX_MAYUS = ".*[A-Z].*";
	private final static String REGEX_NUM = ".*[0-9].*";

	private ValAut() {};

	public static String validar(String email, String psw, String rePsw) {
		
		String errorEmail = validar(email);
		if (errorEmail != null) return errorEmail;
		
		String errorPsw = validar(psw, rePsw);
		if (errorPsw != null) return errorPsw;
		
		return null;
	}
	public static String validar(String email) {
		return validarEmail(email);
	}
	public static String validar(String psw, String rePsw) {
		
		String errorPsw = validarContrasena(psw);
		if (errorPsw != null) return errorPsw;
		
		if (!psw.equals(rePsw)) return "Las contraseñas no son iguales";
		
		return null;
	}
	
	// Validar email
	private static String validarEmail(String email) {
		if (email == null || email.isBlank()) return "El email está vacío.";
		if (!email.matches(REGEX_EMAIL)) return "El email no cumple los requisitos.";
		return null;
	}
	
	// Validar psw
	private static String validarContrasena(String psw) {
		if (psw == null || psw.isBlank()) return "La contraseña está vacía.";
		if (psw.contains(" ")) return "La contraseña contiene espacions";
		if (!psw.matches(REGEX_MINUS)) return "La contraseña no contiene minusculas";
		if (!psw.matches(REGEX_MAYUS)) return "La contraseña no contiene mayusculas";
		if (!psw.matches(REGEX_NUM)) return "La contraseña no contiene números";
		if (psw.length() < 8) return "La contraseña debe contener al menos 8 caracteres";
		return null;
	}
}