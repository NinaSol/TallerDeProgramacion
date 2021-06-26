package ej2;

public class Persona {
	private String dni;
	private String nombre;
	private String apellido;
	private int telefono;
	private String mail;
	
	public Persona(String dni, String nombre, String apellido, int telefono, String mail) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.mail = mail;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	public String getApellido() {
		return this.apellido;
	}
	
	public String darNombreCompleto() {
		return "Nombre: " + getNombre() + " Apellido: " + getApellido();
	}
	
	
}
