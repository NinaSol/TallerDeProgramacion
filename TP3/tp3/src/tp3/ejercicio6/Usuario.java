package tp3.ejercicio6;

import java.util.ArrayList;

public class Usuario {
	private String email;
	private String apellido;
	private int edad;
	private int cantEscuchada;
	private Categoria categoria;
	private ArrayList<Cancion> historial;
	
	public Usuario(String email, String apellido, int edad,Categoria categoria) {
		this.email = email;
		this.apellido = apellido;
		this.edad = edad;
		this.categoria = categoria;
		this.historial = new ArrayList<Cancion>();
		this.cantEscuchada = 0;
	}
	
	
	public String getEmail() {
		return this.email;
	}
	public Categoria getCategoria() {
		return this.categoria;
	}
	
	public void agregarHistorial(Cancion cancion) {
		this.historial.add(cancion);
		this.cantEscuchada++;
	}
	
	public int getCantEscuchada() {
		return this.historial.size();
	}
	
	public boolean esPremium() {
		return this.categoria == Categoria.PREMIUM;
	}

	
	public boolean chequearLimite() {
		return !((this.categoria == Categoria.GRATUITO) && (getCantEscuchada() > 50));
	}
	
	public void mostrarDatos() {
		System.out.println("Usuario: " + this.email + " Canciones escuchadas: " + this.getCantEscuchada());
	}
	
	public void mostrarHistorial() {
		for(Cancion c:this.historial) {
			c.mostrarDatos();
		}
	}
	

	
	
}
