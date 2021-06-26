package tp3.ejercicio10;

import java.util.ArrayList;

public class Piloto {
	private String nombre;
	private String dni;
	private ArrayList<Vuelta> vueltas;

	public Piloto(String nombre, String dni) {
		setNombre(nombre);
		setDni(dni);
		this.vueltas = new ArrayList<Vuelta>();
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private void setDni(String dni) {
		this.dni = dni;
	}

	private double cantVueltas() {
		return this.vueltas.size();
	}

	private double segsTotales() {
		double total = 0;
		for (Vuelta v : this.vueltas) {
			total += v.getTiempoEnSegs();
		}
		return total;
	}

	private double calcularPromedio() {
		return Matematica.obtenerPromedio(segsTotales(), cantVueltas());
	}

	public double getPromedio() {
		return calcularPromedio();
	}

	public boolean estaPorDebajo(int vueltasMin, double promedioMin) {
		return (cantVueltas() >= vueltasMin) && (calcularPromedio() <= promedioMin);
	}
	
	public boolean mismoDni(String dni) {
		return this.dni.equals(dni);
	}
	
	public void agregarVuelta(double tiempoEnSegs) {
		Vuelta vuelta = new Vuelta(tiempoEnSegs);
		this.vueltas.add(vuelta);
	}

	@Override
	public String toString() {
		return "Piloto [nombre=" + nombre + ", dni=" + dni + "]";
	}
	
	

}
