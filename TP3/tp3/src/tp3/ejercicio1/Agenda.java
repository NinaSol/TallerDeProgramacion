package tp3.ejercicio1;

import java.util.ArrayList;

public class Agenda {
	private ArrayList<Persona> personas;

	public Agenda() {
		this.personas = new ArrayList<Persona>();
	}

	public Persona buscarPersona(String dni) {
		Persona personaEncontrada = null;
		int i = 0;
		while(i < personas.size() && personaEncontrada == null) {
			Persona persona = personas.get(i);
			if (persona.getDni().equals(dni)) {
				personaEncontrada = persona;
			}else {
				i++;
			}
		}
	
		return personaEncontrada;
	}

	public boolean agregarPersona(String dni, String nombre, String domicilio) {
		boolean respuesta = false;

		if (this.buscarPersona(dni) == null) {
			Persona persona = new Persona(dni, nombre, domicilio);
			personas.add(persona);
			respuesta = true;
		}

		return respuesta;
	}

	public Persona removerPersona(String dni) {
		Persona persona = null;
		if (this.buscarPersona(dni) != null) {
			persona = this.buscarPersona(dni);
			this.personas.remove(persona);
		}
		return persona;
	}

	public boolean modificarDomicilio(String dni, String domicilio) {
		Persona persona = null;
		boolean respuesta = false;
		if (this.buscarPersona(dni) != null) {
			persona = this.buscarPersona(dni);
			persona.setDomicilio(domicilio);
			respuesta = true;
		}
		return respuesta;
	}

	public void listarPersonas() {
		for (Persona p : personas)
			p.mostrarDatos();
	}
	
	public Persona devolverUltimo() {
		Persona persona = null;
		int ultimo = this.personas.size() - 1;
		if(!this.personas.isEmpty()) {
			persona = this.personas.get(ultimo);
		}
		return persona;
	}
	
	public void eliminarTodosAMano() {
	for(int i = 0; i <= this.personas.size(); i++) {
			this.personas.remove(devolverUltimo());
		}

	}

}
