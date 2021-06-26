package tablero;

public class Lampara {
	private static int numero = 0;
	private int id;
	private boolean prendida;
	private Sector sector;
	private Color color;

	public Lampara(Sector sector, Color color) {
		this.id = incrementarNumero();
		setPrendida(false);
		setSector(sector);
		setColor(color);
	}

	private void setPrendida(boolean prendida) {
		this.prendida = prendida;
	}

	private void setSector(Sector sector) {
		if (sector != null) {
			this.sector = sector;
		}
	}

	private int incrementarNumero() {
		return ++numero;
	}

	private void setColor(Color color) {
		if (color != null) {
			this.color = color;
		}
	}

	public boolean mismoSector(Sector sector) {
		return this.sector == sector;
	}

	public boolean encender() {
		boolean resp = false;

		if (!estaPrendida()) {
			setPrendida(true);
			resp = true;
		}
		return resp;
	}

	public boolean apagar() {
		boolean resp = false;

		if (estaPrendida()) {
			setPrendida(false);
			resp = true;
		}
		return resp;
	}

	public boolean estaPrendida() {
		return this.prendida;
	}

	public boolean mismoId(int id) {
		return this.id == id;
	}

	public boolean mismoColor(Color color) {
		return this.color == color;
	}

	public void cambiarColor(Color color) {
		setColor(color);
	}

	@Override
	public String toString() {
		return "[id=" + id + ", prendida=" + prendida + ", sector=" + sector + ", color=" + color + "]";
	}
	
	
}
