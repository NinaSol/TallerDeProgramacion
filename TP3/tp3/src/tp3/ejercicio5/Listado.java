package tp3.ejercicio5;

public class Listado {
private String nombre;
private int cantPelis;

public Listado(String nombre, int cantPelis) {
	this.nombre = nombre;
	this.cantPelis = cantPelis;
}

public String toString() {
	return "Nombre: " + this.nombre + " Cant pelis: " + this.cantPelis;
}
}
