package tp3.ejercicio12;

import java.util.ArrayList;

public class Compania {
	private String nombre;
	private ArrayList<Area> areas;

	public Compania(String nombre) {
		this.nombre = nombre;
		this.areas = new ArrayList<Area>();
	}

	public boolean crearArea(String nombre) {
		boolean resultado = false;

		if (buscarArea(nombre) == null) {
			this.areas.add(new Area(nombre));
			resultado = true;
		}

		return resultado;

	}

	private Area buscarArea(String nombre) {
		Area areaResultante = null;
		int i = 0;
		while (i < this.areas.size() && areaResultante == null) {
			Area area = this.areas.get(i);
			if (area.getNombre().equals(nombre)) {
				areaResultante = area;
			} else {
				i++;
			}
		}

		return areaResultante;
	}



	public void agregarOficina(String nombreArea, int numero) {
		Area area = buscarArea(nombreArea);
		if(area != null) {
			area.crearOficina(numero);
		}
	}
	

	public void agregarEmpleado(String nombreArea,int numero,String nombre) {
		   Area area = buscarArea(nombreArea);
		   if(area != null) {
			   area.agregarEmpleado(numero,nombre);
		   }else {
			   crearArea(nombreArea);
		   }
	}

	public void listar() {
		this.mostrarDatos();
		for (Area area : this.areas) {
			area.mostrarDatos();
		}
	}

	public void mostrarDatos() {
		System.out.println("Nombre de la compania: " + this.nombre);
	}
}
