package tp3.ejercicio2;

import java.util.ArrayList;

public class Area {
private String nombre;
private ArrayList<Oficina> oficinas;

public Area(String nombre) {
	this.nombre = nombre;
	this.oficinas = new ArrayList<Oficina>();
}


public boolean crearOficina(int n) {
	boolean resultado = false;
	if(buscarOficina(n) == null) {
		this.oficinas.add(new Oficina(n));
		resultado = true;
	}
	
	return resultado;
}

public Oficina buscarOficina(int n) {
	Oficina oficinaResultante = null;
	int i = 0;
	
	while(i<this.oficinas.size() && oficinaResultante == null) {
		Oficina oficina = this.oficinas.get(i);
		if(oficina.getNumero() == n) {
			oficinaResultante = oficina;
		}else {
			i++;
		}
	}
	
	return oficinaResultante;
	
}


public String getNombre() {
	return this.nombre;
}

public void mostrarDatos() {
	System.out.println("Nombre del area: " + this.nombre);
	for(Oficina oficina:oficinas) {
		oficina.mostrarDatos();
	}
}

}
