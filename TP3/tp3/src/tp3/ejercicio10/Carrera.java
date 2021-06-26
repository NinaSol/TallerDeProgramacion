package tp3.ejercicio10;

import java.util.ArrayList;

public class Carrera {
	private String fecha;
	private String hora;
	private Dificultad dificultad;
	private ArrayList<Piloto> pilotos;

	public Carrera(String fecha, String hora, Dificultad dificultad) {
		setFecha(fecha);
		setHora(hora);
		setDificultad(dificultad);
		this.pilotos = new ArrayList<Piloto>();
	}

	private void setFecha(String fecha) {
		this.fecha = fecha;
	}

	private void setHora(String hora) {
		this.hora = hora;
	}

	private void setDificultad(Dificultad dificultad) {
		this.dificultad = dificultad;
	}

	public boolean mismaFecha(String fecha) {
		return this.fecha.equals(fecha);
	}

	private Piloto buscarPiloto(String dni) {
		int i = 0;
		Piloto piloto = null;

		while (i < this.pilotos.size() && piloto == null) {
			Piloto pilotoEncontrado = this.pilotos.get(i);

			if (pilotoEncontrado.mismoDni(dni)) {
				piloto = pilotoEncontrado;
			}
		}
		return piloto;
	}

	public void agregarPiloto(String nombre, String dni) {
		Piloto piloto = buscarPiloto(dni);

		if (piloto == null) {
			piloto = new Piloto(nombre, dni);
			this.pilotos.add(piloto);
		}
	}
	
	public void agregarVuelta(String dni, double tiempoEnSegs) {
		Piloto piloto = buscarPiloto(dni);
		if (piloto != null) {
			piloto.agregarVuelta(tiempoEnSegs);
		}

	}

	public ArrayList<Piloto> pilotosPorDebajoDe(double promedioMin) {
		final int VUELTAS_MIN = 1; //0;
		ArrayList<Piloto> pilotosPorDebajo = new ArrayList<Piloto>();

		for (Piloto p : this.pilotos) {
			if (p.estaPorDebajo(VUELTAS_MIN, promedioMin)) {
				pilotosPorDebajo.add(p);
			}
		}
		return pilotosPorDebajo;
	}

	public String getFecha() {
		return fecha;
	}

	public void mostrarMenorPromedio() {
		double menor = Double.MAX_VALUE;
		Piloto pilotoMenor = null;

		for (Piloto p : this.pilotos) {
			if (p.getPromedio() < menor) {
				menor = p.getPromedio();
				pilotoMenor = p;
			}
		}

		if (pilotoMenor != null) {
			System.out.println("Piloto con menor promedio: " + pilotoMenor);
		}
	}

	public int cantidadPilotos() {
		return this.pilotos.size();
	}

}
