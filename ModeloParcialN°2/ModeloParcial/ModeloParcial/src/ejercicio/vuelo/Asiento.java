package ejercicio.vuelo;

	public class Asiento {
	//Se declaran como constante los precios de los asientos
	final static double TURISTA = 50000;
	final static double BUSINESS = 100000;
	final static double PRIMERA = 150000;
	//Atributos del asiento
	private Pasajero pasajero;
	private Clase clase;
	private double precio;
	//Constructor
	public Asiento(Pasajero pasajero, Clase clase) {
		setPasajero(pasajero);
		setClase(clase);
		setPrecioSegunClase(clase); //Llama al metodo para calcular el precio segun la clase
	}
    //Metodo para validar si el pasajero ya tiene asiento -> La logica de esto se aplica en Vuelo
	public boolean mismoPasajero(int dni) {
		return this.pasajero.mismoDni(dni); //-> es otro metodo que viene del Pasajero para indicar si tiene el mismo dni
	}
	
	//Getter y Setters
	public Pasajero getPasajero() {
		return pasajero;
	}
	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}
	public Clase getClase() {
		return clase;
	}
	public void setClase(Clase clase) {
		this.clase = clase;
	}
	public double getPrecio() {
		return precio;
	}
	
	
	//Metodo para asignar el precio segun el tipo de clase
	private void setPrecioSegunClase(Clase clase){
		if(Clase.PRIMERA.equals(this.clase)) {
			this.precio = PRIMERA;			
		}
		if(Clase.BUSINESS.equals(this.clase)) {
			this.precio = BUSINESS;			
		}
		if(Clase.TURISTA.equals(this.clase)) {
			this.precio = TURISTA;			
		}
	}
    //Mostrar la clase en pantalla
	@Override
	public String toString() {
		return "Asiento [pasajero=" + pasajero + ", clase=" + clase + ", precio=" + precio + "]";
	}
}
