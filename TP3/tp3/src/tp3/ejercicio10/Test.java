package tp3.ejercicio10;

public class Test {
	public static void main(String[] args) {
		Empresa empresa = new Empresa("CarrerasKarting");
		Carrera carrera = new Carrera("2/5/2021", "16:00", Dificultad.AVANZADO);

		carrera.agregarPiloto("Juan", "34567098");
		carrera.agregarVuelta("34567098", 120);

		empresa.agregarCarrera(carrera);

		System.out.println(empresa.pilotosPorCarrera());
		
		carrera.mostrarMenorPromedio();
		System.out.println(carrera.pilotosPorDebajoDe(200));

	}
}
