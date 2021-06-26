package tablero;

public class Telon {
	private boolean subido;

	public Telon() {
		setSubido(false);
	}

	private void setSubido(boolean subido) {
		this.subido = subido;
	}

	public boolean subir() {
		boolean resultado = false;
		if (!estaSubido()) {
			setSubido(true);
			resultado = true;
		}
		return resultado;
	}

	public boolean bajar() {
		boolean resultado = false;

		if (estaSubido()) {
			setSubido(false);
			resultado = true;
		}
		return resultado;
	}

	public boolean estaSubido() {
		return this.subido;
	}
}
