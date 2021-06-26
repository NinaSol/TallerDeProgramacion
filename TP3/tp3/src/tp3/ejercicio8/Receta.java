package tp3.ejercicio8;

import java.util.ArrayList;

public class Receta {
	private String codigo;
	private String nombre;
	private ArrayList<Ingrediente> ingredientes;
	
	public Receta(String codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.ingredientes = new ArrayList<Ingrediente>();
	}
	
	public ArrayList<Ingrediente> getIngredientes(){
		return this.ingredientes;
	}
	
	public boolean mismoNombre(String nombre) {
		return this.nombre.equals(nombre);
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	private Ingrediente buscarIngrediente(String nombre) {
		int i = 0;
		Ingrediente ingrediente = null;

		while (i < this.ingredientes.size() && ingrediente == null) {
			Ingrediente ingEncontrado = this.ingredientes.get(i);

			if (ingEncontrado.mismoNombre(nombre)) {
				ingrediente = ingEncontrado;
			} else {
				i++;
			}
		}
		return ingrediente;
	}
	
	public boolean agregarIngrediente(String nombre,double cant, Tipo tipo) {
		boolean resultado = false;
		Ingrediente ing = buscarIngrediente(nombre);
		
		if(ing == null) {
			ing = new Ingrediente(nombre,cant,tipo);
			this.ingredientes.add(ing);
			resultado = true;
		}
		return resultado;
	}
	
	
	@Override
	public String toString() {
		return "Receta [codigo=" + codigo + ", nombre=" + nombre + ", ingredientes=" + ingredientes + "]";
	}
	
	
	
	
}
