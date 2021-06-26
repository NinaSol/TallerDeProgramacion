package examen.fpr;

import java.util.ArrayList;

public class Empresa {
	private String nombre;
	private ArrayList<Deposito> depositos;
	
	
	public Empresa(String nombre) {
		setNombre(nombre);
		this.depositos = new ArrayList<Deposito>();
	}


	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
