package tp3.ejercicio9;

public class Materia {
	private String nombre;
	private double notaFinal;
	
	public Materia(String nombre, double notaFinal) {
		setNombre(nombre);
		setNotaFinal(notaFinal);
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setNotaFinal(double notaFinal) {
		this.notaFinal = notaFinal;
	}
	
	public double getNotaFinal() {
		return this.notaFinal;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	
	

}
