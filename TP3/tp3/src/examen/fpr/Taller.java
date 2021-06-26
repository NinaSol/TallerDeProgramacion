package examen.fpr;

import java.util.ArrayList;

public class Taller {
	private ArrayList<Camion> camionesReparacion;
	private String domicilio;
	private String telefono;
	
	public Taller(String domicilio, String telefono) {
		setDomicilio(domicilio);
		setTelefono(telefono);
	}

	private void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	private void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	
}
