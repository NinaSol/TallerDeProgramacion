package tp3.ejercicio4;

import java.util.ArrayList;

public class Duenio {
	private String nombre;
	private ArrayList<Perro> perros;
	private Perchero perchero;
	private Perro perroPaseando;

	public Duenio(String nombre) {
		this.nombre = nombre;
		this.perros = new ArrayList<Perro>();
		this.perchero = new Perchero();
		this.perroPaseando = null;
	}
	
	
	public Collar agregarCollar(String nombre) {
		return this.perchero.agregarCollar(new Collar(nombre));
	}
	
	public boolean adoptarPerro(String nombre) {
		boolean r = false;
		Perro perro = buscarPerro(nombre);
		if(perro == null) {
			this.perros.add(new Perro(nombre));
			r = true;
		}
		return r;
	}
	
	private Perro buscarPerro(String nombre) {
		int i = 0;
		int cantElementos = this.perros.size();
		Perro resultado = null;
		Perro busqueda;
		while(i < cantElementos && resultado == null) {
			busqueda = this.perros.get(i);
			if(busqueda.getNombre().equals(nombre)) {
				resultado = busqueda;
			}else {
				i++;
			}
		}
		return resultado;
	}

	public boolean prepararPaseo(String nombre) { 
		Perro perro = buscarPerro(nombre);
		boolean r = prepararPaseo(perro);
		return r;
	}
	
	public boolean prepararPaseo(Perro perro) {
		boolean resultado = false;
		if(perro != null && this.perroPaseando == null) {
			Collar collar = this.perchero.dameCollar(nombre);
			if(collar != null) {
				perro.ponerseCollar(collar);
				resultado = true;
				this.perroPaseando = perro;
			}
		}

		return resultado;
		
	}
	
	public boolean regresarPaseo(){
		boolean resultado = false;
		if(perroPaseando != null) {
			Collar collar = perroPaseando.sacarseCollar();
			if(collar != null) {
			perroPaseando = null;
			resultado = true;
			}
		}
		return resultado;
	}
	
	

}
