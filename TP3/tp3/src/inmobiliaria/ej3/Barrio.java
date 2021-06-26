package inmobiliaria.ej3;

import java.util.ArrayList;

public class Barrio {
	private String nombre;
	private ArrayList<Propiedad> propiedades;

	public Barrio(String nombre) {
		this.nombre = nombre;
		this.propiedades = new ArrayList<Propiedad>();
	}
	
	public String getNombre() {
		return this.nombre;
	}

	public void mostrarPropTipo(Tipo tipo) {
		for (Propiedad p : this.propiedades) {
			if (p.getTipo() == tipo) {
				p.mostrar();
			}
		}
	}

	public void mostrarProp() {
		for (Propiedad p : this.propiedades) {
			p.mostrar();
		}
	}

	public int cantProp() {
		return this.propiedades.size();
	}

	private Propiedad buscarPropiedad(String domicilio) {
		int i = 0;
		Propiedad resultado = null;
		while (i < this.propiedades.size() && resultado == null) {
			Propiedad p = this.propiedades.get(i);
			if (p.getDomicilio().equals(domicilio)) {
				resultado = p;
			} else {
				i++;
			}
		}
		return resultado;
	}

	public Propiedad borrarPropiedad(String domicilio) {
		Propiedad propBorrar = buscarPropiedad(domicilio);
		if (propBorrar != null) {
			this.propiedades.remove(propBorrar);
		}
		return propBorrar;
	}

//	private void borroPropiedad(Propiedad propiedad) {
//		if (propiedad != null) {
//			this.propiedades.remove(propiedad);
//		}
//	}
	
	

	public boolean agregarProp(Propiedad propiedad){//String domicilio, double precio, Tipo tipo) {
		boolean resultado = false;

			Propiedad prop = buscarPropiedad(propiedad.getDomicilio());
			if(prop == null) {
			 this.propiedades.add(propiedad);
			 resultado = true;
			}


		return resultado;

	}
}
