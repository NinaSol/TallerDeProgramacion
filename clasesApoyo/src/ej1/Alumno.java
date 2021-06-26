package ej1;

public class Alumno {
	private String nombre;
	private int nota;
	
	public Alumno(String nombre, int nota) {
		this.nombre = nombre;
		this.nota = nota;
	}
	
	
	public String getNombre() {
		return nombre;
	}

	public int getNota() {
		return nota;
	}

	@Override
	public String toString() {
		return nombre + "(" + nota + ")";
	}
	
	public static void hola() {
		System.out.println("hola");
	}
	
}

