package tp3.ejercicio4;

public class Perro {
	private String nombre;
	private Collar collar;
	private boolean moviendoCola;
	private Duenio duenio;
	
	public Perro(String nombre) {
		this.nombre = nombre;
		this.moviendoCola = false;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void ponerseCollar(Collar collar) {
		if(collar != null) {
		this.collar = collar;
		moverCola();
		}
	}
	
	
	private void moverCola() {
		this.moviendoCola = true;		
	}
	
	public Collar sacarseCollar() {
		Collar collar = this.collar;
		this.collar = null;
		return collar;
	}
	
	public boolean pediSalir() {
		return this.duenio.prepararPaseo(this);
	}
}
