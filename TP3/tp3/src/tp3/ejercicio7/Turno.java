package tp3.ejercicio7;

public class Turno {
	private boolean presente;
	private Paciente paciente;

	public Turno(Paciente paciente) {
		setPaciente(paciente);
		this.presente = false;
	}

	private void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public String toString() {
		return "Datos del turno:\nPaciente: " + this.paciente + " Se presento: " + this.presente;
	}

	public Paciente getAusente() {
		Paciente paciente = null;
		if (!getPresente()) {
			paciente = this.paciente;
		}
		return paciente;
	}

	public boolean darPresente() {
		return this.presente = true;
	}

	public boolean mismoPaciente(int dni) {
		return this.paciente.mismoDni(dni);
	}

	private boolean getPresente() {
		return this.presente;
	}

}
