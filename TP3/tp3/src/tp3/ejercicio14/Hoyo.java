package tp3.ejercicio14;

import java.util.ArrayList;

public class Hoyo {
	private int id;
	private int golpesParaElPar;
	private ArrayList<Golfista> golfistas;

	public Hoyo(int golpesParaElPar, int id) {
		this.golpesParaElPar = golpesParaElPar;
		this.id = id;
		this.golfistas = new ArrayList<Golfista>();
	}

	public int getGolpesParaElPar() {
		return this.golpesParaElPar;
	}

	public int cantGolfistas() {
		return this.golfistas.size();
	}

	public boolean mimsoId(int id) {
		return this.id == id;
	}

	private Golfista buscarGolfista(int numero) {
		int i = 0;
		Golfista golfista = null;

		while (i < this.golfistas.size() && golfista == null) {
			Golfista golfistaEncontrado = this.golfistas.get(i);

			if (golfistaEncontrado.mismoNumero(numero)) {
				golfista = golfistaEncontrado;
			}
		}
		return golfista;
	}

	public boolean yaPaso(Golfista golfista) {
		return buscarGolfista(golfista.getNumero()) != null;
	}

	public void agregarJugador(Golfista golfista) {
		if (!yaPaso(golfista)) {
			this.golfistas.add(golfista);
		} else {
			System.out.println("ERROR: El jugador " + golfista.getNombre() + " ya paso por el hoyo " + this.id);
		}
	}

	@Override
	public String toString() {
		return "Hoyo [golpesParaElPar=" + golpesParaElPar + "]";
	}

}
