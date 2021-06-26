package tp3.ejercicio7;

import java.util.ArrayList;

public class AgendaMedica {
	private int cantTurnos;
	private ArrayList<Turno> turnos;
	private ArrayList<Paciente> ausentes;

	public AgendaMedica(int cantTurnos) {
		this.cantTurnos = cantTurnos;
		this.turnos = new ArrayList<Turno>();
		this.ausentes = new ArrayList<Paciente>();
	}

	private boolean turnosTope() {
		return this.turnos.size() == cantTurnos;
	}

	private Turno buscarTurno(int dni) {
		Turno resultado = null;
		Turno turno;
		Paciente paciente;
		int i = 0;
		int cantTurnos = this.turnos.size();

		while (i < cantTurnos && resultado == null) {
			turno = this.turnos.get(i);
			if (turno.mismoPaciente(dni)) {
				resultado = turno;
			} else {
				i++;
			}
		}
		return resultado;
	}

	public Registro registrarTurno(int dni, String nombre, String apellido, int telefono) {
		Turno turno = buscarTurno(dni);
		Registro respuesta = null;
		Paciente paciente;
		if (!turnosTope()) {
			if (turno == null) {
				paciente = new Paciente(dni, nombre, apellido, telefono);
				turno = new Turno(paciente);
				this.turnos.add(turno);
				respuesta = Registro.TURNO_OK;
			} else {
				respuesta = Registro.YA_TIENE_TURNO;
			}
		} else {
			respuesta = Registro.NO_HAY_MAS_TURNO;
		}
		return respuesta;
	}

	public void listarTurnos() {
		if (!this.turnos.isEmpty()) {
			System.out.println("Cantidad de turnos asignados: " + this.turnos.size());
			for (Turno t : this.turnos) {
				System.out.println(t);
			}
		} else {
			System.out.println("No hay turnos asignados");
		}
	}

	public boolean darPresente(int dni) {
		Turno turno = buscarTurno(dni);
		boolean presente = false;
		if (turno != null) {
			presente = turno.darPresente();
		}
		return presente;
	}

	public boolean anularTurno(int dni) {
		boolean eliminado = false;
		Turno turno = buscarTurno(dni);
		if (turno != null) {
			this.turnos.remove(turno);
			eliminado = true;
		}
		return eliminado;

		// otra variante seria el algoritmo de buscar pero igualar un booleano a true
		// while(!eliminado)
		// turnos.remove(i)
		// eliminado = true
	}

	private boolean anularTurnoWhile(int dni) {
		boolean eliminado = false;
		int i = 0;

		while (i < this.turnos.size() && !eliminado) {
			Turno turno = this.turnos.get(i);
			if (turno.mismoPaciente(dni)) {
				eliminado = this.turnos.remove(turno);
			} else {
				i++;
			}
		}
		return eliminado;
	}

	public ArrayList<Paciente> obtenerAusentes() {
		for (Turno t : this.turnos) {
			if (t.getAusente() != null) {
				this.ausentes.add(t.getAusente());
			}
		}
		return ausentes;
	}

}
