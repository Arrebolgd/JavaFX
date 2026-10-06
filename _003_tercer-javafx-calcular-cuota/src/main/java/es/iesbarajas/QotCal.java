package es.iesbarajas;

public class QotCal {

	private static final double CUOTA_BASE = 35;
	private String name;
	private String tipoDeCuota;
	private boolean clasesDirigidas;
	private boolean entrenadorPersonal;
	
	private double descuento;
	private double cuota;
	
	public QotCal(String name,String meses, boolean clasesDirigidas, boolean entrenadorPersonal) {
		
		this.name = name;
		this.tipoDeCuota = meses;
		this.clasesDirigidas = clasesDirigidas;
		this.entrenadorPersonal = entrenadorPersonal;
		
		this.descuento = calcularDescuento();
		
		this.cuota = calcularCuota();
	}
	
	public String getCuota() {
		return String.valueOf(cuota);
	}
	
	public double getDescuento() {
		if(descuento == 0.9) return 10;
		if(descuento == 0.8) return 20;
		
		return 0;
	}
	
	public double getExtras() {
		double extras = 0;
		
		if(clasesDirigidas) extras += 10;
		if(entrenadorPersonal) extras += 20;
		
		return extras;
	}
	
	public String getName() {
		return name;
	}
	
	public double fullCuota() {
		if(tipoDeCuota.equalsIgnoreCase("trimestral")) return cuota * 3;
		if(tipoDeCuota.equalsIgnoreCase("anual")) return cuota * 12;
		
		return cuota;
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
