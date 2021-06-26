package tp3.ejercicio14;

public class Test {

	public static void main(String[] args) {
		Torneo torneo = new Torneo();

		torneo.agregarHoyo(0, 4);
		torneo.agregarHoyo(1, 2);
		torneo.agregarHoyo(2, 3);
		torneo.agregarHoyo(3, 5);
		torneo.agregarHoyo(4, 4);

		torneo.agregarGolfista("Angel", "Caverna");
		torneo.agregarGolfista("Augusto", "Barrioriver");
		torneo.agregarGolfista("Roberto", "Debisiesto");

		torneo.agregarJugada("Angel", "Caverna", 1, 3);
		torneo.agregarJugada("Augusto", "Barrioriver", 1, 4);
		torneo.agregarJugada("Roberto", "Debisiesto", 5, 3);
		torneo.agregarJugada("Angel", "Caverna", 1, 3);
		torneo.agregarJugada("Angel", "Caverna", 2, 3);
		torneo.agregarJugada("Augusto", "Barrioriver", 2, 2);
		torneo.agregarJugada("Roberto", "Debisiesto", 4, 3);

		torneo.listarLiderOLideres();
		torneo.listarHoyosNoVisitados();

	}

}
