package tp3.ejercicio5;

import java.util.ArrayList;

public class Cliente {
	
	private int dni;
	private String nombre;
	private Subscripcion tipo;
	private double saldo;
	private ArrayList<Pelicula> historial;

	
	public Cliente(int dni,String nombre,Subscripcion tipo,double saldo) {
		this.dni = dni;
		this.nombre = nombre;
		this.tipo = tipo;
		this.saldo = saldo;
		this.historial = new ArrayList<Pelicula>();

	}
	
	public boolean saldarDeuda(double monto) {
		boolean saldado = false;
		if(monto > this.getSaldo()) {
			this.saldo = this.saldo - monto;
			saldado = true;
		}
		return saldado;
	}
	
	private double obtenerSaldo() {
		return this.saldo;
	}
	
	public boolean getDeudor() {
		return this.saldo > 0;
	}
	
	public void agregarHistorial(Pelicula pelicula) {
		this.historial.add(pelicula);
	}
	
	public int getDni() {
		return this.dni;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public Subscripcion getSubscripcion(){
		return this.tipo;
	}
	
	
	
	public int cantPelisVistas() {
		return this.historial.size();
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public void mostrarDatosDePeli(Subscripcion sub) {
		if(sub == getSubscripcion()) {
			System.out.println("Historial: " + this.historial);
		}
	}

	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nombre=" + nombre + ", tipo=" + tipo + ", saldo=" + saldo + ", historial="
				+ historial + "]";
	}
	
	

}
