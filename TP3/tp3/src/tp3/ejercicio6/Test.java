package tp3.ejercicio6;

public class Test {
	public static void escucharCancionTest(MusicaApp app, String email, String nombreCancion, String autor,
			Operacion respuestaEsperada) {
		Operacion respuesta = app.escucharCancion(email, nombreCancion, autor);
		if (respuesta == respuestaEsperada) {
			System.out.println("Respuesta esperada de escuchar cancion OK: " + respuesta);
		} else {
			System.out.println("Respuesta esperada de escuchar cancion FALLO: " + respuesta);
		}
	}

	public static void main(String[] args) {
		MusicaApp app = new MusicaApp("Spotify");

		app.altaCancion("hola", "juan", "pop", 10000);
		app.altaCancion("nueva", "juana", "rock", 5);

		app.altaUsuario("juan@gmail", "gomez", 43, Categoria.GRATUITO);
		app.altaUsuario("maria@gmail", "fernandez", 23, Categoria.STANDARD);
		app.altaUsuario("juana@gmail", "lopez", 18, Categoria.PREMIUM);

		escucharCancionTest(app,"juana@gmail", "hola", "juan",Operacion.CANCION_ESCUCHADA);
		escucharCancionTest(app,"juana@gmail", "hola", "juan",Operacion.CANCION_ESCUCHADA);
		escucharCancionTest(app,"juan@gmail", "nueva", "juana",Operacion.CANCION_NO_DISPONIBLE);
		escucharCancionTest(app,"juana@gmail", "nueva", "juana",Operacion.CANCION_ESCUCHADA);
		escucharCancionTest(app,"maria@gmail", "nueva", "juana",Operacion.CANCION_NO_DISPONIBLE);
		escucharCancionTest(app,"maria@gmail", "hola", "juan",Operacion.CANCION_ESCUCHADA);
		escucharCancionTest(app,"juan@gmail", "hola", "juan",Operacion.CANCION_ESCUCHADA);
		escucharCancionTest(app,"juan@gmail", "rgytdrf", "juan",Operacion.CANCION_INEXISTENTE);


		app.listarUsuarios();
		app.listarCancionesPorUsuario("maria@gmail");
		app.listarCancionesPorUsuario("juan@gmail");
		app.listarCancionesPorUsuario("juana@gmail");
		app.listarCancionesPorUsuario("juana@gmailsdf");

	}
}
