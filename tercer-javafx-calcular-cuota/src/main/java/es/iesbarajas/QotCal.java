package es.iesbarajas;

public class QotCal {

	private static final double CUOTA_BASE = 35;
	
	private String tipoDeCuota;
	private boolean clasesDirigidas;
	private boolean entrenadorPersonal;
	
	private double descuento;
	private double cuota;
	
	public QotCal(String meses, boolean clasesDirigidas, boolean entrenadorPersonal) {
		
		this.tipoDeCuota = meses;
		this.clasesDirigidas = clasesDirigidas;
		this.entrenadorPersonal = entrenadorPersonal;
		
		this.descuento = calcularDescuento();
		
		this.cuota = calcularCuota();
	}
	
	public String getCuota() {
		return String.valueOf(cuota);
	}
	
	private double calcularDescuento() {
		if(tipoDeCuota.equalsIgnoreCase("trimestral")) return 0.9;
		if(tipoDeCuota.equalsIgnoreCase("anual")) return 0.8;
		
		return 1.0;
	}
	
	private double calcularCuota() {
		cuota = CUOTA_BASE;
		
		if(descuento != 0) cuota *= descuento;
		if(clasesDirigidas) cuota += 10;
		if(entrenadorPersonal) cuota += 25;
		
		return cuota;
	}
	

	
	
	
	
}
