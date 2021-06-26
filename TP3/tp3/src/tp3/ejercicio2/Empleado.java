package tp3.ejercicio2;

public class Empleado {
private String nombre;

public Empleado(String nombre) {
	this.nombre = nombre;
}

public String getNombre() {
	return this.nombre;
}

public void mostrarDatos() {
	System.out.println("Nombre del empleado: " + this.nombre);
}
}
