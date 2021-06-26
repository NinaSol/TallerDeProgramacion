package ejercicio.vuelo;


public class Pasajero {
	//Atributos
	private int dni;
	private int tel;
	
	//Constructor
	public Pasajero(int dni, int tel) {
		setDni(dni);
		setTel(tel);
	}
	
	//Preguntar si el DNI es el mismo -> pasa a Asiento y de Asiento a Vuelo
	public boolean mismoDni(int dni) {
		return this.dni == dni;
	}
	
	//Getters y Setters
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}

    //Mostrar por pantalla al pasajero
	@Override
	public String toString() {
		return "Pasajero [dni=" + dni + ", tel=" + tel + "]";
	}
	
	
	
	
	
	

}
