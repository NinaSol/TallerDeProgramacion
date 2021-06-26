package inmobiliaria.ej3;

import java.util.ArrayList;

public class Inmobiliaria {
	private ArrayList<Barrio> barrios;

	public Inmobiliaria() {
		this.barrios = new ArrayList<Barrio>();
	}

	public void mostrarProp() {
		for (Barrio b : this.barrios) {
			b.mostrarProp();
		}
	}

	public ArrayList<Barrio> obtenerBarrioMaxProp() {
		ArrayList<Barrio> barriosMaxProp = new ArrayList<Barrio>();
		int max = 0;
		for (Barrio b : this.barrios) {
			if (b.cantProp() > max) {
				max = b.cantProp();
			}else if (b.cantProp() == max) {
				barriosMaxProp.add(b);
			}
		}

		return barriosMaxProp;
	}

	public boolean cambiarPropiedadDeBarrio(String domicilio, String nombre) {
		boolean resultado = false;
		Barrio barrio = buscarBarrio(nombre);
		Propiedad prop  = borrarPropiedad(domicilio);
		if (prop != null && barrio != null) {
			barrio.agregarProp(prop);
			resultado = true;
		}
		return resultado;
	}

	public Propiedad borrarPropiedad(String domicilio) {
		int i = 0;
		Barrio barrio;
		Propiedad eliminado = null;
		while (i < this.barrios.size() && eliminado == null) {
			barrio = this.barrios.get(i);
			Propiedad borrar = barrio.borrarPropiedad(domicilio);
			if(borrar != null) {
				eliminado = borrar;
			}else {
				i++;
			}
		}
		return eliminado;
	}

	public boolean agregarPropiedad(String nombre, String domicilio, double precio, Tipo tipo) {
		boolean resultado = false;
		Barrio barrio = buscarBarrio(nombre);
		if (barrio != null) {
			barrio.agregarProp(new Propiedad(domicilio, precio, tipo));
			resultado = true;
		}
		return resultado;
	}

	public boolean agregarBarrio(String nombre) {
		boolean resultado = false;
		Barrio barrio = buscarBarrio(nombre);
		if (barrio == null) {
			barrio = new Barrio(nombre);
			this.barrios.add(barrio);
			resultado = true;
		}
		return resultado;
	}

	private Barrio buscarBarrio(String nombre) {
		int i = 0;
		Barrio resultado = null;
		while (i < this.barrios.size() && resultado == null) {
			Barrio b = this.barrios.get(i);
			if (b.getNombre().equals(nombre)) {
				resultado = b;
			} else {
				i++;
			}
		}
		return resultado;
	}

}
