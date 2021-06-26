package tp3.ejercicio8;

public class Producto {
	private String nombre;
	private double cantidad;
	private String fechaVto;
	
	public Producto(String nombre, double cantidad, String fechaVto) {
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.fechaVto = fechaVto;
	}
	
	public double getCantidad() {
		return this.cantidad;
	}
	
	public boolean mismoNombre(String nombre) {
		return this.nombre.equals(nombre);
	}
	
	
}
