package tp3.ejercicio7;

public class Test {
	public static void registrarTurnoTest(AgendaMedica agenda,int dni,String nombre,String apellido,int tel,Registro respuestaEsperada) {
		Registro respuesta = agenda.registrarTurno(dni, nombre, apellido, tel);
		if(respuesta == respuestaEsperada) {
			System.out.println("Respuesta esperada de registro OK: " + respuesta);
		}else {
			System.out.println("Respuesta esperada de registro FALLO: " + respuesta);
		}
	}
	
	public static void darPresenteTest(AgendaMedica agenda,int dni,boolean respuestaEsperada) {
		boolean respuesta = agenda.darPresente(dni);
		if(respuesta == respuestaEsperada) {
			System.out.println("Respuesta esperada de presente OK: " + respuesta);
		}else {
			System.out.println("Respuesta esperada de presente FALLO: " + respuesta);
		}
	}
	
	public static void anularTurnoTest(AgendaMedica agenda,int dni,boolean respuestaEsperada) {
		boolean respuesta = agenda.anularTurno(dni);
		if(respuesta == respuestaEsperada) {
			System.out.println("Respuesta esperada de anulacion OK: " + respuesta);
		}else {
			System.out.println("Respuesta esperada de anulacion FALLO: " + respuesta);
		}
	}
	


	public static void main(String[] args) {
		AgendaMedica agenda = new AgendaMedica(3);
		System.out.println("Registro");
		registrarTurnoTest(agenda,34769012, "Juan","Gomez", 1165487932,Registro.TURNO_OK);
		registrarTurnoTest(agenda,34769013, "Juana","Gomez", 1165487932,Registro.TURNO_OK);
		registrarTurnoTest(agenda,34769013, "Juana","Gomez", 1165487932,Registro.YA_TIENE_TURNO);
		registrarTurnoTest(agenda,34769015, "Mario","Gomez", 1165487932,Registro.TURNO_OK);
		registrarTurnoTest(agenda,34769016, "Mario","Gomez", 1165487932,Registro.NO_HAY_MAS_TURNO);
		
		System.out.println("Presente");
		darPresenteTest(agenda,34769013,true);
		darPresenteTest(agenda,34769019,false);
		darPresenteTest(agenda,34769015,true);
		darPresenteTest(agenda,34769016,false);
		
		System.out.println("Anulacion");
		anularTurnoTest(agenda,34769013,true);
		
		System.out.println("Ausentes");
		System.out.println(agenda.obtenerAusentes());
		
		System.out.println("Turnos");
		agenda.listarTurnos();

		

	}

}
