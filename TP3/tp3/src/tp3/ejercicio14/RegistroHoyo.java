package tp3.ejercicio14;

import java.util.ArrayList;

public class RegistroHoyo {
	private int golpesParaCompletar;
	private Hoyo hoyo;

	public RegistroHoyo(Hoyo hoyo,int golpesParaCompletar) {
		this.hoyo = hoyo;
		this.golpesParaCompletar = golpesParaCompletar;
	}
	
	public double obtenerPuntaje() {
		return this.golpesParaCompletar - hoyo.getGolpesParaElPar();
	}

	@Override
	public String toString() {
		return "RegistroHoyo [golpesParaCompletar=" + golpesParaCompletar + ", hoyo=" + hoyo + "]";
	}
	
	
	
	
}
