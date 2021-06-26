package tp3.ejercicio10;

public class Vuelta {
	private double tiempoEnSegs;

	public Vuelta(double tiempoEnSegs) {
		setTiempoEnSegs(tiempoEnSegs);
	}

	private void setTiempoEnSegs(double tiempoEnSegs) {
		this.tiempoEnSegs = tiempoEnSegs;
	}

	public double getTiempoEnSegs() {
		return tiempoEnSegs;
	}

}
