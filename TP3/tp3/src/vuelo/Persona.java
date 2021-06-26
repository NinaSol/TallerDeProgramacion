package vuelo;

public class Persona {
	private int dni;
	private int telefono;
	
	public Persona(int dni,int telefono) {
		this.dni = dni;
		this.telefono = telefono;
	}
	
	public int getDni() {
		return this.dni;
	}
	
	public boolean mismoDni(int dni) {
		return this.dni == dni;
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", telefono=" + telefono + "]";
	}
	

}
