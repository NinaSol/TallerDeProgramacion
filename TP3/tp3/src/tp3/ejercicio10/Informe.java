package tp3.ejercicio10;

public class Informe {
	private String fechaCarrera;
	private int cantPiloto;
	
	
	public Informe(String fechaCarrera, int cantPiloto) {
		setFechaCarrera(fechaCarrera);
		setCantPiloto(cantPiloto);
	}


	private void setFechaCarrera(String fechaCarrera) {
		this.fechaCarrera = fechaCarrera;
	}


	private void setCantPiloto(int cantPiloto) {
		this.cantPiloto = cantPiloto;
	}


	@Override
	public String toString() {
		return "Informe [fechaCarrera=" + fechaCarrera + ", cantPiloto=" + cantPiloto + "]";
	}
	
	
	
	
	
}
