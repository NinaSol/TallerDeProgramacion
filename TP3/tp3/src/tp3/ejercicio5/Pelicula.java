package tp3.ejercicio5;

public class Pelicula {
	private String nombre;
	private Subscripcion tipo;
	
	public Pelicula(String nombre, Subscripcion tipo) {
		this.nombre = nombre;
		this.tipo = tipo;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public Subscripcion getTipo() {
		return this.tipo;
	}
	
	public String toString() {
		return "Nombre: " + this.nombre;
	}
	
}
