package inmobiliaria.ej3;

public class Propiedad {
private String domicilio;
private double precio;
private Tipo tipo;

public Propiedad(String domicilio, double precio, Tipo tipo) {
	this.domicilio = domicilio;
	this.precio = precio;
	this.tipo = tipo;
}

public String getDomicilio() {
	return domicilio;
}

public double getPrecio() {
	return precio;
}

public Tipo getTipo() {
	return tipo;
}

public void mostrar() {
	System.out.println("Domicilio: " + getDomicilio() + " Precio: " + getPrecio());;
}




}
