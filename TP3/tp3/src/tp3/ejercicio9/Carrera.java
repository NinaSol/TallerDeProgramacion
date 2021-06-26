package tp3.ejercicio9;

import java.util.ArrayList;

public class Carrera {
	private String nombre;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Candidato> candidatos;

	public Carrera(String nombre) {
		this.nombre = nombre;
		this.alumnos = new ArrayList<Alumno>();
		this.candidatos = new ArrayList<Candidato>();
	}

	public ArrayList<Candidato> obtenerCandidatos(double promedioMinimo) {
		for (Alumno a : this.alumnos) {
			if (hayEspacio() && a.posibleCandidato(promedioMinimo)) {
				Candidato candidato = new Candidato(a.getNombre(), a.getEmail());
				this.candidatos.add(candidato);
			}
		}
		return this.candidatos;
	}

	
	private boolean hayEspacio() {
		return this.candidatos.size() <= 20;
	}


}
