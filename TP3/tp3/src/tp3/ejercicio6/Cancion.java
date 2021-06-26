package tp3.ejercicio6;




public class Cancion {
	private String nombre;
	private String autor;
	private int diasDePublicacion;
	private int cantEscuchada;
	private String genero;
	private final int TOPE_DIAS = 7;
	private final int TOPE_ESCUCHADA = 1;
	
	public Cancion(String nombre, String autor, String genero, int diasDePublicacion) {
		this.nombre = nombre;
		this.autor = autor;
		this.genero = genero;
		this.diasDePublicacion = diasDePublicacion;
		this.cantEscuchada = 0;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	public String getAutor() {
		return this.autor;
	}
	
	public void reproducir() {
		this.cantEscuchada++;
	}
	
	public boolean getRestringida() {
		return this.diasDePublicacion <= this.TOPE_DIAS || this.cantEscuchada <= this.TOPE_ESCUCHADA;
	}
	
	public void mostrarDatos() {
		System.out.println("Nombre: " + getNombre() + " Autor: " + getAutor());
	}

	
	
}
