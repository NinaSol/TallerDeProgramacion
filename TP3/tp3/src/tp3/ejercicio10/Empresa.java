package tp3.ejercicio10;

import java.util.ArrayList;

public class Empresa {
	private String nombre;
	private ArrayList<Carrera> carreras;

	public Empresa(String nombre) {
		this.nombre = nombre;
		this.carreras = new ArrayList<Carrera>();
	}

	private Carrera buscarCarrera(String fecha) {
		int i = 0;
		Carrera carrera = null;

		while (i < this.carreras.size() && carrera == null) {
			Carrera carreraEncontrada = this.carreras.get(i);

			if (carreraEncontrada.mismaFecha(fecha)) {
				carrera = carreraEncontrada;
			}
		}
		return carrera;
	}

	public ArrayList<Informe> pilotosPorCarrera() {
		ArrayList<Informe> pilotosPorCarrera = new ArrayList<Informe>();
		Informe informe;

		for (Carrera c : this.carreras) {
			informe = new Informe(c.getFecha(),c.cantidadPilotos());
			pilotosPorCarrera.add(informe);
		}
		return pilotosPorCarrera;
	}
	
	public void agregarCarrera(Carrera carrera) {
		Carrera busqueda = buscarCarrera(carrera.getFecha());
		
		if(busqueda == null) {
			this.carreras.add(carrera); 
		}
	}
}
