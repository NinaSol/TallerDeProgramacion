package tp3.ejercicio2;

import java.util.ArrayList;

public class Oficina {
private int numero;
private ArrayList<Empleado> empleados;
public Oficina(int numero) {
	this.numero = numero;
	this.empleados = new ArrayList<Empleado>();
}

public boolean crearEmpleado(String nombre) {
	boolean resultado = false;
	if(buscarEmpleado(nombre) == null) {
		this.empleados.add(new Empleado(nombre));
		resultado = true;
	}
	
	return resultado;
	
}

public Empleado buscarEmpleado(String nombre) {
	Empleado empleadoResultante = null;
	int i = 0;
	
	while(i<this.empleados.size() && empleadoResultante == null) {
		Empleado empleado = this.empleados.get(i);
		if(empleado.getNombre().equals(nombre)) {
			empleadoResultante = empleado;
		}else {
			i++;
		}
	}
	
	return empleadoResultante;

}

public int getNumero() {
	return this.numero;
}

public void mostrarDatos() {
	System.out.println("Numero de oficina: N°" + this.numero);
	for(Empleado empleado:empleados) {
		empleado.mostrarDatos();
	}
}
}
