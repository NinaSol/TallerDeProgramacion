package tp3.ejercicio1;

public class Persona {
	private String dni;
	private String nombre;
	private String domicilio;

	public Persona(String dni, String nombre, String domicilio) {
		this.dni = dni;
		this.nombre = nombre;
		this.domicilio = domicilio;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public void mostrarDatos() {
		System.out.println("Nombre: " + this.nombre + " Dni: " + this.dni + " Direccion: " + this.domicilio);
	}

}
