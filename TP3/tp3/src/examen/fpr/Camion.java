package examen.fpr;

import java.util.ArrayList;

public class Camion {
	private static final int MAX_KG = 3000;
	private ArrayList<Paquete> paquetes;
	private String patente;
	private double kgActual;

	public Camion(String patente) {
		setPatente(patente);
		this.paquetes = new ArrayList<Paquete>();
	}

	private void setPatente(String patente) {
		this.patente = patente;
	}

	public double getKgActual() {
		double total = 0;
		for (Paquete p : this.paquetes) {
			total += p.getKg();
		}
		return total;
	}

	private boolean hayLugar(Paquete paquete) {
		return (paquete.getKg() + this.kgActual) < MAX_KG;
	}

	public boolean cargarPaquete(Paquete paquete) {
		boolean agregado = false;
		if (paquete != null) {
			if (hayLugar(paquete)) {
				this.paquetes.add(paquete);
				agregado = true;
			}
		}
		return agregado;
	}

	
	public boolean mismaPatente(String patente) {
		return this.patente.equals(patente);
	}
	
	public void ordenarCarga() {
		
	}
}
