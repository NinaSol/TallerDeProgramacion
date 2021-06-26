package tp3.ejercicio4;

public class Collar {
	
	private String nombre;
	
	public Collar(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String toString() {
		return "Chapita: " + getNombre();
	}
	

}
