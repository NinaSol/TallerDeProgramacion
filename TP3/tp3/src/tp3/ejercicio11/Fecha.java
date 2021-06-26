package tp3.ejercicio11;

import java.time.LocalDate;

public class Fecha {

	private int dia;
	private int mes;
	private int anio;
	
	public Fecha(int dia, int mes, int anio) {
		setDia(dia);
		setMes(mes);
		setAnio(anio);
	}
	
	private void setDia(int dia) {
		this.dia = dia;
	}

	private void setMes(int mes) {
		this.mes = mes;
	}

	private void setAnio(int anio) {
		this.anio = anio;
	}
	
	public int getDia() {
		return dia;
	}

	public int getMes() {
		return mes;
	}

	public int getAnio() {
		return anio;
	}

	public static boolean esFechaMenor(Fecha fecha) {
		
		LocalDate hoy = LocalDate.now();
		LocalDate otraFecha = LocalDate.of(fecha.getAnio(), fecha.getMes(), fecha.getDia());
		
		return otraFecha.isBefore(hoy);
	}
	
	public static Fecha sumarDias(Fecha fecha, int dias) {		
		LocalDate laFecha = LocalDate.of(fecha.getAnio(), fecha.getMes(), fecha.getDia());
		laFecha = laFecha.plusDays(dias);
		return new Fecha(laFecha.getDayOfMonth(), laFecha.getMonthValue(), laFecha.getYear());
	}

	@Override
	public String toString() {
		return "Fecha [dia=" + dia + ", mes=" + mes + ", anio=" + anio + "]";
	} 
}
