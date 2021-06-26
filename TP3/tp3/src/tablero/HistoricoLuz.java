package tablero;

public class HistoricoLuz {
	private Lampara lampara;
	private Accion accion;

	public HistoricoLuz(Lampara lampara, Accion accion) {
		setLampara(lampara);
		setAccion(accion);
	}

	private void setLampara(Lampara lampara) {
		if (lampara != null) {
			this.lampara = lampara;
		}
	}

	private void setAccion(Accion accion) {
		if (accion != null) {
			this.accion = accion;
		}
	}

	@Override
	public String toString() {
		return "HistoricoLuz [lampara=" + lampara + ", accion=" + accion + "]";
	}
	
	

}
