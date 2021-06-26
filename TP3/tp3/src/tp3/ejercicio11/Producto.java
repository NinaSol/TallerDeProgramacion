package tp3.ejercicio11;


public class Producto {
	private String nombre;
	private int maxDiasAlmacenado;
	private Fecha fechaAlmacenamiento;

	public Producto(String nombre, int maxDiasAlmacenado, Fecha fechaAlmacenamiento) {
		setNombre(nombre);
		setMaxDiasAlmacenado(maxDiasAlmacenado);
		setFechaAlmacenamiento(fechaAlmacenamiento);
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private void setMaxDiasAlmacenado(int maxDiasAlmacenado) {
		this.maxDiasAlmacenado = maxDiasAlmacenado;
	}

	private void setFechaAlmacenamiento(Fecha fechaAlmacenamiento) {
		this.fechaAlmacenamiento = fechaAlmacenamiento;
	}
	
	public boolean estaVencido() {
		return Fecha.esFechaMenor(Fecha.sumarDias(fechaAlmacenamiento, maxDiasAlmacenado));
	}
	
	public boolean mismoNombre(String nombre) {
		return this.nombre.equals(nombre);
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", maxDiasAlmacenado=" + maxDiasAlmacenado + ", fechaAlmacenamiento="
				+ fechaAlmacenamiento + "]\n";
	}
	
	

}
