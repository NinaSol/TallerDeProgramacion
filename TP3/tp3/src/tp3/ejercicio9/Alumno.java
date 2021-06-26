package tp3.ejercicio9;

import java.util.ArrayList;

public class Alumno {
	private String nombre;
	private String email;
	private int materiasAprobadas = 0;
	private ArrayList<Materia> materias;
	
	public Alumno(String nombre, String email) {
		setNombre(nombre);
		setEmail(email);
		setCantMateriasAprobadas();
		this.materias = new ArrayList<Materia>();
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getEmail() {
		return this.email;
	}

	private void setCantMateriasAprobadas() {
		for(Materia m:this.materias) {
			if(m.getNotaFinal() >= 4) {
				this.materiasAprobadas++;
			}
		}
	}
	
	private double promedio() {
		double total = 0;
		int cantMaterias = this.materias.size();
		for(Materia m:this.materias) {
			total += m.getNotaFinal();
		}
		return total;
	}
	
	
	private boolean promedioApto(double promedioMinimo) {
		return promedio() >= promedioMinimo;
	}
	
	public boolean posibleCandidato(double promedioMinimo) {
		return promedioApto(promedioMinimo) && this.materiasAprobadas >= 5;
	}
	

	
	

}
