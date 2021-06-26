package ejercicio.vuelo;


public class Test {
	
	final static int CANTIDAD_ASIENTOS = 180;

	public static void main(String[] args) {
		Vuelo vuelo;
		
		vuelo = new Vuelo("AA3313”",CANTIDAD_ASIENTOS);
		
		System.out.println("--------Registro de pasajeros---------");
		System.out.println(vuelo.reservarAsiento(11111111, 1234567890, Clase.PRIMERA));
		System.out.println(vuelo.reservarAsiento(22222222, 1234567891, Clase.PRIMERA));
		System.out.println(vuelo.reservarAsiento(33333333, 1234567892, Clase.TURISTA));
		System.out.println(vuelo.reservarAsiento(44444444, 1234567894, Clase.TURISTA));
		System.out.println(vuelo.reservarAsiento(55555555, 1234567895, Clase.BUSINESS));
		System.out.println(vuelo.reservarAsiento(11111111, 1234567890, Clase.PRIMERA));
		System.out.println("--------Montos recaudados---------");
		vuelo.mostrarMontoRecaudadoDeClase(Clase.PRIMERA);
		vuelo.mostrarMontoRecaudadoDeClase(Clase.BUSINESS);
		vuelo.mostrarMontoRecaudadoDeClase(Clase.TURISTA);
		System.out.println("--------Asientos reservados---------");
		vuelo.listarAsientosReservados();
		System.out.println("--------Anulanding---------");
		vuelo.anularReserva(55555555);
		vuelo.anularReserva(99999999);
		System.out.println("--------Mostranding monto recaudado de Business---------");
		vuelo.mostrarMontoRecaudadoDeClase(Clase.BUSINESS);
		System.out.println("--------Asientos reservados---------");
		vuelo.listarAsientosReservados();	
	}

}
