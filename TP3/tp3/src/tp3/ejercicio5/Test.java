package tp3.ejercicio5;

public class Test {
	public static void testVerPeli(ORTFlix web, int dni, String pelicula, Respuesta respuestEsperada) {
		Respuesta respuesta = web.verPelicula(dni, pelicula);
		if (respuesta == respuestEsperada) {
			System.out.println("Resultado esperado de ver peli OK: " + respuesta);
		} else {
			System.out.println("Resultado esperado de ver peli FALLO: " + respuesta);
		}
	}

	public static void darDeAltaTest(ORTFlix web, int dni, String nombre, Subscripcion sub, double saldo,
			RespuestaAlta respuestaEsperada) {
		RespuestaAlta respuesta = web.darDeAlta(dni, nombre, sub, saldo);

		if (respuesta == respuestaEsperada) {
			System.out.println("Alta esperada OK: " + respuesta);
		} else {
			System.out.println("Alta esperada FALLO: " + respuesta);
		}

	}

	public static void darDeBajaTest(ORTFlix web, int dni, boolean respuestaEsperada) {
		boolean respuesta = web.darDeBaja(dni);

		if (respuesta == respuestaEsperada) {
			System.out.println("Baja esperada OK: " + respuesta);
		} else {
			System.out.println("Baja esperada FALLO: " + respuesta);
		}

	}

	public static void main(String[] args) {
		ORTFlix web = new ORTFlix();

		darDeAltaTest(web, 43231491, "Juan", Subscripcion.STANDARD, 0, RespuestaAlta.ALTA_OK);
		darDeAltaTest(web, 43231492, "Juana", Subscripcion.STANDARD, 0, RespuestaAlta.ALTA_OK);
		darDeAltaTest(web, 43231492, "Juana", Subscripcion.STANDARD, 0, RespuestaAlta.CLIENTE_EXISTENTE);
		darDeAltaTest(web, 43231493, "Maria", Subscripcion.STANDARD, 100, RespuestaAlta.ALTA_OK);
		darDeAltaTest(web, 43231494, "Mario", Subscripcion.PREMIUM, 0, RespuestaAlta.ALTA_OK);
		darDeAltaTest(web, 43231495, "Lucia", Subscripcion.PREMIUM, 100, RespuestaAlta.ALTA_OK);
		darDeAltaTest(web, 43231496, "Lucio", Subscripcion.PREMIUM, 200, RespuestaAlta.ALTA_OK);
		
		darDeBajaTest(web, 43231491, true);
		darDeBajaTest(web, 43231496, true);
		darDeBajaTest(web, 43231497, false);
		
		darDeAltaTest(web, 43231496, "Lucio", Subscripcion.PREMIUM, 200, RespuestaAlta.CLIENTE_DEUDOR);
		System.out.println("Depurar");
		web.depurarListNegra(300);
		darDeAltaTest(web, 43231496, "Lucio", Subscripcion.PREMIUM, 200, RespuestaAlta.ALTA_OK);
		
		web.agregarPelicula("Jumanji", Subscripcion.STANDARD);
		web.agregarPelicula("EndGame", Subscripcion.PREMIUM);
		
		testVerPeli(web, 43231495, "Jumanji", Respuesta.CLIENTE_DEUDOR);
		testVerPeli(web, 43231494, "EndGame", Respuesta.OK);
		testVerPeli(web, 43231493, "Mortal Kombat", Respuesta.CONTENIDO_INEXISTENTE);
		testVerPeli(web, 43231492, "EndGame", Respuesta.CONTENIDO_NO_DISPONIBLE);
		testVerPeli(web, 43231491, "Jumanji", Respuesta.CLIENTE_INEXISTENTE);
		
		System.out.println("Listado cant pelis");
		System.out.println(web.peliculasVistasPorClientes(Subscripcion.PREMIUM));
		

	}

}
