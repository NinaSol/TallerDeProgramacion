package club.social;

public class Test {

	public static void agregarSocioTest(Club club, String nombre, int edad, Resultado resultadoEsperado) {
		Resultado resultado = club.agregarSocio(nombre, edad);

		if (resultado == resultadoEsperado) {
			System.out.println("Resultado esperado de agregar OK: " + resultado);
		} else {
			System.out.println("Resultado esperado de agregar FALLO: " + resultado);
		}
	}

	public static void establecerAmistadTest(Club club, String nombre1, String nombre2, Resultado resultadoEsperado) {
		Resultado resultado = club.establecerAmistad(nombre1, nombre2);

		if (resultado == resultadoEsperado) {
			System.out.println("Resultado esperado de establecer amistad OK: " + resultado);
		} else {
			System.out.println("Resultado esperado de establecer amistad FALLO: " + resultado);
		}
	}

	public static void deshacerAmistadTest(Club club, String nombre1, String nombre2, Resultado resultadoEsperado) {
		Resultado resultado = club.deshacerAmistad(nombre1, nombre2);

		if (resultado == resultadoEsperado) {
			System.out.println("Resultado esperado de deshacer amistad OK: " + resultado);
		} else {
			System.out.println("Resultado esperado de deshacer amistad FALLO: " + resultado);
		}
	}

	public static void main(String[] args) {
		Club club = new Club("Amigos Juniors");

		agregarSocioTest(club, "Juan", 23, Resultado.OK);
		agregarSocioTest(club, "Laura", 18, Resultado.OK);
		agregarSocioTest(club, "Maria", 26, Resultado.OK);
		agregarSocioTest(club, "Joaquin", 20, Resultado.OK);
		agregarSocioTest(club, "Belen", 20, Resultado.OK);
		agregarSocioTest(club, "Daniel", 21, Resultado.OK);
		agregarSocioTest(club, "Valeria", 20, Resultado.OK);
		agregarSocioTest(club, "Ana", 19, Resultado.OK);
		agregarSocioTest(club, "Javier", 22, Resultado.OK);
		agregarSocioTest(club, "Javier", 22, Resultado.YA_EXISTE);

		System.out.println("------------------");

		establecerAmistadTest(club, "Juan", "Ana", Resultado.OK);
		establecerAmistadTest(club, "Laura", "Ana", Resultado.OK);
		establecerAmistadTest(club, "Laura", "Juan", Resultado.OK);
		establecerAmistadTest(club, "Maria", "Ana", Resultado.OK);
		establecerAmistadTest(club, "Belen", "Joaquin", Resultado.OK);
		establecerAmistadTest(club, "Belen", "Daniel", Resultado.OK);
		establecerAmistadTest(club, "Valeria", "Ana", Resultado.OK);
		establecerAmistadTest(club, "Ana", "Daniel", Resultado.OK);
		establecerAmistadTest(club, "Javier", "Juan", Resultado.OK);
		establecerAmistadTest(club, "Javier", "Ana", Resultado.OK);
		establecerAmistadTest(club, "Ana", "Javier", Resultado.YA_SON_AMIGOS);
		establecerAmistadTest(club, "Ana", "Ana", Resultado.MISMA_PERSONA);
		establecerAmistadTest(club, "Laura", "Marcelo", Resultado.NO_EXISTE);
		establecerAmistadTest(club, "Toribio", "Ana", Resultado.NO_EXISTE);

		System.out.println("------------------");

		deshacerAmistadTest(club, "Ana", "Javier", Resultado.OK);
		deshacerAmistadTest(club, "Ana", "Valeria", Resultado.OK);
		deshacerAmistadTest(club, "Josefina", "Josefina", Resultado.MISMA_PERSONA);
		deshacerAmistadTest(club, "Laura", "Marcelo", Resultado.NO_EXISTE);
		deshacerAmistadTest(club, "Toribio", "Ana", Resultado.NO_EXISTE);

		System.out.println("------------------");

		club.listarSociosEdadSimilar();

		System.out.println("------------------");

		System.out.println(club.mostrarAmigosDeSocio("Laura"));

		club.mostrarAmigosDeSocio("Walter");

	}

}
