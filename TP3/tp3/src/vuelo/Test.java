package vuelo;

public class Test {
	public static void main(String[] args) {
		Vuelo vuelo = new Vuelo("435786",4);
		
		System.out.println(vuelo.reservarAsiento(43657890, 1132457809, Clase.BUSINESS));
		System.out.println(vuelo.reservarAsiento(43657891, 1132457808, Clase.BUSINESS));
		System.out.println(vuelo.reservarAsiento(43657892, 1132457807, Clase.PRIMERA));
		System.out.println(vuelo.reservarAsiento(43657892, 1132457807, Clase.BUSINESS));
		System.out.println(vuelo.reservarAsiento(43657893, 1132457806, Clase.BUSINESS));
		System.out.println(vuelo.reservarAsiento(43657894, 1132457805, Clase.BUSINESS));
		
		vuelo.anularReserva(43657890);
		vuelo.anularReserva(43657894);
		
		vuelo.listarAsientosReservados();
		
		vuelo.mostrarMontoRecaudadoDeClase(Clase.BUSINESS);
		vuelo.mostrarMontoRecaudadoDeClase(Clase.PRIMERA);
		vuelo.mostrarMontoRecaudadoDeClase(Clase.TURISTA);



		
		
	}
}
