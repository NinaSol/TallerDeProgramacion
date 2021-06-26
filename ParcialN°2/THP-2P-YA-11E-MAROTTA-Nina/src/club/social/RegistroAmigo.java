package club.social;
//mejorado
public class RegistroAmigo {
	private String nombre;
	private int edad;
	
	public RegistroAmigo(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "RegistroAmigo [nombre=" + nombre + ", edad=" + edad + "]";
	}
	
	
	
	
}
