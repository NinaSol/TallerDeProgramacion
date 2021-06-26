package examen.fpr;

import java.util.ArrayList;

public class Deposito {
	private String nombreProvincia;
	private ArrayList<Camion> camiones;
	private ArrayList<Paquete> paquetes;
	private Taller taller;

	public Deposito(String nombreProvincia, Taller taller) {
		setNombreProvincia(nombreProvincia);
		setTaller(taller);
		this.camiones = new ArrayList<Camion>();
		this.paquetes = new ArrayList<Paquete>();
	}

	private void setTaller(Taller taller) {
		if (taller != null) {
			this.taller = taller;
		}
	}

	private void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}

	public Camion buscarCamion(String patente) {
		int i = 0;
		Camion camion = null;

		while (i < this.camiones.size() && camion == null) {
			Camion camionEncontrado = this.camiones.get(i);

			if (camionEncontrado.mismaPatente(patente)) {
				camion = camionEncontrado;
			} else {
				i++;
			}
		}
		return camion;
	}
	
	public Paquete buscarPaquete(String codigo) {
		int i = 0;
		Paquete paquete = null;

		while (i < this.paquetes.size() && paquete == null) {
			Paquete paqueteEncontrado = this.paquetes.get(i);

			if (paqueteEncontrado.mismoCodigo(codigo)) {
				paquete = paqueteEncontrado;
			} else {
				i++;
			}
		}
		return paquete;
	}
	
	

	public boolean cargarPaquete(String codigo, double kg, String patente) {
		boolean cargado = false;
		Paquete paquete = buscarPaquete(codigo);
		if (paquete == null) {
			Camion camion = buscarCamion(patente);
			if (camion != null) {
				cargado = camion.cargarPaquete(paquete);
			}
		}
		return cargado;
	}

	
	public void distribuirCarga(Camion camion) {
		camion.ordenarCarga();
		
		
	}
	
}
