package tp3.ejercicio8;

public class Ingrediente {
	private String nombre;
	private double cantNecesaria;
	private Tipo tipo;
	
	public Ingrediente(String nombre, double cantNecesaria, Tipo tipo) {
		this.nombre = nombre;
		this.cantNecesaria = cantNecesaria;
		this.tipo = tipo;
	}
	
	public double getCantNecesaria() {
		return this.cantNecesaria;
	}
	
	public boolean esRefrigerado(){
		return this.tipo == Tipo.REFRIGERADO;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public boolean mismoNombre(String nombre) {
		return this.nombre.equals(nombre);
	}
	
	
}
