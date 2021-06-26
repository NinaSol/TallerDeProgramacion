package ej2;

public class Tarjeta {
	private String banco;
	private String numero;
	private double saldo;
	private Persona titular;
	private Entidad entidad;
	
	public Tarjeta(String banco, String numero, double saldo, Persona titular, Entidad entidad) {
		this.banco = banco;
		this.numero = numero;
		this.saldo = saldo;
		this.titular = titular;
		this.entidad = entidad;
	}
	
	public String getNombreCompletoTitular() {
		return this.titular.darNombreCompleto();
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public void cobrar(double monto) {
		if(calcularSaldo(monto)) {
		 this.saldo -= monto;
		}
	}
	
	public boolean calcularSaldo(double monto) {
		return monto <= getSaldo();
	}
	

	
	
}
