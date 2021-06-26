package vuelo;

public class Asiento {
	private Persona pasajero;
	private Clase clase;
	private double precio;
	
	public Asiento(Persona pasajero,Clase clase) {
		this.clase = clase;
		this.pasajero = pasajero;
		setPrecioSegunClase();
	}
	
	
	private void setPrecioSegunClase() {
		if(clase == Clase.PRIMERA) {
			this.precio = 150000;
		}else if(clase == Clase.BUSINESS) {
			this.precio = 100000;
		}else if(clase == Clase.TURISTA) {
			this.precio = 50000;
		}
	}
	
	public double getPrecio() {
		return this.precio;
	}
	
	public boolean mismaClase(Clase clase) {
		return this.clase == clase;
	}
	
	public boolean mismoAsiento(int dni) {
		return pasajero.mismoDni(dni);
	}
	
	

	
	@Override
	public String toString() {
		return "Asiento [pasajero=" + pasajero + ", clase=" + clase + ", precio=" + precio + "]";
	}


	public Clase getClase() {
		return this.clase;
	}
}
