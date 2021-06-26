package tp3.ejercicio1;

import java.util.ArrayList;

public class Test {

	public static void agregarPersonaTest(Agenda agenda, String dni, String nombre, String domicilio,
			boolean resultadoEsperado) {
		boolean resultado = agenda.agregarPersona(dni, nombre, domicilio);

		if (resultado == resultadoEsperado) {
			System.out.println("Resultado esperado OK: " + resultado);
		} else {
			System.out.println("Resultado esperado Fallo " + dni + resultado);
		}
	}

	public static void cambiarDomicilioTest(Agenda agenda, String dni, String domicilio, boolean respuestaEsperada) {
		boolean respuesta = agenda.modificarDomicilio(dni, domicilio);

		if (respuesta == respuestaEsperada) {
			System.out.println("Cambio esperado OK: " + respuesta);
		} else {
			System.out.println("Cambio esperado fallo: " + dni + respuesta);
		}
	}

	public static void main(String[] args) {
		Agenda agenda = new Agenda();

		System.out.println("Agregar");
		agregarPersonaTest(agenda, "23654789", "Fulano Gomez", "Yatay 240", true);
		agregarPersonaTest(agenda, "45654789", "Mengana Gutierrez", "Yatay 300", true);
		agregarPersonaTest(agenda, "23654123", "Fernanda Munioz", "Yatay 440", true);
		agregarPersonaTest(agenda, "23654123", "Fernanda Munioz", "Yatay 440", false);

		System.out.println("Remover");
		System.out.println(agenda.removerPersona("23654122"));
		agenda.removerPersona("23654123").mostrarDatos();

		System.out.println("Cambiar domicilio");
		cambiarDomicilioTest(agenda, "45654788", "Rio de Janeiro 440", false);
		cambiarDomicilioTest(agenda, "45654789", "Rio de Janeiro 440", true);

		System.out.println("Listado");
		agenda.listarPersonas();

		System.out.println("Buscar");
		agenda.buscarPersona("23654789").mostrarDatos();
		System.out.println(agenda.buscarPersona("23654123"));
		
		System.out.println("Ultimo");
		agenda.devolverUltimo().mostrarDatos();
		System.out.println("Lista vaciada");
		agenda.eliminarTodosAMano();
		
		agenda.listarPersonas();

	}

}
