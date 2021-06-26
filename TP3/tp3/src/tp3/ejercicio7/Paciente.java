package tp3.ejercicio7;

public class Paciente {
	private int dni;
	private String nombre;
	private String apellido;
	private int telefono;
	
	public Paciente(int dni, String nombre, String apellido, int telefono) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
	}
	
	public int getDni() {
		return this.dni;
	}
	
	public boolean mismoDni(int dni) {
		return this.dni == dni;
	}



	public String getNombre() {
		return nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public int getTelefono() {
		return telefono;
	}



	public String toString() {
		return "Nombre y apellido: " + getNombre() + " " + getApellido() + " Dni: " + getDni() +" Telefono: " + getTelefono();
	}

}
