package tp3.ejercicio14;

import java.util.ArrayList;

public class Torneo {
	private static final int CANT_HOYOS_MAX = 18;
	private ArrayList<Hoyo> hoyos;
	private ArrayList<Golfista> jugadores;

	public Torneo() {
		this.hoyos = new ArrayList<Hoyo>();
		this.jugadores = new ArrayList<Golfista>();
	}

	private boolean hoyosMaximos() {
		return this.hoyos.size() == CANT_HOYOS_MAX;
	}

	public Golfista buscarGolfista(String nombre, String apellido) {
		int i = 0;
		Golfista golfista = null;

		while (i < this.jugadores.size() && golfista == null) {
			Golfista golfistaEncontrado = this.jugadores.get(i);

			if (golfistaEncontrado.mismoNombre(nombre, apellido)) {
				golfista = golfistaEncontrado;
			}
		}
		return golfista;
	}

	public void agregarGolfista(String nombre, String apellido) {
		Golfista golfista = buscarGolfista(nombre, apellido);
		if (nombreValido(nombre) && nombreValido(apellido)) {
			if (golfista == null) {
				golfista = new Golfista(nombre, apellido);
				this.jugadores.add(golfista);
				System.out.println("Se registro " + nombre + " como el jugador numero " + golfista.getNumero());
			}
		}
	}

	private boolean nombreValido(String nombre) {
		return nombre != null;
	}

	private Hoyo buscarHoyo(int id) {
		int i = 0;
		Hoyo hoyo = null;

		while (i < this.hoyos.size() && hoyo == null) {
			Hoyo hoyoEncontrado = this.hoyos.get(i);

			if (hoyoEncontrado.mimsoId(id)) {
				hoyo = hoyoEncontrado;
			}
		}
		return hoyo;
	}

	public void agregarHoyo(int golpes, int id) {
		Hoyo hoyo = buscarHoyo(id);

		if (hoyo == null) {
			hoyo = new Hoyo(golpes, id);
			this.hoyos.add(hoyo);
		}
	}

	public void agregarJugada(String nombre, String apellido, int golpesUsado, int idHoyo) {
		Golfista golfista = buscarGolfista(nombre, apellido);
		Hoyo hoyo = buscarHoyo(idHoyo);

		if (golfista != null && hoyo != null) {
			if (!hoyosMaximos()) {
				golfista.agregarRegistro(golpesUsado, hoyo);
				System.out.println(
						golfista.getNombre() + " completo el hoyo " + idHoyo + " con " + golpesUsado + " golpes");
			}
		}
	}

	private ArrayList<Golfista> liderOLideres() {
		ArrayList<Golfista> lideres = new ArrayList<Golfista>();
		int min = Integer.MAX_VALUE;
		for (Golfista g : this.jugadores) {
			if (g.obetenerPuntaje() <= min) {
				if (g.obetenerPuntaje() < min) {
					lideres.clear();
					min = g.obetenerPuntaje();
				}
				lideres.add(g);
			}
		}

		return lideres;
	}

	public void listarLiderOLideres() {
		System.out.println("Lider(es) del torneo");
		for (Golfista g : liderOLideres()) {
			System.out.println(g);
		}
	}

	private ArrayList<Hoyo> hoyosNoVisitados() {
		ArrayList<Hoyo> hoyosNoVisitados = new ArrayList<Hoyo>();

		for (Hoyo h : this.hoyos) {
			if (h.cantGolfistas() == 0) {
				hoyosNoVisitados.add(h);
			}
		}

		return hoyosNoVisitados;
	}

	public void listarHoyosNoVisitados() {
		System.out.println("Hoyos no visitados");
		for (Hoyo h : hoyosNoVisitados()) {
			System.out.println(h);
		}
	}

}
